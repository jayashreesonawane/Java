class nameCharacter
{
	public static void main(String[] args) throws InterruptedException
	{
		String name = "Jayashree";	
		for (int i=0;i<name.length();i++) 
		{
			Thread.sleep(1000);
			System.out.println(name.charAt(i));	
		}
	}
}