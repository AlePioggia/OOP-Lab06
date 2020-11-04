package it.unibo.oop.lab.exception2;



public class NotEnoughFoundsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1159808475879283028L;

	public NotEnoughFoundsException() {
		super();
	}

	public String toString() {
		return "NotEnoughFoundsException []";
	}

	public String getMessage() {
		return toString();
	}
	
	
	
}
