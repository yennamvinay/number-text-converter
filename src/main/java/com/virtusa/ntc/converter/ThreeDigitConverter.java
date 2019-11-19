package com.virtusa.ntc.converter;

import com.virtusa.ntc.util.NumberSegment;
import com.virtusa.ntc.util.ONES;
import com.virtusa.ntc.util.TENS;

/**
 * Converter for three digit numbers
 */
public class ThreeDigitConverter implements ITextConverter {

	/**
	 * Overridden method
	 */
	@Override
	public String convert(int value) {
		StringBuilder bldr = new StringBuilder();
		int hundreds = value / 100;
		String hundredsLabel = null;
		if (hundreds > 0) {
			hundredsLabel = String.format("%s %s and", ONES.getByIndex(hundreds).getLabel(),
					NumberSegment.HUNDREDS.getLabel());
		}
		int tens = (value % 100) / 10;
		String tensLabel = null;
		if (tens > 0) {
			tensLabel = TENS.getByIndex(tens).getLabel();
		}
		int ones = ((value % 100) % 10) % 10;
		String onesLabel = null;
		if (ones > 0) {
			onesLabel = ONES.getByIndex(ones).getLabel();
		}
		if (hundredsLabel != null) {
			bldr.append(hundredsLabel).append(" ");
		}
		if (tensLabel != null) {
			bldr.append(tensLabel).append(" ");
		}
		if (onesLabel != null) {
			bldr.append(onesLabel);
		}
		return bldr.toString().trim();
	}

}
