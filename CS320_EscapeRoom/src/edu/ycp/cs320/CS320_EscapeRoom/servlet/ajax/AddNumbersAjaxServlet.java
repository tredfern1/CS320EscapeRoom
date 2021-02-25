package edu.ycp.cs320.CS320_EscapeRoom.servlet.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.CS320_EscapeRoom.controller.AddNumbersController;
import edu.ycp.cs320.CS320_EscapeRoom.model.Numbers;

public class AddNumbersAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		doRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doRequest(req, resp);
	}

	private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get parameters
		Double first = getDouble(req, "first");
		Double second = getDouble(req, "second");
		Double third = getDouble(req, "third");
		
		// Check whether parameters are valid
		if (first == null || second == null) {
			badRequest("Bad parameters", resp);
			return;
		}
		
		Numbers model = new Numbers();
		// Use a controller to process the request
		AddNumbersController controller = new AddNumbersController();
		controller.setModel(model);
		controller.add(first, second, third);
		Double result = controller.getResult();
		
		// Send back a response
		resp.setContentType("text/plain");
		resp.getWriter().println(result.toString());
		
		
	}

	private Double getDouble(HttpServletRequest req, String name) {
		String val = req.getParameter(name);
		if (val == null) {
			return null;
		}
		try {
			return Double.parseDouble(val);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	private void badRequest(String message, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		resp.getWriter().println(message);
	}
}
