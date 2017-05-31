package model;

import java.lang.reflect.Field;

public abstract class BD {
	
	protected Field[] fields = this.getClass().getDeclaredFields();
	protected int id;

	
	public String insert() throws IllegalArgumentException, IllegalAccessException, InstantiationException{
							
		String s="INSERT INTO "+ this.getClass().getSimpleName().toString() +" VALUES (";
				
		for(int i = 0; i < fields.length; s+="'"+ this.fields[i++].get(this) +"', ");
		
		//TODO verificar se atributtos parent supply e request são encontrados
		//TODO verificar getID de atributos tipo class do this.objecto
		
		s = s.substring(0, s.length()-2);
		s+=");";
				
		return s;
	}
	
	public String delete(){
		String s="DELETE FROM "+ (getClass().getSimpleName().toString())+" WHERE id='"+id+"';";
		return s;
}
	
	public String update() throws IllegalArgumentException, IllegalAccessException, InstantiationException{
		
		String s="UPDATE "+ this.getClass().getSimpleName().toString() +" SET ";
				
		for(int i = 0; i < fields.length; s+=this.fields[i++]+"='"+ this.fields[i++].get(this) +"', ");
		
		//TODO verificar se atributtos parent supply e request são encontrados
		//TODO verificar getID de atributos tipo class do this.objecto
		
		s = s.substring(0, s.length()-2);
		s+=" WHERE id='"+id+"';";
			
		return s;
	}
	
	public String selectAll() throws IllegalArgumentException, IllegalAccessException, InstantiationException{
		
		String s="SELECT * FROM "+ this.getClass().getSimpleName().toString() +";";
				
		
			
		return s;
	}
	
	
	
}
