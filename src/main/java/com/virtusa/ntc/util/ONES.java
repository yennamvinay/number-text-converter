package com.virtusa.ntc.util;

/**
 * Represents the single digit number
 */
public enum ONES {

	ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), ELEVEN(11),
	TWELVE(12), THIRTEEN(13), FOURTEEN(14), FIFTEEN(15), SIXTEEN(16), SEVENTEEN(17), EIGHTEEN(18), NINETEEN(19);

	/** Number */
	private int number;

	/**
	 * Constructor
	 * 
	 * @param number int
	 */
	private ONES(int number) {
		this.number = number;
	}

	/**
	 * Returns the label
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
	 * Returns the {@link ONES} instance by index
	 * 
	 * @param index int
	 * @return the {@link ONES} instance {@link ONES}
	 */
	public static ONES getByIndex(int index) {
		return values()[index];
	}
}
