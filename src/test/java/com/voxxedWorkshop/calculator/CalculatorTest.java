package com.voxxedWorkshop.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.voxxedWorkshop.calculator.controller.CalculatorController;

@RunWith(SpringRunner.class)
public class CalculatorTest {
	
	CalculatorController controller;
	
	@Before
	public void setUp(){
		controller = new CalculatorController();
	}
	
	
	
	@Test
	public void sum() {
		//CalculatorController controller = new CalculatorController();
		assertEquals("5", controller.sum(2, 3));
	}
	
	@Test
	public void multiply() {
		//CalculatorController controller = new CalculatorController();
		assertEquals("6", controller.multiply(2, 3));
	}

}
