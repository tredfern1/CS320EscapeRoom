package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AddNumbersController;
import controller.Game;
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

		System.out.println("Game Servlet: doPost");
		List<String> log;
		
		Game game = new Game();

		GameController controller = new GameController();
		controller.setModel(game);

		String move = req.getParameter("move");
		
		controller.getInput(move);
		
		
		log = controller.getLog();
		// set attributes(STUFF THAT IS SAVED) now in the jsp
		req.setAttribute("description", log); //description of room
		//
		

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
