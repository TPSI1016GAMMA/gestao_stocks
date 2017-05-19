package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BD;
import model.Employee;
import model.Product;
import model.State;
import model.Warehouse;
import service.ServiceBD;

/**
 * Servlet implementation class ProductsHandler
 */
@WebServlet("/ProductsHandler")
public class ProductsHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ArrayList<Product> product;

    public ProductsHandler() {
        super();
        product=new ArrayList<>(); 
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		try {
		
		String host = "jdbc:sqlserver://localhost:1433;databaseName=gestaodestocks";
		String uName="sa";
		String uPass="qwerty";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		Connection con = DriverManager.getConnection(host, uName, uPass);
		Statement sta = con.createStatement();
		
		
		String Sql= "select * from product ";
		
		ResultSet rs = sta.executeQuery(Sql);
	
		if(con !=null){
			
			//Quando a ligaçao e positiva
			
			
		}
	} catch (SQLException e) {
		
		
		e.printStackTrace();
		
	} catch (ClassNotFoundException e) {
		
		
		e.printStackTrace();
		
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		BD e = new Product(request.getParameter("tf_name"));
		product.add((Product) e);
		doGet(request, response);
		
		ServiceBD bd=new ServiceBD();
		try {
			bd.insert((Product)e, "insert");
		} catch (ClassNotFoundException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		
		doGet(request, response);
	}

}
