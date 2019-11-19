package com.virtusa.ntc.util;

/**
 * Represents a segment in number. This will be identified as per decimal units.
 */
public enum NumberSegment {

	ONES, TENS, HUNDREDS("hundred", true), THOUSANDS("thousand", false), MILLIONS("million", false);

	/** Segment Label */
	private String label;

	/** And postfix required or not? */
	private boolean andPostfixRequired;

	/**
	 * Constructor
	 */
	private NumberSegment() {
		this.label = "";
		this.andPostfixRequired = false;
	}

	/**
	 * Constructor
	 * 
	 * @param label              String
	 * @param andPostfixRequired boolean
	 */
	private NumberSegment(String label, boolean andPostfixRequired) {
		this.label = label;
		this.andPostfixRequired = andPostfixRequired;
	}

	/**
	 * Returns the label for the partition
	 * 
	 * @return the label {@link String}
	 */
	public String getLabel() {
		return this.label;
	}

	/**
	 * Returns whether the 'and' postfix required or not?
	 * 
	 * @return the postfix required or not? boolean
	 */
	public boolean isAndPostfixRequired() {
		return this.andPostfixRequired;
	}
}
