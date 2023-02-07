
public class University_LinkedList {

	public University_Node Head;
	public University_Node Tail;
	
	public void insert(String Name ,String Country,String City,String[] Descipline, String rank)
	{
            University_Node New_N = new University_Node(Name,Country,City,Descipline,rank);

            if(Head == null) 
            {
                Head = Tail = New_N;
            }
            else
            {
                Tail.next = New_N;
                Tail = New_N;
            }
	}
	
	public String toString()
	{
		String str = "";
		University_Node temp = Head;
		String Str_temp = "";
		while(temp.next != null)
		{
			Str_temp = "Name = " + temp.Name + "\n";
			Str_temp = Str_temp + ("Country = " + temp.Country) + "\n";
			Str_temp = Str_temp +("City = " + temp.City)+ "\n";
			Str_temp = Str_temp +("Programs offered are = ");
			String x = "";
			 for(int i = 0; i < temp.Discipline.length - 1 ; i++ ) 
			 {
				 x = x +  temp.Discipline[i] + ",";
			 }
			 x = x +  temp.Discipline[temp.Discipline.length - 1 ];
			 Str_temp = Str_temp + x+ "\n";
			 Str_temp = Str_temp +"Rank = "+  temp.rank + " \n";
			 
			 str = str + "\n " + Str_temp;
			 temp = temp.next;
		}
		
		Str_temp = "Name = " + temp.Name + "\n";
		Str_temp = Str_temp + ("Country = " + temp.Country) + "\n";
		Str_temp = Str_temp +("City = " + temp.City)+ "\n";
		Str_temp = Str_temp +("Programs offered are = ");
		String x = "";
		 for(int i = 0; i < temp.Discipline.length - 1 ; i++ ) 
		 {
			 x = x +  temp.Discipline[i] + ",";
		 }
		 x = x +  temp.Discipline[temp.Discipline.length - 1 ];
		 Str_temp = Str_temp + x+ "\n";
		 Str_temp = Str_temp + "Rank = "+temp.rank + " \n";
		 
		 
		 str = str + "\n " + Str_temp;
		 
		return str;
	}
	
	public boolean contains(String Uni_Name)
        {
            University_Node temp = Head;
            
            while( temp != null)
            {
                if(temp.Name.equals(Uni_Name))
                    return true;
                
                temp = temp.next;
            }
            return false;
        }
	
	public int get_Country()
	{
		University_Node temp = Head;
		
		DynamicArray arr = new DynamicArray();
		while(temp != null)
		{
			boolean x = arr.contains(temp.Country);
			if(x == false)
			{
				arr.addAtEnd(temp.Country);
			}
			temp = temp.next;
		}
		return arr.Length();
	}
	
	public int get_City()
	{
		University_Node temp = Head;
		
		DynamicArray arr = new DynamicArray();
		
		while(temp != null)
		{
			boolean x = arr.contains(temp.City);
			if(x == false)
			{
				arr.addAtEnd(temp.City );
			}
			temp = temp.next;
		}
		return arr.Length();
	}
	

	
	public int get_Discipline()
	{
		University_Node temp = Head;
		
		DynamicArray arr = new DynamicArray();
		while(temp != null)
		{
			for(int i  = 0 ; i < temp.Discipline.length ; i++)
			{
				boolean x = arr.contains(temp.Discipline[i]);
				if(x == false)
				{
					arr.addAtEnd(temp.Discipline[i]);
				}
			}
			temp = temp.next;
		}
		return arr.Length();
	}

	
	
	
	public int get_UniInCountry(String country )
	{
		University_Node temp = Head;
		
		int i = 0;
		
		while(temp != null )
		{
			if(temp.Country.equals(country))
			{
				i++;
			}
			temp = temp.next;
		}
		return i;
	}
	
	public int get_UniInCity(String city)
	{
		University_Node temp = Head;
		
		int i = 0;
		
		while(temp != null )
		{
			if(temp.City.equals(city))
			{
				i++;
			}
			temp = temp.next;
		}
		return i;
	}
	
	public int get_UniInDiscipline(String discipline)
	{
		University_Node temp = Head;
		
		int i = 0;
		
		while(temp != null )
		{
			for(int k = 0 ; k < temp.Discipline.length ; k++)
			{
				if(temp.Discipline[k].equals(discipline))
				{
					i++;
				}
			}
			temp = temp.next;
		}
		return i;
	}
	
	public int get_UniInCountryCity(String country , String city )
	{
		University_Node temp = Head;
		
		int i = 0;
		
		while(temp != null )
		{
			if(temp.City.equals(city) && temp.Country.equals(country) )
			{
				i++;
			}
			temp = temp.next;
		}
		return i;
	}
	
