package service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.Arrays;
import java.util.List;


public class ServiceBD {
	
	static final String HOST = "jdbc:sqlserver://localhost:1433;databaseName=gestaodestocks";
	
	static final String USER = "sa";
	static final String PASS = "qwerty";
	
	public Connection connection() throws ClassNotFoundException, SQLException {	
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		Connection conn = DriverManager.getConnection(HOST,USER,PASS);
		
		return conn;}
	
	public void insert(Object object, String s) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{	
		
		String sql="";		
		
		
		
		try {
	         Method method = object.getClass().getMethod(s);
		
			 sql=(String)method.invoke(object);
			  
			} 
			 catch (SecurityException e) {e.getCause().printStackTrace(); }
		     catch (NoSuchMethodException e) {e.getCause().printStackTrace(); }
		     catch (IllegalArgumentException e) {e.getCause().printStackTrace();}
			 catch (IllegalAccessException e) { e.getCause().printStackTrace(); }
			 catch (InvocationTargetException e) {e.getCause().printStackTrace(); }
		
		System.out.println(sql);
		
		connection().createStatement().executeUpdate(sql);
		
	}
	
	public void selectAll(Object object) throws ClassNotFoundException, SQLException{	
		
		String sql="SELECT * FROM "+object.getClass() ;	
		
		ResultSet rs = connection().createStatement().executeQuery(sql);
		
		while(rs.next()){
			
		}
		
	}
	
		
	public static List<Field> getFields(List<Field> fields, Object object) {
		Class d= object.getClass();
		Field[] f=d.getDeclaredFields();
		fields.addAll(Arrays.asList(f));
	  

	    if (d.getSuperclass().getName() != "java.lang.Object") {
	    	 System.out.println("Superclass = "+ d.getSuperclass().getName().toString());
	        //getFields(fields, d.getSuperclass());
	    }

	    return fields;
	}

	
	
}
