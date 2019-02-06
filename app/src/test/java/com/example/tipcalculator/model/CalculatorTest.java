package com.example.tipcalculator.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnit4.class)
public class CalculatorTest {

	private Calculator calculator;

	@Before
	public void setup(){
		calculator = new Calculator();
	}

	@Test
	public void testCalculator(){
		double checkInput = 10.00;
		int tipPct = 25;

		TipCalculation tipCalculation = new TipCalculation();
		tipCalculation.setCheckAmount(checkInput);
		tipCalculation.setTipPercentage(25);
		tipCalculation.setTipAmount(2.50);
		tipCalculation.setGrandTotal(12.50);

		TipCalculation tipCalculation1 = new TipCalculation(tipCalculation);
		tipCalculation1.setTipPercentage(50);
		tipCalculation1.setTipAmount(5);
		tipCalculation1.setGrandTotal(15);

		ArrayList<TipCalculation> calculations = new ArrayList<>();
		calculations.add(tipCalculation);
		calculations.add(tipCalculation1);

		for(TipCalculation calculation : calculations) {
			assertEquals(calculation, calculator.calculateTip(calculation.getCheckAmount(), calculation.getTipPercentage()));
		}


	}
}
