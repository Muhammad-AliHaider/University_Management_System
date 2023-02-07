
public class University_Node 
{

	public String Name ="";
	public String Country ="";
	public String City ="";
	public String[]  Discipline;
	public int rank;
	public University_Node next;

	
	public University_Node(String Name ,String Country,String City,String[] Discipline, String rank) // O(1)
	{
		this.Name = Name;
		this.Country = Country;
                System.out.println(rank);
		this.rank = Integer.valueOf(rank);
		this.City = City;
		this.Discipline = Discipline;
	}
	
	public String toString()//O(1)
	{
		String str = "";
		
		str = str + "Name = " + Name  + "\n";
		str = str + "Country = " + Country  + "\n";
		str = str + "City = " + City  + "\n";
		str = str + "rank = " + rank  + "\n";
		
		str = str + "Disciplines :" +" \n";
		
		for(int i = 0 ; i < Discipline.length ; i++)
		{
                    str = str + i + ") "+ Discipline[i]  + "\n";
		}
		
		return str;
		
	}
	
}
