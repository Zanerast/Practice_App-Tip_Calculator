package com.example.tipcalculator.model;

import androidx.annotation.Nullable;

public class TipCalculation {

	private double checkAmount = 0.0;
	private int tipPercentage = 0;
	private double tipAmount = 0.0;
	private double grandTotal = 0.0;

	public TipCalculation(){}

	public TipCalculation(double checkAmount, int tipPercentage, double tipAmount, double grandTotal) {
		this.checkAmount = checkAmount;
		this.tipPercentage = tipPercentage;
		this.tipAmount = tipAmount;
		this.grandTotal = grandTotal;
	}

	public TipCalculation(TipCalculation calculation){
		this.checkAmount = calculation.getCheckAmount();
		this.tipPercentage = calculation.getTipPercentage();
		this.tipAmount = calculation.getTipAmount();
		this.grandTotal = calculation.getGrandTotal();
	}

	@Override
	public boolean equals(@Nullable Object obj) {
		if (!(obj instanceof TipCalculation))
			return false;
		TipCalculation calculation = (TipCalculation) obj;
		return (this.checkAmount == calculation.getCheckAmount()
						&& this.tipPercentage == calculation.getTipPercentage()
						&& this.tipAmount == calculation.getTipAmount()
						&& this.grandTotal == calculation.getGrandTotal());
	}

	public double getCheckAmount() {
		return checkAmount;
	}

	public void setCheckAmount(double checkAmount) {
		this.checkAmount = checkAmount;
	}

	public int getTipPercentage() {
		return tipPercentage;
	}

	public void setTipPercentage(int tipPercentage) {
		this.tipPercentage = tipPercentage;
	}

	public double getTipAmount() {
		return tipAmount;
	}

	public void setTipAmount(double tipAmount) {
		this.tipAmount = tipAmount;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
}
