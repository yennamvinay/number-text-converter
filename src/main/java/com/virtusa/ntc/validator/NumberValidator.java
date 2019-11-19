package com.virtusa.ntc.validator;

import com.virtusa.ntc.exception.ValidationException;

/**
 * Validator for the input number
 */
public class NumberValidator {

	/** Minimum value */
	private static final long MIN = 1;

	/** MAx Value */
	private static final long MAX = 999999999L;

	/**
	 * Validates the given number
	 * 
	 * @param number long
	 */
	public void validate(long number) {
		if (!(number >= MIN && number <= MAX)) {
			throw new ValidationException("Number: " + number + " is not in range from 1 to 999999999");
		}
	}
}
