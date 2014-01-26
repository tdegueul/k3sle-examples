package fr.inria.diverse.k3.sle.examples.logo

import fr.inria.triskell.k3.Aspect
import fr.inria.triskell.k3.OverrideAspectMethod

import java.util.Hashtable

import kmLogo.Back
import kmLogo.Block
import kmLogo.Clear
import kmLogo.Constant
import kmLogo.Div
import kmLogo.Equals
import kmLogo.Expression
import kmLogo.Forward
import kmLogo.Greater
import kmLogo.If
import kmLogo.Instruction
import kmLogo.Left
import kmLogo.LogoProgram
import kmLogo.Lower
import kmLogo.Minus
import kmLogo.Mult
import kmLogo.Parameter
import kmLogo.ParameterCall
import kmLogo.PenDown
import kmLogo.PenUp
import kmLogo.Plus
import kmLogo.Primitive
import kmLogo.ProcCall
import kmLogo.ProcDeclaration
import kmLogo.Repeat
import kmLogo.Right
import kmLogo.While
import kmLogo.ControlStructure
import kmLogo.BinaryExp

import static extension fr.inria.diverse.k3.sle.examples.logo.InstructionAspect.*
import static extension fr.inria.diverse.k3.sle.examples.logo.BlockAspect.*
import static extension fr.inria.diverse.k3.sle.examples.logo.ExpressionAspect.*
import static extension fr.inria.diverse.k3.sle.examples.logo.ParameterAspect.*

@Aspect(className = Instruction)
class InstructionAspect {

	def int eval (Context context) {
		return 0
	}

}

@Aspect(className = Primitive)
public class PrimitiveAspect extends InstructionAspect {

	@OverrideAspectMethod
	def int eval (Context context) {
		return 0
	}

}

@Aspect(className = Back)
public class BackAspect extends PrimitiveAspect {

	@OverrideAspectMethod
	def int eval (Context context) {
		val param = -1 *  _self.steps.eval(context)
		println("BACK "+ param)
		context.turtle.forward(param)
		return 0
	}

}

@Aspect(className = Forward)
public class ForwardAspect extends PrimitiveAspect {

	@OverrideAspectMethod
	def int eval (Context context) {
		val param = _self.steps.eval(context)
		println("FORWARD " + param)
		context.turtle.forward(param)
		return 0
	}

}

@Aspect(className = Left)
public class LeftAspect extends PrimitiveAspect {

	@OverrideAspectMethod
	def int eval (Context context) {
		var int param = -1  * _self.angle.eval(context)
		println("LEFT " + param)
		context.turtle.rotate(param)
		return 0
	}

}

@Aspect(className = Right)
public class RightAspect extends PrimitiveAspect {

	@OverrideAspectMethod
	def int eval (Context context) {
		val param = _self.angle.eval(context)
		println("RIGHT " + param)
		context.turtle.rotate(param)
		return 0
	}

}

@Aspect(className = PenDown)
public class PenDownAspect extends PrimitiveAspect {

	@OverrideAspectMethod
	def int eval (Context context) {
		println("PENDOWN")
		context.turtle.penUp = false
		return 0
	}

}

@Aspect(className = PenUp)
public class PenUpAspect extends PrimitiveAspect {

	@OverrideAspectMethod
	def int eval (Context context) {
		println("PENUP")
		context.turtle.penUp = true
		return 0
	}

}

@Aspect(className = Clear)
public class ClearAspect extends PrimitiveAspect {

	@OverrideAspectMethod
	def int eval (Context context) {
		println("CLEAR")
		context.turtle.reset
		return 0
	}

}

@Aspect(className = Expression)
public class ExpressionAspect extends InstructionAspect {

	@OverrideAspectMethod
	def int eval (Context context) {
		return 0
	}

}

@Aspect(className = Constant)
public class ConstantAspect extends ExpressionAspect {

	@OverrideAspectMethod
	def int eval (Context context) {
		return _self.integerValue
	}

}

@Aspect(className = ProcCall)
public class ProcCallAspect extends ExpressionAspect {
	int res = 0

