package controller;

import model.Numbers;

public class AddNumbersController {
	
	private Numbers model;
	
	public void setModel(Numbers model) {
		this.model = model;
	}
	
	
	public void add(Double first, Double second, Double third) {
		model.add(first, second, third);
	}
	
	public double getResult()
	{
		return model.getResult();
	}
}
