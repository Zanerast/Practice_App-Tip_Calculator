package com.example.tipcalculator.viewModel;

import android.app.Application;

import com.example.tipcalculator.R;
import com.example.tipcalculator.model.Calculator;
import com.example.tipcalculator.model.TipCalculation;

import androidx.databinding.BaseObservable;

public class CalculatorViewModel extends BaseObservable {

	public String inputCheckAmount = "";
	public String inputTipPercentage = "";
	public String outputCheckAmount;
	public String outputTipAmount;
	public String outputTotalAmount;

	private Calculator calculator;
	private TipCalculation tipCalculation;
	private Application app;

	public CalculatorViewModel(Application application) {
		app = application;
		calculator = new Calculator();
	}

	public CalculatorViewModel(Application application, Calculator calculator) {
		app = application;
		this.calculator = calculator;
	}

	public void calculateTip() {
		if (!inputCheckAmount.isEmpty() && !inputTipPercentage.isEmpty()) {

			double checkAmount = Double.parseDouble(inputCheckAmount);
			int tipPercentage = Integer.parseInt(inputTipPercentage);

			tipCalculation = calculator.calculateTip(checkAmount, tipPercentage);
			updateOutputs();
			clearInputFields();
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

	private void clearInputFields() {
		inputCheckAmount = "";
		inputTipPercentage = "";
		notifyChange();
	}

	private void updateOutputs() {
		outputCheckAmount = app.getString(R.string.dollar_amount, tipCalculation.getCheckAmount());
		outputTipAmount = app.getString(R.string.dollar_amount, tipCalculation.getTipAmount());
		outputTotalAmount = app.getString(R.string.dollar_amount, tipCalculation.getGrandTotal());
	}


}
