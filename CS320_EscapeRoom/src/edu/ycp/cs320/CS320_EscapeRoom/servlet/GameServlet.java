package edu.ycp.cs320.CS320_EscapeRoom.servlet;

import java.io.IOException;

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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Game Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//Grab x and y coordinates form the past 
		//HAS TO BE A BETTER WAY TO SAVE THIS DATA
		Integer x = getIntFromParameter(req.getParameter("x"));
		Integer y = getIntFromParameter(req.getParameter("y"));
		if(x == null)
		{
			x = 0;
		}
		if(y == null)
		{
			y = 0;
		}
		//
		
		System.out.println("Game Servlet: doPost");
		
		String coor = "0,0";
		String result;

		Move model = new Move();
		
		GameController controller = new GameController();
		
		controller.setModel(model);
		
		String move = req.getParameter("move");
		
		result = controller.getOuput(move);
		
		//COORDINATE TEST
		if(result == "you went north")
		{
			//this code doesn't work because data is not saved between dopost
			//ask tutor best way to save controller
			//controller.getPlayer().updatePlayerCoor(controller.getPlayer().getPlayerx(), controller.getPlayer().getPlayery() + 1);
			//x = controller.getPlayer().getPlayerx();
			//y = controller.getPlayer().getPlayery();
			x = x + 1;
			coor = x + "," + y;  //figure out how to set coordinate
		}
		else if(result == "you went south")
		{
			x = x - 1;
			coor = x + "," + y;
		}
		else if(result == "you went west")
		{
			y = y - 1;
			coor = x + "," + y;
		}
		else if(result == "you went east")
		{
			y = y + 1;
			coor = x + "," + y;
		}
		else
		{
			coor = x + "," + y;
		}
		req.setAttribute("result2", coor);
		req.setAttribute("x", x);
		req.setAttribute("y", y);
		//
		
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
