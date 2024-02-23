package interfaces;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;

public class QspidersImp1 implements QspidersApp{

	static int ct = 0 ;
	
	private QspidersImp1() {
		// TODO Auto-generated constructor stub
	}
	LinkedHashSet<Student> db = new LinkedHashSet<>() ;
	
	public static QspidersImp1 createApp() {
		
		if (ct<1) {
			
			ct++ ;
			return new QspidersImp1() ;
			
		}
		System.out.println("Already the app is in use!");
		return null ;
	}
	
	public void addmission(String name,String college,String course,String yop,
			String degree,String stream,long phno,String branch,double fee,
			String typeOfPayment)
	{
		if (fee>=QspidersApp.minFees) {
			
			db.add(new Student(name, college, course,yop, degree, stream, phno, branch, fee,typeOfPayment));
			
			//System.out.println("Addmission successful!");
			
			//QspidersApp.greetings(name);
		}
		else
		{
			System.out.println("Admission Denied!");
		}
	}
	
	public void payFees(String name,long phno,double fees)
	{
		for (Student student : db) {
			
			if (student.name.equalsIgnoreCase(name)&& student.phno==phno) {
				
				if (student.typeOfPayment.equalsIgnoreCase("Installment")) {
					
					if (student.fees<QspidersApp.installmentFees) {
						
						System.out.println("Please pay the difference amount to continue to course: "+(installmentFees-student.fees)+"Rs");
						
						student.fees = student.fees + fees ;
						System.out.println("Fees updated!");
						
						System.out.println("Total fees paid is: "+student.fees+"Rs");
					}
					else if (student.fees==QspidersApp.installmentFees) {
						
						System.out.println("Your fees is already paid completely and no dues left!");
					}
					
				}
				
			}
		}
		
	}
	
	public void showDB()
	{
		for (Student student : db) {
			System.out.println(student);
		}
	}
	
	public void searchByName(String name)
	{
		 Iterator<Student> i =db.iterator() ;
		 
		 boolean found = false ;
		for (Student student : db) {

			
			if (student.name.contains(name)) {
				
				found = true ;
				System.out.println("Student found!");
				
				System.out.println(student);
				
			}
		}
		
		if (!found) {
			
			System.out.println("Student not found!");
		}
	}
	
	public void searchByPhno(long phno)
	{
		 Iterator<Student> i =db.iterator() ;
		 
		 try
		 {
			 while (true) {
					Student student = i.next();
					
					if (student.phno==phno) {
						
						System.out.println("Student found!");
						
						System.out.println(student);
						
						break ;
					}
		 }
			
		}
		 catch(NoSuchElementException exp)
		 {
			 System.out.println("Student not found!");
		 }
		
	}

	
}
