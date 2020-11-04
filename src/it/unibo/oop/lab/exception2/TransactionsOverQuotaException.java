package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5186015990336694793L;

	public String toString() {
		return "TransactionsOverQuotaException []";
	}
	
	public String getMessage() {
		return toString();
	}

}