	public int get_UniInCountryDiscipline(String country , String discipline )
	{
		University_Node temp = Head;
		
		int i = 0;
		
		while(temp != null )
		{
			if(temp.Country.equals(country))
			{
				for(int k = 0 ; k < temp.Discipline.length ; k++)
				{
					if(temp.Discipline[k].equals(discipline))
					{
						i++;
					}
				}
			}
			temp = temp.next;
		}
		return i;
	}
	
	public int get_UniInCityDiscipline(String city , String discipline )
	{
		University_Node temp = Head;
		
		int i = 0;
		
		while(temp != null )
		{
			if(temp.City.equals(city))
			{
				for(int k = 0 ; k < temp.Discipline.length ; k++)
				{
					if(temp.Discipline[k].equals(discipline))
					{
						i++;
					}
				}
			}
			temp = temp.next;
		}
		return i;
	}
	
	public int get_UniInCountryCityDiscipline(String country,String city , String discipline )
	{
		University_Node temp = Head;
		
		int i = 0;
		
		while(temp != null )
		{
			if(temp.Country.equals(country) && temp.City.equals(city))
			{
				for(int k = 0 ; k < temp.Discipline.length ; k++)
				{
					if(temp.Discipline[k].equals(discipline))
					{
						i++;
					}
				}
			}
			temp = temp.next;
		}
		return i;
	}
	
	public String[] get_CountryList()
	{
		University_Node temp = Head;
		
		DynamicArray arr = new DynamicArray();
		while(temp != null)
		{
			boolean x = arr.contains(temp.Country);
			if(x == false)
			{
				arr.addAtEnd(temp.Country);
			}
			temp = temp.next;
		}
		
		String[] array = arr.ReturnArray(); 
		return array;
	}
	
	public String[] get_CityList()
	{
		University_Node temp = Head;
		
		DynamicArray arr = new DynamicArray();
		while(temp != null)
		{
			boolean x = arr.contains(temp.City);
			if(x == false)
			{
				arr.addAtEnd(temp.City);
			}
			temp = temp.next;
		}
		
		String[] array = arr.ReturnArray(); 
		return array;
	}
	
	public String[] get_DisciplineList()
	{
		University_Node temp = Head;
		
		DynamicArray arr = new DynamicArray();
		while(temp != null)
		{
			for(int i  = 0 ; i < temp.Discipline.length ; i++)
			{
				boolean x = arr.contains(temp.Discipline[i]);
				if(x == false)
				{
					arr.addAtEnd(temp.Discipline[i]);
				}
			}
			temp = temp.next;
		}
		String[] array = arr.ReturnArray();
		return array;
	}
	
	public String[] get_CityInCountryList(String Country)
	{
		University_Node temp = Head;
		
		DynamicArray arr = new DynamicArray();
		while(temp != null)
		{
			if(temp.Country.equals(Country))
			{
				boolean x = arr.contains(temp.City);
				if(x == false)
				{
					arr.addAtEnd(temp.City);
				}
			}
			temp = temp.next;
			
		}
		
		String[] array = arr.ReturnArray(); 
		return array;
	}
	
	
	public String[] get_DisciplineInCountryList(String Country)
	{
		University_Node temp = Head;
		
		DynamicArray arr = new DynamicArray();
		while(temp != null)
		{
			if(temp.Country.equals(Country))
			{
				for(int i  = 0 ; i < temp.Discipline.length ; i++)
				{
					boolean x = arr.contains(temp.Discipline[i]);
					if(x == false)
					{
						arr.addAtEnd(temp.Discipline[i]);
					}
				}
			}
			temp = temp.next;
			
		}
		
		String[] array = arr.ReturnArray(); 
		return array;
	}
	
	public String[] get_DisciplineInCityList(String City)
	{
		University_Node temp = Head;
		
		DynamicArray arr = new DynamicArray();
		while(temp != null)
		{
			if(temp.City.equals(City))
			{
				for(int i  = 0 ; i < temp.Discipline.length ; i++)
				{
					boolean x = arr.contains(temp.Discipline[i]);
					if(x == false)
					{
						arr.addAtEnd(temp.Discipline[i]);
					}
				}
			}
			temp = temp.next;
			
		}
		
		String[] array = arr.ReturnArray(); 
		return array;
	}
	
	public String[] get_DisciplineInCityAndCountryList(String Country , String City)
	{
		University_Node temp = Head;
		
		DynamicArray arr = new DynamicArray();
		while(temp != null)
		{
			if(temp.Country.equals(Country) && temp.City.equals(City))
			{
				for(int i  = 0 ; i < temp.Discipline.length ; i++)
				{
					boolean x = arr.contains(temp.Discipline[i]);
					if(x == false)
					{
						arr.addAtEnd(temp.Discipline[i]);
					}
				}
			}
			temp = temp.next;
			
		}
		
		String[] array = arr.ReturnArray(); 
		return array;
	}
	
	
}
