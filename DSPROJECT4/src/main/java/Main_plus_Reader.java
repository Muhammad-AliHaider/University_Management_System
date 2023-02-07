import java.io.*;  
import java.util.Scanner;

public class Main_plus_Reader  
{  
	public static void main(String[] args) throws Exception  
	{  
		//parsing a CSV file into Scanner class constructor  
		Scanner sc = new Scanner(new File("C:\\Users\\Dell\\Desktop\\DS-Lab\\DSProject1\\src\\main\\java\\DSProject\\src\\Fake_Data.csv")); 
		University_LinkedList LList = new University_LinkedList();
                
                while (sc.hasNextLine())  //returns a boolean value  
		{  
			String x = sc.nextLine();//find and returns the next complete token from this scanner
			String[] Uni  = x.split(",");
			String[] programs = Uni[1].split("-");
			

			LList.insert(Uni[0], Uni[3], Uni[2], programs,Uni[4]);
		}   
		sc.close();  //closes the scanner

		HashTable h = new HashTable(LList);
		System.out.println(h.search( "Pakistan","Lahore", "BSCS"));
	}  
}  
