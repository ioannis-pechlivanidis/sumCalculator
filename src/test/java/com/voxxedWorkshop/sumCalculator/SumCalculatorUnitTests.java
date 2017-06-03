package com.voxxedWorkshop.sumCalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SumCalculatorUnitTests {
	@Test
	public void sum() {
		CalculatorController controller = new CalculatorController();
		assertEquals("5", controller.sum(2, 3));
	}

}
