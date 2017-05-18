package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.State;
import service.ServiceBD;
import model.BD;
import model.Product;

/**
 * Servlet implementation class ProductHandler
 */
@WebServlet("/ProductHandler")
public class ProductHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Product> products;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductHandler() {
        super();
        
        products=new ArrayList<Product>();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("products", products);
		request.getRequestDispatcher("insertProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BD p = new Product(request.getParameter("nome"), null, State.activo, null, 2);
		products.add((Product) p);
		doGet(request, response);
		
		ServiceBD bd=new ServiceBD();
		try {
			bd.insert((Product)p, "insert");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
