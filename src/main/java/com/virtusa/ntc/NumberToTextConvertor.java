package com.virtusa.ntc;

import java.util.Iterator;
import java.util.List;

import com.virtusa.ntc.converter.ConverterInstance;
import com.virtusa.ntc.converter.ITextConverter;
import com.virtusa.ntc.partitioner.NumberPartitioner;
import com.virtusa.ntc.validator.NumberValidator;
import com.virtusa.ntc.vo.NumberPartition;

/**
 * Entrypoint class for number to text convertor
 */
public class NumberToTextConvertor {

	/**
	 * Converts the given number to text
	 * 
	 * @param input long the input number
	 * @return the converted string {@link String}
	 */
	public String convert(long input) {
		new NumberValidator().validate(input);
		List<NumberPartition> partitions = new NumberPartitioner().partition(input);
		ITextConverter converter = null;
		NumberPartition numberPartition;
		StringBuilder bldr = new StringBuilder();
		for (Iterator<NumberPartition> iter = partitions.iterator(); iter.hasNext();) {
			numberPartition = iter.next();
			converter = ConverterInstance.getConverterByValue(numberPartition.getSegment(), numberPartition.getValue());
			bldr.append(converter.convert(numberPartition.getValue()))
					.append(numberPartition.getSegment().getLabel().isEmpty() ? ""
							: String.format(" %s", numberPartition.getSegment().getLabel()));
			if (iter.hasNext()) {
				bldr.append(numberPartition.getSegment().isAndPostfixRequired() ? " and " : " ");
			}
		}
		return bldr.toString();
	}
}
