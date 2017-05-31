package service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
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
	
	public void cud(Object object, String s) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{	
		
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
	
public ArrayList<Object> read(Object object, String s) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{	
		
		String sql="";	
		ArrayList <Object> selectAll=new ArrayList<Object>();
		Field[] fields = object.getClass().getDeclaredFields();
		Method[] rm = ResultSet.class.getDeclaredMethods();
		
		
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
		
		ResultSet result=connection().createStatement().executeQuery(sql);

		
		while(result.next()){
			for(int i=0; i<fields.length; i++){				
				fields[i].set(object, met(rm, 0, fields[i]).invoke(result, fields[i].getGenericType().toString())) ;}
			selectAll.add(object);}
		
		return selectAll;		
	}
	
	
		
	public Method met( Method[] rm, int index, Field field){	
		
		String temp=field.getGenericType().toString();
		if(temp.contains("class")) temp=temp.substring(6);
		
		return rm[index].toString().contains(temp) && rm[index].getGenericParameterTypes().getClass().equals(field.getGenericType().getClass()) && rm[index].getName().contains("get") && temp.contains(rm[index].getName().substring(3)) ? rm[index] : index == rm.length-1? null : met( rm, ++index, field) ;
	}
	
	
}
