import java.util.*;
class ForEachInJava
{
	public static void main(String[] args) 
	{
		List<Integer> a = Arrays.asList(1,2,3,4);
		a.forEach(element->System.out.println(element));
		System.out.println(a);	
	}
}