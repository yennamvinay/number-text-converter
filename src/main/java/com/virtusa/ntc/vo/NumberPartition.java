package com.virtusa.ntc.vo;

import com.virtusa.ntc.util.NumberSegment;

/**
 * Represents a partition in the input number
 */
public class NumberPartition {

	/** Segment Type */
	private NumberSegment segment;

	/** Value */
	private int value;

	/**
	 * Returns the segment type
	 * 
	 * @return the segment type {@link NumberSegment}
	 */
	public NumberSegment getSegment() {
		return segment;
	}

	/**
	 * Sets the {@link NumberSegment}
	 * 
	 * @param segment {@link NumberSegment}
	 */
	public void setSegment(NumberSegment segment) {
		this.segment = segment;
	}

	/**
	 * Returns the partition value
	 * 
	 * @return int
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Sets the partition value
	 * 
	 * @param value int
	 */
	public void setValue(int value) {
		this.value = value;
	}

}
