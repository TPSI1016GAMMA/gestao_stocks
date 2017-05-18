package connect;

import java.sql.*;
import java.util.ArrayList;


public class BD {

	public BD() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {	
		
		try {
			String host = "jdbc:sqlserver://localhost:1433;databaseName=gestaodestocks";
			String uName="sa";
			String uPass="qwerty";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
			Connection con = DriverManager.getConnection(host, uName, uPass);
			Statement sta = con.createStatement();
			
			
			String Sql = "select * from state";
			ResultSet rs = sta.executeQuery(Sql);
			while (rs.next()) {
				System.out.println(rs.getString("name_state"));
			}
			
			
			if(con !=null){
				
				//Quando a ligaçao e positiva
				
				
			}
		} catch (SQLException e) {
			
			
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			
			
			e.printStackTrace();
			
		}
	}
}
