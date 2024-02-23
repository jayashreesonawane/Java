package interfaces;

public class QspidersDriver {

	public static void main(String[] args) {
		
		
		QspidersApp q1 = QspidersImp1.createApp() ; // factory method
		
		q1.addmission("Raju","COEP","Software Development","2023","BE",
				"Mechanical",9876543210l,"Deccan",1000000.00,"Installment");
		
		q1.addmission("Rani","Sinhgad College","Software Testing","2022","BSc",
				"Physics",9876554645l,"Deccan",16000.00,"One Shot");
		
		q1.addmission("Riya","MIT","Software Development","2021","BE",
				"EEE",8967543210l,"Deccan",36950.00,"One Shot");
		
		q1.addmission("Ganesh","DKTE","Software Development","2022","BE",
				"CSE",9876543211l,"Deccan",25000.00,"Installment");
		
		q1.addmission("Vaibhav","Zeal College","Software Testing","2023","BE",
				"CSE",789654320l,"Deccan",30000.00,"Installment");
		
		q1.addmission("Ganesh Patil","SGI","Software Testing","2022","BE",
				"CSE",9876543211l,"Deccan",25000.00,"Installment");
		
		q1.addmission("Riya","MIT","Software Development","2021","BE",
				"EEE",8967543210l,"Deccan",36950.00,"One Shot");
		
		q1.showDB() ;
		
		q1.searchByName("Ra");
		
		q1.searchByPhno(9876543210l);
	
		
		
		
	}
}
