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

import model.BOs.PaymentBO;


@WebServlet(urlPatterns = "/Admin")
public class AdminServlet extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.setCharacterEncoding("UTF-8");
	    resp.setCharacterEncoding("UTF-8");
	    resp.setContentType("text/html; charset=UTF-8");
	    req.setAttribute("paymentList", PaymentBO.getPayments());
		RequestDispatcher dispatcher=req.getRequestDispatcher("/Pages/ManegerPage/Admin.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.setCharacterEncoding("UTF-8");
	    resp.setCharacterEncoding("UTF-8");
	    resp.setContentType("text/html; charset=UTF-8");
	    String table=req.getParameter("table");
	    switch (table) {
		case "payment":
			String status=req.getParameter("status");
			int paymentID=Integer.parseInt(req.getParameter("paymentID"));
			if(!status.equals("3")) PaymentBO.updateStatusPayment(paymentID, status);
			else PaymentBO.deletePayment(paymentID);
			break;
		case "submit":
			PaymentBO.updatePaymentsMoney();
			break;
//		case "DELETE":
//			productID=Integer.parseInt(req.getParameter("pID"));
//			ProductService.deleteProductInData(productID, "products");
//			break;
//		case "PUT":
//			productID=Integer.parseInt(req.getParameter("id"));
//			product=(String)req.getParameter("product");
//			priceO=(String)req.getParameter("priceO");
//			priceS=(String)req.getParameter("priceS");
//			url=(String)req.getParameter("url");
//			ses.setAttribute("id", productID);
//			ses.setAttribute("product", product);
//			ses.setAttribute("priceO", priceO);
//			ses.setAttribute("priceS", priceS);
//			ses.setAttribute("url", url);
//			break;
		default:
			break;
		}
		
	    resp.sendRedirect(req.getContextPath()+"/Admin");
	}

}
