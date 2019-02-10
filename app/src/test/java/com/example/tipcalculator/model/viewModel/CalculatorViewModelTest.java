package com.example.tipcalculator.model.viewModel;

import android.app.Application;

import com.example.tipcalculator.R;
import com.example.tipcalculator.model.Calculator;
import com.example.tipcalculator.model.TipCalculation;
import com.example.tipcalculator.viewModel.CalculatorViewModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class CalculatorViewModelTest {

	private CalculatorViewModel viewModel;
	@Mock
	Calculator mockCalculator;
	@Mock
	Application application;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		stubResource(0.0, "$0.00");
		viewModel = new CalculatorViewModel(application, mockCalculator);
	}

	public void stubResource(Double input, String returnValue){
		when(application.getString(R.string.dollar_amount, input)).thenReturn(returnValue);
	}

	@Test
	public void testCalculateTips(){
		viewModel.setInputCheckAmount("10.00");
		viewModel.setInputTipPercentage("20");

		TipCalculation stub = new TipCalculation(10.00, 20, 2.00, 12.00);
		when(mockCalculator.calculateTip(10.00, 20)).thenReturn(stub);
		stubResource(10.00, "$10.00");
		stubResource(2.00, "$2.00");
		stubResource(12.00, "$12.00");

		viewModel.calculateTip();

		assertEquals(stub, viewModel.getTipCalculation());
		assertEquals("$10.00", viewModel.outputCheckAmount);
		assertEquals("$2.00", viewModel.outputTipAmount);
		assertEquals("$12.00", viewModel.outputTotalAmount);
	}

	@Test
	public void testCalculateBadTip(){
		viewModel.setInputCheckAmount("10.00");
		viewModel.setInputTipPercentage("");

		viewModel.calculateTip();

		verify(mockCalculator, never()).calculateTip(anyDouble(), anyInt());
	}

	@Test
	public void testCalculateBadCheck(){
		viewModel.setInputCheckAmount("10.00");
		viewModel.setInputTipPercentage("");

		viewModel.calculateTip();

		verify(mockCalculator, never()).calculateTip(anyDouble(), anyInt());
	}


}
