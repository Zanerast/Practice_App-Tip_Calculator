package com.example.tipcalculator.viewModel;

import com.example.tipcalculator.model.Calculator;
import com.example.tipcalculator.model.TipCalculation;

public class CalculatorViewModel {

	String inputCheckAmount = "";
	String inputTipPercentage = "";
	Calculator calculator;
	TipCalculation tipCalculation;

	public CalculatorViewModel() {
		calculator = new Calculator();
	}

	public CalculatorViewModel(Calculator calculator) {
		this.calculator = calculator;
	}

	public void calculateTip() {
		if (!inputCheckAmount.isEmpty() && !inputTipPercentage.isEmpty()) {
			double checkAmount = Double.parseDouble(inputCheckAmount);
			int tipPercentage = Integer.parseInt(inputTipPercentage);

			tipCalculation = calculator.calculateTip(checkAmount, tipPercentage);
		}
	}

	public TipCalculation getTipCalculation() {
		return tipCalculation;
	}

	public void setInputCheckAmount(String inputCheckAmount) {
		this.inputCheckAmount = inputCheckAmount;
	}

	public void setInputTipPercentage(String inputTipPercentage) {
		this.inputTipPercentage = inputTipPercentage;
	}
}
