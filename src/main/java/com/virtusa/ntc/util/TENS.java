package com.virtusa.ntc.util;

/**
 * Represents the TENS decimal
 */
public enum TENS {

	ZERO(0), TEN(10), TWENTY(20), THIRTY(30), FORTY(40), FIFTY(50), SIXTY(60), SEVENTY(70), EIGHTY(80), NINETY(90);

	/** Number */
	private int number;

	/**
	 * Constructor
	 * 
	 * @param number int
	 */
	private TENS(int number) {
		this.number = number;
	}

	/**
	 * Returns the label to display
	 * 
	 * @return the label {@link String}
	 */
	public String getLabel() {
		return this.name().toLowerCase();
	}

	/**
	 * Returns the number
	 * 
	 * @return int
	 */
	public int getNumber() {
		return this.number;
	}

	/**
	 * Returns the {@link TENS} instance by index
	 * 
	 * @param index int
	 * @return the {@link TENS} instance {@link TENS}
	 */
	public static TENS getByIndex(int index) {
		return values()[index];
	}

}
