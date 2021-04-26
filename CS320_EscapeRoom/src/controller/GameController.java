package controller;

import java.util.Scanner;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import model.Move;
import persist.DatabaseProvider;
import persist.FakeDatabase;
import persist.DerbyDatabase;
import controller.Game;
import controller.DatabaseLogic;
import model.Coordinate;
import model.Logic;
import model.Move;
import model.Numbers;
import model.Player;

public class GameController {
	
	Game game;
	public GameController()
	{
		game = new Game();
	}
	
	public void setModel(Game model)
	{
		this.game = model;
	}
	
	public void getInput(String move1)
	{
		game.getInput(move1);;
	}
	
	public java.util.List<String> getLog()
	{
		return game.getLog();
	}
}
