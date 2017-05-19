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

import model.Employee;
import model.Product;
import model.State;
import model.Warehouse;

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
        warehouse=new ArrayList();
        employee=new ArrayList();
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
			
			
			String Sql="select id_warehouse, name_warehouse, name_employee, name_state from warehouse left join employee on warehouse.id_employee =employee.id_employee left join state on warehouse.id_state = state.id_state; ";
			
			ResultSet rs = sta.executeQuery(Sql);
			while (rs.next()) {
				Warehouse __temp= new Warehouse(rs.getInt("id_warehouse"),rs.getString("name_warehouse"),new Employee(rs.getString("name_employee")),State.activo,new ArrayList());
				warehouse.add(__temp);
				
			}
			Sql ="select * from Employee";
			rs= sta.executeQuery(Sql);
			
			while (rs.next()) {
				Employee _temp= new Employee(rs.getInt("id_employee"),rs.getString("name_employee"));
				employee.add(_temp);
				
			}
			
			
			if(con !=null){
				
				//Quando a ligaçao e positiva
				
				
			}
		} catch (SQLException e) {
			
			
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			
			
			e.printStackTrace();
			
		}
		
		request.setAttribute("warehouse", warehouse);
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("list_warehouse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
try {
			
			String host = "jdbc:sqlserver://localhost:1433;databaseName=gestaodestocks";
			String uName="sa";
			String uPass="qwerty";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
			Connection con = DriverManager.getConnection(host, uName, uPass);
			Statement sta = con.createStatement();
			
			
			String Sql="insert into warehouse(name_warehouse, id_employee, id_state) values ( \' " +request.getParameter("tf_whname")+ " \'," +Integer.parseInt(request.getParameter("s_id_employee")) +","+Integer.parseInt(request.getParameter("state"))+ ") ";
			
			ResultSet rs = sta.executeQuery(Sql);

			
			
			if(con !=null){
				
				//Quando a ligaçao e positiva
				
				
			}
		} catch (SQLException e) {
			
			
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			
			
			e.printStackTrace();
			
		}
		
		doGet(request, response);
	}

}
