package controllers;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CannotAccess")
public class ErrorServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	    resp.setCharacterEncoding("UTF-8");
	    resp.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher=req.getRequestDispatcher("/Eror.jsp");
		dispatcher.forward(req, resp);
	}
}
