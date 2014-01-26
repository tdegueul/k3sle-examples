package fr.inria.diverse.k3.sle.examples.logo

import java.util.ArrayList

class Point
{
	public double x
	public double y

	new(double a, double b) {
		x = a
		y = b
	}

	def getDelta(double dx, double dy) {
		new Point(x + dx, y + dy)
	}

	override toString()'''
		[«x», «y»]
	'''

}

class Segment
{
	public Point begin
	public Point end

	new(Point orig , Point dest) {
		begin = orig
		end = dest
	}
}

class Turtle
{
	Point position
	double heading
	boolean penUp
	public ArrayList<Segment> drawings

	new() {
		reset
	}

	def reset() {
		position = new Point(0, 0)
		heading  = 0
		penUp    = true
		drawings = new ArrayList<Segment>

	}

	def setPenUp(boolean b) {
		penUp = b
	}

	def rotate(int angle) {
		heading = (heading + angle) % 360
	}

	def move(double dx, double  dy) {
		val newPos = position.getDelta(dx, dy)
		if(penUp)
			println("Turtle move to " + newPos)
		else {
			println("Turtle trace to "+ newPos)
			drawings.add(new Segment(position,newPos))
		}
		position = newPos
	}

	def forward(int steps) {
	    val radian = Math.toRadians(heading)
		move(scale(steps, Math.sin(radian)), scale(steps, Math.cos(radian)))
	}

	def scale(int steps, double factor) {
		return steps * factor
	}
}
