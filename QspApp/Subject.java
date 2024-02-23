package interfaces;

import java.util.ArrayList;

public class Subject {

	String type ;
	String trainer ;
	String name ;
	ArrayList<Character> rating ;
	
	public Subject() {
		// TODO Auto-generated constructor stub
	}

	public Subject(String type, String trainer, String name) {
		
		this.type = type;
		this.trainer = trainer;
		this.name = name;
	}

	@Override
	public String toString() {
		return "type=" + type + ", trainer=" + trainer + ", name=" + name ;
	}
	
	public void addRating(Character rating)
	{
		this.rating.add(rating) ;
		System.out.println("Rating added of the mock "+this.rating.size());
	}
	
	
	public boolean equals(Object o)
	{
		Subject s1 = (Subject) o ;
		
		if (s1.type==this.type && s1.name==this.name&&s1.trainer==this.trainer) {
			
			return true ;
		}
		
		return false ;
	}
	
	public int hashCode()
	{
		return name.hashCode()+type.hashCode()+trainer.hashCode() ;
	}
	
	
	
}
