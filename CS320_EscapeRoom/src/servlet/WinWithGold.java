package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Game;
import controller.GameController;
import controller.LoginController;
import model.Library;

public class WinWithGold extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Library model;
	private LoginController controller;

	
	//CITATION: FROM THE LAB02 LIBRARY EXAMPLE
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("\nWinWithGold: doGet");

		req.getRequestDispatcher("/_view/winWithGold.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("\nWinWithGold: doPost");
		Game game = new Game();
		GameController controller = new GameController();
		controller.setModel(game);
		controller.restartGameAfterWin();
		

		// Forward to view to render the result HTML document
		resp.sendRedirect(req.getContextPath() + "/login");
	}
}
