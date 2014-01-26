package fr.inria.diverse.k3.sle.examples.logo

import java.util.Hashtable
import java.util.ArrayList

class Context
{
	ArrayList<Hashtable<String,Integer>> stack = new ArrayList<Hashtable<String,Integer>>
	public Turtle turtle = new Turtle

	def reset () {
		stack = new ArrayList<Hashtable<String,Integer>>
	}

	def peek() {
		return stack.last
	}

	def pop() {
		stack.remove(stack.size - 1)
		return stack.last
	}

	def push(Hashtable<String,Integer> elem) {
		stack.add(elem)
	}
}
