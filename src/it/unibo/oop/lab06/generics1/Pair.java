package it.unibo.oop.lab06.generics1;

public class Pair<X,Y> {
	
	private final X first;
	private final Y second;
	
	public Pair(final X first,final Y second) {
		this.first = first;
		this.second = second;
	}
	
	public X getFirst() {
		return this.first;
	}

	public Y getSecond() {
		return this.second;
	}
	
	@Override
	public String toString() {
		return "Pair [first=" + this.first + ", second=" + this.second + "]";
	}

	
}
