package fr.inria.diverse.k3.sle.examples.fsm

import fr.inria.triskell.k3.Aspect

import timedfsm.FSM
import timedfsm.State
import timedfsm.Transition

import static extension fr.inria.diverse.k3.sle.examples.fsm.TimedFsmAspect.*
import static extension fr.inria.diverse.k3.sle.examples.fsm.TimedStateAspect.*
import static extension fr.inria.diverse.k3.sle.examples.fsm.TimedTransitionAspect.*

@Aspect(className = FSM)
class TimedFsmAspect
{
	State current

	def void execute(String input) {
		if (_self.current == null)
			_self.current = _self.initialState

		for (i : 0 ..< input.length) {
			try
			{
				_self.current.step(input.charAt(i))
			} catch (NoFireableTransition e) {
				println("No fireable transition in " + _self.current.name + " for input " + input.charAt(i))
				return
			} catch (NonDeterminism e) {
				println("Non-determinism in " + _self.current.name + " for input " + input.charAt(i))
				return
			}
		}
	}
}

@Aspect(className = State)
class TimedStateAspect
{
	def void step(char c) {
		val validTrans = _self.outgoingTransition.filter[input.equals(String.valueOf(c))]

		if (validTrans.empty)
			throw new NoFireableTransition
		if (validTrans.size > 1)
			throw new NonDeterminism

		validTrans.head.fire
	}
}

@Aspect(className = Transition)
class TimedTransitionAspect
{
	def void fire() {
		print(_self.output + "(" + _self.waitingTime + ")")
		_self.source.owningFSM.current = _self.target
	}
}

abstract class FsmException extends Exception {}
class NoFireableTransition extends FsmException {}
class NonDeterminism extends FsmException {}
