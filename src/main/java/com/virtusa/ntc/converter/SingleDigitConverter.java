package com.virtusa.ntc.converter;

import com.virtusa.ntc.util.ONES;

/**
 * Converter for single digit conversions
 */
public class SingleDigitConverter implements ITextConverter {

	/**
	 * Overridden method
	 */
	public String convert(int value) {
		if (value < 20) {
			return ONES.getByIndex(value).getLabel();
		}
		return null;
	}

}
