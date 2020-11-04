package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends IllegalArgumentException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7190620326792084901L;
	private final int user;
	
	public WrongAccountHolderException(int user) {
		super();
		this.user = user;
	}
	
	public String toString() {
		return "WrongAccountHolderException [user=" + user + "]";
	}
	
	public String getMessage() {
		return toString();
	}
	
	
}
