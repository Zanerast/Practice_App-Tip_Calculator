package com.example.tipcalculator.model.viewModel;

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

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		viewModel = new CalculatorViewModel(mockCalculator);
	}

	@Test
	public void testCalculateTips(){
		viewModel.setInputCheckAmount("10.00");
		viewModel.setInputTipPercentage("20");

		TipCalculation stub = new TipCalculation(10.00, 20, 2.00, 12.00);
		when(mockCalculator.calculateTip(10.00, 20)).thenReturn(stub);

		viewModel.calculateTip();

		assertEquals(stub, viewModel.getTipCalculation());
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
