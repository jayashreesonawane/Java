package interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Student {

	String name ;
	String college;
	String course ;
	String yop ;
	String degree ;
	String stream ;
	long phno ;
	String branch ;
	String typeOfPayment ;
	
	double fees ;
	
	List<String> subjects ;
	
	HashSet<Subject> completed = new HashSet<>();
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String college, String course, String yop, String degree, String stream, long phno,
			String branch,double fee,String typeOfPayment) {
		super();
		this.name = name;
		this.college = college;
		this.course = course;
		this.yop = yop;
		this.degree = degree;
		this.stream = stream;
		this.phno = phno;
		this.branch = branch;
		this.fees = fee ;
		this.typeOfPayment = typeOfPayment ;
		subjects = setSubject() ;
	}
	
	public List<String> setSubject()
	{
		List<String> subject = null;
		if (course.equalsIgnoreCase("Software Development")) {
			
			 subject = Arrays.asList("SQL","Core Java","Web Technology","J2EE","Spring","Hibernate","React","JavaScript") ;
		}
		else if (course.equalsIgnoreCase("Software Testing")) {
			
			 subject = Arrays.asList("SQL","Core Java","Web-Services","Manual Testing","Selenium","FireFlink");
		}
		
		return subject ;
	}
	
	public void addSubject(String type, String trainer, String name)
	{
		
		if (subjects.contains(name)) {
			
			completed.add(new Subject(type, trainer, name)) ;
			System.out.println(name+" subject added!");
			
		}
		else
		{
			System.out.println(name+" is not in your course list!");
		}
	}
	
	public void addRating(String subject , Character rating)
	{
		boolean found = false ;
		for (Subject sub : completed) {
			
			if (sub.name.equalsIgnoreCase(subject)) {
				
				found = true ;
				sub.rating.add(rating) ;
				System.out.println("Rating added for the mock "+sub.rating.size());
				
				break ;
			}
			
		}
		if (!found) {
			
			System.out.println("Subject not found!");
		}
		
	}

	@Override
	public String toString() {
		return "name=" + name + ", phno=" + phno ;
	}

	@Override
	public int hashCode() {
		return (int)phno ;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return this.phno==other.phno;
	}
	
	
}
