package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Estado;
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
		
		Product p = new Product(request.getParameter("nome"), null, Estado.activo, null, Double.parseDouble(request.getParameter("stockMinimo")));
		products.add(p);
		doGet(request, response);
	}

}
