package interfaces;

public interface QspidersApp {

	double installmentFees = 39950.0 ;
	double oneShotFees = 36950.0 ;
	
	double minFees = 15000.00 ;
	
	void addmission(String name,String college,String course,String yop,String degree,
			String stream,long phno,String branch,double fees,String typeOfPayment);
	
	
	void payFees(String name, long phno ,double fees);
	
	//void addCandidate(String name,char rating,String sub);
	
	public static void greetings(String name)
	{
		System.out.println("Hey! "+name+" Welcome to Qspiders!");
	}
	
	void showDB() ;
	
	void searchByName(String name);
	void searchByPhno(long phno);
	
}
