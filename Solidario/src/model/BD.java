package model;

import java.lang.reflect.Field;

public abstract class BD {
	
	protected Field[] fields = this.getClass().getDeclaredFields();
	protected int id;

	
	public String insert() throws IllegalArgumentException, IllegalAccessException, InstantiationException{
							
		String s="INSERT INTO "+ this.getClass().getSimpleName().toString() +" VALUES (";
				
		for(int i = 0; i < fields.length; s+="'"+ this.fields[i++].get(this) +"', ");
		
		s = s.substring(0, s.length()-2);
		s+=");";
			
		return s;
	}
	
	public String delete(){
		String s="DELETE FROM "+ (getClass().getSimpleName().toString())+" WHERE id='"+id+"';";
		return s;
}
}
