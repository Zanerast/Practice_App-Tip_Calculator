package com.example.tipcalculator.model;

public class Calculator {

	public TipCalculation calculateTip(double checkInput, int tipPct) {
		TipCalculation calculation = new TipCalculation();
		calculation.setCheckAmount(checkInput);
		calculation.setTipPercentage(tipPct);
		calculation.setTipAmount(checkInput * ((double) tipPct / 100));
		calculation.setGrandTotal(checkInput + calculation.getTipAmount());

		return calculation;
	}
}
