package com.virtusa.ntc.partitioner;

import java.util.ArrayList;
import java.util.List;

import com.virtusa.ntc.util.NumberSegment;
import com.virtusa.ntc.vo.NumberPartition;

/**
 * Responsible for partitioning the given number as per decimal units
 */
public class NumberPartitioner {

	/**
	 * Represents the state of decimal unit
	 */
	private static enum STATE {
		TENS, HUNDREDS, THOUSANDS, MILLIONS, END;
	}

	/**
	 * Partitions the number as per decimal units
	 * 
	 * @param number long the number
	 * @return the partitions list {@link List}
	 */
	public List<NumberPartition> partition(long number) {
		List<NumberPartition> partitions = new ArrayList<>();
		STATE state = STATE.MILLIONS;
		long tempNumber = number;
		NumberPartition numberPartition = null;
		while (state != STATE.END && tempNumber > 0) {
			if (state == STATE.TENS) {
				partitions.addAll(getTensPartitions(tempNumber));
				tempNumber = tempNumber % 100;
				state = STATE.END;
				numberPartition = null;
			} else if (state == STATE.HUNDREDS) {
				numberPartition = getHundredPartiton(tempNumber);
				state = STATE.TENS;
				tempNumber = tempNumber % 100;
			} else if (state == STATE.THOUSANDS) {
				numberPartition = getThousandPartiton(tempNumber);
				tempNumber = tempNumber % 1000;
				state = STATE.HUNDREDS;
			} else if (state == STATE.MILLIONS) {
				numberPartition = getMillionPartiton(tempNumber);
				tempNumber = tempNumber % (1000 * 1000);
				state = STATE.THOUSANDS;
			}
			if (numberPartition != null) {
				partitions.add(numberPartition);
			}
		}
		return partitions;
	}

	/**
	 * Creates the million partition, if it is available in the given number
	 * 
	 * @param number long
	 * @return the million partition {@link NumberPartition}
	 */
	private NumberPartition getMillionPartiton(long number) {
		long millions = number / (1000 * 1000);
		if (millions > 0) {
			NumberPartition numberPartition = new NumberPartition();
			numberPartition.setSegment(NumberSegment.MILLIONS);
			numberPartition.setValue((int) millions);
			return numberPartition;
		}
		return null;
	}

	/**
	 * Creates the thousand partition, if it is available in the given number
	 * 
	 * @param number long
	 * @return the thousand partition {@link NumberPartition}
	 */
	private NumberPartition getThousandPartiton(long number) {
		long thousands = number / 1000;
		if (thousands > 0) {
			NumberPartition numberPartition = new NumberPartition();
			numberPartition.setSegment(NumberSegment.THOUSANDS);
			numberPartition.setValue((int) thousands);
			return numberPartition;
		}
		return null;
	}

	/**
	 * Creates the hundred partition, if it is available in the given number
	 * 
	 * @param number long
	 * @return the hundred partition {@link NumberPartition}
	 */
	private NumberPartition getHundredPartiton(long number) {
		long hundreds = number / 100;
		if (hundreds > 0) {
			NumberPartition numberPartition = new NumberPartition();
			numberPartition.setSegment(NumberSegment.HUNDREDS);
			numberPartition.setValue((int) hundreds);
			return numberPartition;
		}
		return null;
	}

	/**
	 * Creates the tens and ones partitions, if it is available in the given number
	 * 
	 * @param number long
	 * @return the partition list {@link List}
	 */
	private List<NumberPartition> getTensPartitions(long number) {
		List<NumberPartition> partitions = new ArrayList<>();
		if (number < 20) {
			NumberPartition numberPartition = new NumberPartition();
			numberPartition.setSegment(NumberSegment.ONES);
			numberPartition.setValue((int) number);
			partitions.add(numberPartition);
		} else {
			long tens = number / 10;
			if (tens > 0) {
				NumberPartition numberPartition = new NumberPartition();
				numberPartition.setSegment(NumberSegment.TENS);
				numberPartition.setValue((int) tens);
				partitions.add(numberPartition);
			}
			long ones = number % 10;
			if (ones > 0) {
				NumberPartition numberPartition = new NumberPartition();
				numberPartition.setSegment(NumberSegment.ONES);
				numberPartition.setValue((int) ones);
				partitions.add(numberPartition);
			}
		}
		return partitions;
	}
}
