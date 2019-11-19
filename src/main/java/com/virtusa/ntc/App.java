package com.virtusa.ntc;

import com.virtusa.ntc.exception.ValidationException;

public class App {

	public static void main(String[] args) {
		long input = getInput(args);
		System.out.println(new NumberToTextConvertor().convert(input));
	}

	private static long getInput(String[] args) {
		if (args == null || args.length == 0) {
			throw new ValidationException("No arguments received");
		}
		String arg = args[0];
		try {
			return Long.parseLong(arg);
		} catch (NumberFormatException exp) {
			throw new ValidationException(exp.getMessage());
		}
	}

}
