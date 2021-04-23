package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AddNumbersController;
import controller.GameController;
import controller.DatabaseLogic;
import controller.AllAuthorsQuery;
import model.Author;
import model.Coordinate;
import model.Logic;
import model.Move;
import model.Numbers;
import model.Player;

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

		//THIS LOADS THE DATABASE CONTROLLER TO USE FOR LOADING & SAVING THE GAMESTATE
		DatabaseLogic database = null;	
		database = new DatabaseLogic();
		//SET THE VALUES THE GAME USES BASED ON THE DATABASE VALUES
		
		Integer room = database.getRoom();
		System.out.println();
		Integer x = database.getCoordinateX();
		Integer y = database.getCoordinateY();
		String Inventory = database.getPlayerInv();
		String MapInventory = database.getMapInventory();
		String Actions = database.getActions();
		List<String> log = new ArrayList<String>();
		log = database.getLog();
		

		System.out.println("Game Servlet: doPost");

		String coor = "1,1";
		String result;
		String description;
  
		
		Move model = new Move();

		GameController controller = new GameController(x, y, Inventory, Actions, MapInventory, room);

		controller.setModel(model);

		String move = req.getParameter("move");

		result = controller.getOutput(move);
		
		description = controller.getSpotDescription(1, 1, MapInventory);
		// COORDINATE SYSTEM // MOVE THIS INTO A NEW CLASS
		
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
			room = 2;
			coor = x + "," + y;
		} else if (result == "you went back to room 1") {  //if the player changes rooms
			x = 1;
			y = 2;
			room = 1;
			coor = x + "," + y;
			
		} else if (result == "you enter room 3") { //moving from room 2 to room 3
			x = 1;
			y = 0;
			room = 3;
			coor = x + "," + y;
		} else if (result == "you returned to room 2"){ //moving from room 3 to room 2
			x = 1;
			y = 2;
			room = 2;
			coor = x + "," + y;
		}
		else {
			coor = x + "," + y;
		}
		//
		Coordinate coord = new Coordinate();
		coord.setCoordinate(x, y);
		
		
		Inventory = controller.getPickupLogic(move, result, Inventory);
		MapInventory = controller.getMapPickupLogic(move, result, MapInventory, controller.getPlayer());
		Actions = controller.getActionsLogic(move, result, Inventory, Actions);

		controller = new GameController(x, y, Inventory, Actions, MapInventory, room); //update game controller for new descriptions
		description = controller.getSpotDescription(x, y, MapInventory); //set new description
		
		//STORE THE NEW VALUES IN THE DATABASE///////////////////
		database.setCoordinate(coord);
		database.setRoom(room);
		database.getPlayerInv();
		database.setMapInventory(MapInventory);
		database.updateActions(Actions);
		database.updatePlayerInv(Inventory);
		
		//LOGIC FOR THE LOGS
		if(result.contains("can't"))
		{
			database.addLog(result);
			database.addLog("");
		}
		else if(result != "")
		{
			database.addLog(result);
			database.addLog(description);
			database.addLog("");
		}
		log = database.getLog();
		//
		
		// set attributes(STUFF THAT IS SAVED) now in the jsp
		req.setAttribute("Actions", Actions);
		req.setAttribute("Inventory", Inventory);
		req.setAttribute("MapInventory", MapInventory);
		req.setAttribute("coords", coor);
		req.setAttribute("x", x);
		req.setAttribute("y", y);
		req.setAttribute("room", room);
		req.setAttribute("description", log); //description of room
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
