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
 * Servlet implementation class WarehouseHandler
 */
@WebServlet("/WarehouseHandler")
public class WarehouseHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ArrayList<Warehouse> warehouse;
	private ArrayList<Employee> employee;
	
    public WarehouseHandler() {
        super();
        ServiceBD bd=new ServiceBD();
        warehouse=new ArrayList<Warehouse>();
        employee=new ArrayList<Employee>();
    }

    private Warehouse getWarehouseByID(int id) {
    	for (Warehouse w:this.warehouse) {
    		if (w.getId()==id) {
    			return w;
    		}
    	}
    	return null;
    }
    
    public Employee getEmployeeByName(String name) {
    	for (Employee e:employee) {
    		if (e.getName().equals(name)) {
    			return e;
    		}
    	}
    	return null;
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//warehouse = bd.selectAll();
		ServiceBD bd=new ServiceBD();
		if (request.getParameter("delete")!=null) {
			int idToDelete = Integer.valueOf(request.getParameter("delete"));
			BD wh = getWarehouseByID(idToDelete);
			if (wh!=null) {
				try {
					bd.delete((Warehouse)wh, "insert");
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
			warehouse.remove(wh);
		}
		
		request.setAttribute("warehouse", warehouse);
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("list_warehouse.jsp").forward(request, response);
		
	}
	
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("method")!=null) {
				BD w = new Warehouse(-1, request.getParameter("name"), getEmployeeByName(request.getParameter("s_id_employee")), Integer.valueOf(request.getParameter("state"))==1?State.activo:State.inactivo, null);
				warehouse.add((Warehouse) w);
				
				ServiceBD bd=new ServiceBD();
				try {
						bd.cud((Warehouse)w, request.getParameter("method"));
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
			} else {
				//edit
			}
		doGet(request, response);
	}
}