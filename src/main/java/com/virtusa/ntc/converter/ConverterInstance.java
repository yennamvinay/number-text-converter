package com.virtusa.ntc.converter;

import com.virtusa.ntc.util.NumberSegment;

/**
 * Enum class to maintain the instances of number to text converters
 */
public enum ConverterInstance {

	ONE_DIGIT_CONVERTER(new SingleDigitConverter()), TWO_DIGIT_CONVERTER(new TwoDigitConverter()),
	THREE_DIGIT_CONVERTER(new ThreeDigitConverter());

	/** Converter Instance */
	private ITextConverter textConverter;

	/**
	 * Constructor
	 * 
	 * @param textConverter {@link ITextConverter}
	 */
	private ConverterInstance(ITextConverter textConverter) {
		this.textConverter = textConverter;
	}

	/**
	 * Returns the converter instance by {@link NumberSegment} and value
	 * 
	 * @param numberSegment {@link NumberSegment}
	 * @param value         int
	 * @return the converter instance {@link ITextConverter}
	 */
	public static ITextConverter getConverterByValue(NumberSegment numberSegment, int value) {
		ITextConverter converter = null;
		if (value < 20 && numberSegment == NumberSegment.ONES) {
			converter = ONE_DIGIT_CONVERTER.textConverter;
		} else if (value < 10 && numberSegment == NumberSegment.TENS) {
			converter = TWO_DIGIT_CONVERTER.textConverter;
		} else if (value < 10) {
			converter = ONE_DIGIT_CONVERTER.textConverter;
		} else if (value < 100) {
			converter = TWO_DIGIT_CONVERTER.textConverter;
		} else if (value < 1000) {
			converter = THREE_DIGIT_CONVERTER.textConverter;
		}
		return converter;
	}
}
