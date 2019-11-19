package com.virtusa.ntc.converter;

import com.virtusa.ntc.util.ONES;
import com.virtusa.ntc.util.TENS;

/**
 * Converter for two digit numbers
 */
public class TwoDigitConverter implements ITextConverter {

	/**
	 * Overridden method
	 */
	@Override
	public String convert(int value) {
		StringBuilder bldr = new StringBuilder();
		if (value < 10) {
			return TENS.getByIndex(value).getLabel();
		}
		int tens = value / 10;
		String tensLabel = null;
		if (tens > 0) {
			tensLabel = TENS.getByIndex(tens).getLabel();
		}
		int ones = value % 10;
		String onesLabel = null;
		if (ones > 0) {
			onesLabel = ONES.getByIndex(ones).getLabel();
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
