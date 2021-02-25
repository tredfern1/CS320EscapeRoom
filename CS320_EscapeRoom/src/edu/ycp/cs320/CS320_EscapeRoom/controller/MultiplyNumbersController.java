package edu.ycp.cs320.CS320_EscapeRoom.controller;

import edu.ycp.cs320.CS320_EscapeRoom.model.Numbers;

public class MultiplyNumbersController {
	
	private Numbers model;
	
	public void setModel(Numbers model) {
		this.model = model;
	}
	
	
	public void multiply(Double first, Double second) {
		model.multiply(first, second);
	}
	
	public double getResult()
	{
		return model.getResult();
	}
}
