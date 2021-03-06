package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
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
		game.getInput(move1);
	}
	
	public java.util.List<String> getLog()
	{
		return game.getLog();
	}
	
	public int getScore() {
		return game.getScore();
	}
	
	public int getWinGame() {
		return game.getWinGame();
	}
	public void restartGame() {
		game.restartGame();
	}
	
	public void restartGameAfterWin() {
		game.restartGameAfterWin();
	}
	
	public void updateHighScore() {
		game.updateHighScore();
	}
	
	public int getHighScore() {
		return game.getHighScore();
	}
}