	@OverrideAspectMethod
	def int eval (Context context) {
		println("Calling of : " + _self.declaration.name)
		val params = new Hashtable<String, Integer>

		_self.actualArgs.forEach[Expression exp, int i |
			val currentArg = exp.eval(context)
			params.put(_self.declaration.args.get(i).name, currentArg)
		]

		context.push(params)

		_self.res = 0
		_self.declaration.instructions.forEach[Instruction i | _self.res = i.eval(context)]

		context.pop
		return _self.res
	}

}

@Aspect(className = ProcDeclaration)
public class ProcDeclarationAspect extends ExpressionAspect {

	@OverrideAspectMethod
	def int eval(Context context) {
		return 0
	}

}

@Aspect(className = Block)
public class BlockAspect extends ExpressionAspect {
	int res = 0

	@OverrideAspectMethod
	def int eval (Context context) {
		_self.instructions.forEach[Instruction i | _self.res = i.eval(context)]
		return _self.res
	}

}

@Aspect(className = ControlStructure)
public class ControlStructureAspect extends InstructionAspect {

	@OverrideAspectMethod
	def int eval (Context context) {
		return 0
	}

}

@Aspect(className = If)
public class IfAspect extends ControlStructureAspect {

	@OverrideAspectMethod
	def int eval (Context context) {
		return
			if (_self.condition.eval(context) != 0)
				_self.thenPart.eval(context)
			else
				_self.elsePart.eval(context)
	}

}

@Aspect(className = Repeat)
public class RepeatAspect extends ControlStructureAspect {

	@OverrideAspectMethod
	def int eval (Context context) {
		var time = _self.condition.eval(context)

		while (time > 0) {
			_self.block.eval(context)
			time = time - 1
		}

		return 0
	}

}

@Aspect(className = While)
public class WhileAspect extends ControlStructureAspect {

	@OverrideAspectMethod
	def int eval (Context context) {
		while (_self.condition.eval(context) > 0) {
			_self.block.eval(context)
		}

		return 0
	}

}

@Aspect(className = Parameter)
public class ParameterAspect {

	def int eval (Context context) {
		return context.peek.get(_self.name)
	}

}

@Aspect(className = ParameterCall)
public class ParameterCallAspect extends ExpressionAspect {

	@OverrideAspectMethod
	def int eval (Context context) {
		return _self.parameter.eval(context)
	}

}

@Aspect(className = BinaryExp)
public class BinaryExpAspect extends ExpressionAspect {

	def int eval (Context context) {
		return 0
	}

}

@Aspect(className = Plus)
public class PlusAspect extends BinaryExpAspect {

	@OverrideAspectMethod
	def int eval (Context context) {
		return _self.lhs.eval(context) + _self.rhs.eval(context)
	}

}

@Aspect(className = Minus)
public class MinusAspect extends BinaryExpAspect {

	@OverrideAspectMethod
	def int eval (Context context) {
		return _self.lhs.eval(context) - _self.rhs.eval(context)
	}

}

@Aspect(className = Mult)
public class MultAspect extends BinaryExpAspect {

	@OverrideAspectMethod
	def int eval (Context context) {
		return _self.lhs.eval(context) * _self.rhs.eval(context)
	}

}

@Aspect(className = Div)
public class DivAspect extends BinaryExpAspect {

	@OverrideAspectMethod
	def int eval (Context context) {
		return
			if (_self.rhs.eval(context) != 0)
				_self.lhs.eval(context) / _self.rhs.eval(context)
			else
				0
	}

}

@Aspect(className = Equals)
public class EqualsAspect extends BinaryExpAspect {

	@OverrideAspectMethod
	def int eval (Context context) {
		return
			if (_self.lhs.eval(context) == _self.rhs.eval(context))
				1
			else
				0
	}

}

@Aspect(className = Greater)
public class GreaterAspect extends BinaryExpAspect {

	@OverrideAspectMethod
	def int eval (Context context) {
		return
			if (_self.lhs.eval(context) > _self.rhs.eval(context))
				1
			else
				0
	}

}

@Aspect(className = Lower)
public class LowerAspect extends BinaryExpAspect {

	def int eval (Context context) {
		return
			if (_self.lhs.eval(context) < _self.rhs.eval(context))
				1
			else
				0
	}

}

@Aspect(className = LogoProgram)
public class LogoProgramAspect {

	def int eval (Context context) {
		println("LogoProgram eval !")
		_self.instructions.forEach[Instruction i | i.eval(context)]
		return 0
	}

}
