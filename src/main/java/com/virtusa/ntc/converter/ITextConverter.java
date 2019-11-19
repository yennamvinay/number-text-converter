package com.virtusa.ntc.converter;

/**
 * Abstraction for number to text conversion
 */
public interface ITextConverter {

	/**
	 * Converts the given number to text
	 * 
	 * @param value int
	 * @return the converted text {@link String}
	 */
	public String convert(int value);
}
