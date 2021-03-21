package edu.ycp.cs320.CS320_EscapeRoom.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.CS320_EscapeRoom.controller.AddNumbersController;
import edu.ycp.cs320.CS320_EscapeRoom.controller.GameController;
import edu.ycp.cs320.CS320_EscapeRoom.model.Move;
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
		
		System.out.println("Game Servlet: doPost");
		
		String result = null;
		
		Move model = new Move();
		
		GameController controller = new GameController();
		
		controller.setModel(model);
		
		String move = req.getParameter("move");
		
		result = controller.getOuput(move);
		
		req.setAttribute("result", result);
		
		req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
	}
}
