package edu.ycp.cs320.CS320_EscapeRoom.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.CS320_EscapeRoom.controller.AddNumbersController;
import edu.ycp.cs320.CS320_EscapeRoom.controller.GameController;
import edu.ycp.cs320.CS320_EscapeRoom.model.Move;
import edu.ycp.cs320.CS320_EscapeRoom.model.Player;
import edu.ycp.cs320.CS320_EscapeRoom.model.Numbers;

public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Game Servlet: doGet");

		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Grab x and y coordinates form the past
		// HAS TO BE A BETTER WAY TO SAVE THIS DATA
		Integer room = getIntFromParameter(req.getParameter("room"));
		Integer x = getIntFromParameter(req.getParameter("x"));
		Integer y = getIntFromParameter(req.getParameter("y"));
		String Inventory = (String)req.getParameter("Inventory");
		String Actions = (String)req.getParameter("Actions");
		

		if (x == null) {
			x = 1;
		}
		if (y == null) {
			y = 1;
		}
		if (room == null) {
			room = 1;
		}
		
		

		System.out.println("Game Servlet: doPost");

		String coor = "1,1";
		String result;
		String description;

		Move model = new Move();

		GameController controller = new GameController(x, y, Inventory, Actions, room);

		controller.setModel(model);

		String move = req.getParameter("move");

		result = controller.getOuput(move);

		description = controller.getSpotDescription(1, 1);

		x = controller.getPlayer().getPlayerx();
		y = controller.getPlayer().getPlayery();
		// COORDINATE SYSTEM
		if (result == "you went north") {
			y = y + 1;
			coor = x + "," + y; // figure out how to set coordinate
		} else if (result == "you went south") {
			y = y - 1;
			coor = x + "," + y;
		} else if (result == "you went west") {
			x = x - 1;
			coor = x + "," + y;
		} else if (result == "you went east") {
			x = x + 1;
			coor = x + "," + y;
		} else if (result == "you changed rooms") {  //if the player changes rooms
			x = 1;
			y = 0;
			room += 1;
			coor = x + "," + y;
		} else {
			coor = x + "," + y;
		}
		//
		if(result.contains("You picked up a")) //add item to inventory
		{
			String[] input = move.split(" ");
			Inventory = Inventory + input[1] + " ";                   //add to string of items
		}
		
		if(result.contains("You used the")) //check for uses of items
		{
			System.out.println("BIG NUT");
			String[] input = move.split(" ");
			System.out.println("input[1] :" + input[1]);
			if(input[1].contains("hammer"))
			{              
				Actions = Actions + "boxBreak" + " "; 
				//add respectable tags to actions(remember the space)
			}
			if(input[1].contains("redkey"))
			{              
				Actions = Actions + "unlock1" + " "; 
				//add respectable tags to actions(remember the space)
			}
		}
		
		
		
		
		
		controller = new GameController(x, y, Inventory, Actions, room); //update game controller for new descriptions
		description = controller.getSpotDescription(x, y); //set new description

		
		// set attributes(STUFF THAT IS SAVED)
		req.setAttribute("Actions", Actions);
		req.setAttribute("Inventory", Inventory);
		req.setAttribute("coords", coor);
		req.setAttribute("x", x);
		req.setAttribute("y", y);
		req.setAttribute("room", room);
		//
		req.setAttribute("description", description); //description of room
		req.setAttribute("result", result);
		
		
		
		

		req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
	}

	private int getInteger(HttpServletRequest req, String name) {
		return Integer.parseInt(req.getParameter(name));
	}

	private Integer getIntFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return Integer.parseInt(s);
		}
	}

}
