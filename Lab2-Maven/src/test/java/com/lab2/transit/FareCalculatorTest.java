package com.lab2.transit;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;


import org.junit.Test;

import com.lab2.transit.FareCalculator;
@RunWith(Parameterized.class)

public class FareCalculatorTest {
	private static final double DELTA = 0;
	private double expected;
	private int age;
	private String time;
	private boolean isHoliday;

public FareCalculatorTest (double expected, int age, String time, boolean isHoliday)
{
	this.expected=expected;
	this.age=age;
	this.time=time;
	this.isHoliday=isHoliday;
}

@Parameters 
public static Collection<Object[]> testParams(){
 return Arrays.asList(new Object [][] {
		{0.0, 4, "6:00", false},
		{2.5, 6, "20:00", false},
		{0.0, 65, "6:00", false},
		{0.0, 66, "6:00", false},
		{2.5, 64, "6:00", false},
		{0.0, 87, "6:59", false},
		{0.0, 75, "9:01", false},
		{2.5, 64, "6:59", false},
		{2.5, 50, "9:01", false},
		{2.5, 65, "7:00", false},
		{0.0, 4, "7:30", true},
		{0.0, 68, "7:30", true}

		
		
		
});

}

	@Test
	public void test() {
		assertEquals(expected, FareCalculator.calculateFare(age, time, isHoliday), DELTA);
		
	}

}