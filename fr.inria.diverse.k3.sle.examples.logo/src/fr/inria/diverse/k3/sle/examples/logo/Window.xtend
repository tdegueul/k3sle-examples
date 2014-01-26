package fr.inria.diverse.k3.sle.examples.logo

import javax.swing.JFrame
import java.awt.Graphics
import javax.swing.JPanel

class Window
{
	JFrame frame

	new(Turtle t) {
		frame = new JFrame => [
			setBounds(100, 100, 500, 500)
			defaultCloseOperation = JFrame.EXIT_ON_CLOSE
			title = "Logo example"
			visible = true

			add(new Board(t))
		]
	}
}

class Board extends JPanel
{
	Turtle turtle

	new(Turtle t) {
		turtle = t
	}

	override paint(Graphics g) {
		turtle.drawings.forEach[seg |
			g.drawLine(
				seg.begin.x as int, seg.begin.y as int,
				seg.end.x as int,   seg.end.y as int
			)
		]
	}
}