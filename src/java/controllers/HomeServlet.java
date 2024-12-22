package controllers;

import jakarta.servlet.RequestDispatcher;
import java.util.ArrayList;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.BOs.CartBO;
import model.BOs.OwnerShopBO;
import model.entities.Cart;
import model.entities.Shop;

@WebServlet("/Trangchu")
public class HomeServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	    resp.setCharacterEncoding("UTF-8");
	    resp.setContentType("text/html; charset=UTF-8");
		ArrayList<Shop> shopList=new ArrayList<Shop>();
		shopList= OwnerShopBO.getShops();
		req.setAttribute("shopList", shopList);
		RequestDispatcher dispatcher=req.getRequestDispatcher("/Home.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.setCharacterEncoding("UTF-8");
	    resp.setCharacterEncoding("UTF-8");
	    resp.setContentType("text/html; charset=UTF-8");
	    int productID=Integer.parseInt(req.getParameter("productID"));
	    int clientID=Integer.parseInt(req.getParameter("clientID"));
	    Cart cart=new Cart(0, 1, "", clientID, productID );
	    CartBO.addCartToData(cart);
		resp.sendRedirect(req.getContextPath()+"/Trangchu");
	}
}
