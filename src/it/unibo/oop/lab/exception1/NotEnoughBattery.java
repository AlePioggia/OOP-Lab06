package it.unibo.oop.lab.exception1;

public class NotEnoughBattery extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NotEnoughBattery() {
		super();	
	}
	
	public String toString() {
		return "not enough battery"; 
	}
	
	public String getMessage() {
		return this.toString();
	}
	
}
