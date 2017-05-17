package service;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.Arrays;
import java.util.List;


public class ServiceBD {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/gestaodestocks";
	
	static final String USER = "sa";
	static final String PASS = "qwerty";
	
	public Connection connection() throws ClassNotFoundException, SQLException {	
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		return conn;}
	
	public void insert(Object object) throws ClassNotFoundException, SQLException{	
		
		String sql=null;		
		List<Field> fields=null;
		
		sql+="INSERT INTO " + object.getClass().toString() + " VALUES (";
		
		for(Field field : getFields(fields, object.getClass())) {
			 if(field.toString()!="id") sql+="'"+field.toString() + "'," ;			
		}
		
		sql = sql.substring(-1);
		sql+=");";
		connection().createStatement().executeUpdate(sql);
		
	}
	
	public void select(Object object) throws ClassNotFoundException, SQLException{	
		
		String sql=null;		
		List<Field> fields=null;
		
		for(Field field : getFields(fields, object.getClass())) {
			 if(field.toString()!="id") sql+="'"+field.toString() + "'," ;			
		}
		
		sql = sql.substring(-1);
		sql+=");";
		connection().createStatement().executeUpdate(sql);
		
	}
	
		
	public static List<Field> getFields(List<Field> fields, Class<?> type) {
	    fields.addAll(Arrays.asList(type.getDeclaredFields()));

	    if (type.getSuperclass() != null) {
	        getFields(fields, type.getSuperclass());
	    }

	    return fields;
	}

	
	
}
