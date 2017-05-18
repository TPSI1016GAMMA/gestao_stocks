package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BD;
import model.Employee;
import model.Product;
import service.ServiceBD;

/**
 * Servlet implementation class EmployeeHandler
 */
@WebServlet("/EmployeeHandler")
public class EmployeeHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Employee> employees;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeHandler() {
        super();
        employees=new ArrayList<Employee>();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("employees", employees);
		request.getRequestDispatcher("insertEmployee.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BD e = new Employee(request.getParameter("name"));
		employees.add((Employee) e);
		doGet(request, response);
		
		ServiceBD bd=new ServiceBD();
		try {
			bd.insert((Employee)e, "insert");
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
		
	}

}
