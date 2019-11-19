package com.virtusa.ntc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.virtusa.ntc.exception.ValidationException;

public class NumberToTextConvertorTest {

	private NumberToTextConvertor numberToTextConvertor;

	@Before
	public void setUp() {
		numberToTextConvertor = new NumberToTextConvertor();
	}

	@Test
	public void testConvert_whenSigleDigit() {
		Assert.assertEquals("eight", numberToTextConvertor.convert(8L));
	}

	@Test
	public void testConvert_whenTwoDigit() {
		Assert.assertEquals("seventy six", numberToTextConvertor.convert(76L));
	}

	@Test
	public void testConvert_whenThreeDigit() {
		Assert.assertEquals("four hundred and fifty nine", numberToTextConvertor.convert(459L));
	}

	@Test
	public void testConvert_whenFourDigit() {
		Assert.assertEquals("one thousand eight hundred and eighty one", numberToTextConvertor.convert(1881L));
	}

	@Test
	public void testConvert_whenFiveDigit() {
		Assert.assertEquals("fifty five thousand five hundred and fifty five", numberToTextConvertor.convert(55555L));
	}

	@Test
	public void testConvert_whenSixDigit() {
		Assert.assertEquals("one hundred and twenty three thousand four hundred and fifty six",
				numberToTextConvertor.convert(123456L));
	}

	@Test
	public void testConvert_whenSevenDigit() {
		Assert.assertEquals("eight million one hundred and eighty two thousand eighty one",
				numberToTextConvertor.convert(8182081L));
	}

	@Test
	public void testConvert_whenEightDigit() {
		Assert.assertEquals("ninety million ninety nine", numberToTextConvertor.convert(90000099L));
	}

	@Test
	public void testConvert_whenNineDigit() {
		Assert.assertEquals(
				"nine hundred and eighty seven million six hundred and fifty four thousand three hundred and twenty one",
				numberToTextConvertor.convert(987654321L));
	}

	@Test
	public void testConvert_when100() {
		Assert.assertEquals("one hundred", numberToTextConvertor.convert(100L));
	}

	@Test
	public void testConvert_when50() {
		Assert.assertEquals("fifty", numberToTextConvertor.convert(50L));
	}

	@Test(expected = ValidationException.class)
	public void testConvert_whenInvalidNumber() {
		numberToTextConvertor.convert(999999999999L);
	}
}
