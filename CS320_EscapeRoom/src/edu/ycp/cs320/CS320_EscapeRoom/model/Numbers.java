package edu.ycp.cs320.CS320_EscapeRoom.model;

//create basic num variables and basic functions for add and multiply
public class Numbers {
	private double result;
	private double add1,add2,add3;
	
	public Numbers() {
	}
	
	public void store1(double first)
	{
		this.add1 = first;
	}
	public void add(double first, double second, double third)
	{
		this.result = first + second + third;
	}
	
	public void multiply(double first, double second)
	{
		this.result = first * second;
	}
	
	public double getResult()
	{
		return this.result;
	}
}
