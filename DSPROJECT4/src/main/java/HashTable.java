
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class HashTable {
	
	public Node[] Country;
	public Node[] City;
	public Node[] Discipline;
	public University_LinkedList  list;
        public int collisions = 0;
        
        public HashTable( University_LinkedList list)
	{
            buildHash(list);
	}
        
        public void buildHash(University_LinkedList list)
        {
            this.list = list;

            int Size;
            String[] arrtemp;
            
            Size = list.get_Country() + (int)(list.get_Country()/3);
            Size = getPrime(Size);
            Country = new Node[Size];

            arrtemp = list.get_CountryList();
            for(int i = 0 ; i < arrtemp.length ; i++)
            {
                String x = arrtemp[i];
                Node country = new Node(x,true);
                long key = get_Key_Country(country,Country);
//                long key = H15(country,Country);
//                InsertInListLinear(country,Country,key);
                InsertInListAlternate(country,Country,key);
//                InsertInListAlternate(country,Country,key, true);
            }
            System.out.println("The number of collisions  = " + collisions + " out of data Country " + Country.length);
            
            collisions = 0;
            
            
            
            //----------------------------------------------------------------------------------
            
                    Size = list.get_City() + (int)(list.get_City()/3);
                    Size = getPrime(Size);
                    City = new Node[Size];

                    arrtemp = list.get_CityList();
                    for(int i = 0 ; i < arrtemp.length ; i++)
                    {
                        String x = arrtemp[i];
                        Node city = new Node(x,true);
                        long key = get_Key_City(city,City);
//                        long key = H15(city,City);
//                        InsertInListLinear(city,City,key);
                        InsertInListAlternate(city,City,key);
                    }

                    System.out.println("The number of collisions  = " + collisions + " out of data City " + City.length);

                    collisions = 0;
//		//--------------------------------------------------------------------------------------

            Size = list.get_Discipline() + (int)(list.get_Discipline()/3);
            Size = getPrime(Size);
            Discipline = new Node[Size];

            arrtemp = list.get_DisciplineList();
            for(int i = 0 ; i < arrtemp.length ; i++)
            {
                String x = arrtemp[i];
                Node dis = new Node(x,true);
                long key = get_Key_Discipline(dis,Discipline);
//                long key = H15(dis,Discipline);
//                InsertInListLinear(dis,Discipline,key);
                InsertInListAlternate(dis,Discipline,key);
            }

            System.out.println( "The number of collisions  = " + collisions + " out of data Dis " + Discipline.length);
            
            collisions = 0;
            
            
              
//		//----------------------------------------------------------------------------------------
            int total = 0;
            for(int i = 0 ; i < Country.length ; i++)
            {
                if(Country[i] != null)
                {
                    
                    String cty = Country[i].Name;
                    arrtemp = list.get_CityInCountryList(cty);
                    Size = arrtemp.length + (int)(arrtemp.length/3);
                    Size = getPrime(Size);
                    Country[i].SecLayer = new Node[Size];
                    for(int o = 0 ; o < arrtemp.length ; o++)
                    {
                        String ct = arrtemp[o];
                        Node CityInCountry = new Node(ct,true);
                        long key = get_Key_Country_City(CityInCountry,Country[i].SecLayer);
//                        long key = H15(CityInCountry,Country[i].SecLayer);
//                        InsertInListLinear(CityInCountry,Country[i].SecLayer,key);
                        InsertInListAlternate(CityInCountry,Country[i].SecLayer,key);
                    }
                    total = total + Country[i].SecLayer.length;
                }
            }
            System.out.println("The number of collisions  = " + collisions + " out of data Country_City" + total);
            total = 0;
            collisions = 0;

//		//--------------------------------------------------------------------------------------------------------------

        for(int i = 0 ; i < Country.length ; i++)
        {
            if(Country[i] != null)
            {
                String cty = Country[i].Name;
                arrtemp = list.get_DisciplineInCountryList(cty);
                Size = arrtemp.length + (int)(arrtemp.length/3);
                Size = getPrime(Size);

                Country[i].ThirdLayer = new Node[Size];
                for(int o = 0 ; o < arrtemp.length ; o++)
                {
                    String Dis = arrtemp[o];
                    Node CountryWithDiscipline = new Node(Dis,true);
                    long key = get_Key_Country_Discipline(CountryWithDiscipline,Country[i].ThirdLayer);
//                    long key = H15(CountryWithDiscipline,Country[i].ThirdLayer);
                    InsertInListLinear(CountryWithDiscipline,Country[i].ThirdLayer,key);
//                    InsertInListAlternate(CountryWithDiscipline,Country[i].ThirdLayer,key);
                }
                 total = total + Country[i].ThirdLayer.length;
            }
        }
        System.out.println("The number of collisions  = " + collisions + " out of data Country_Dis " + total);
        total = 0;
        collisions = 0;
////		//-------------------------------------------------------------------------------------------------------------------
        for(int i = 0 ; i < City.length ; i++)
        {
                if(City[i] != null)
                {
                    String cty = City[i].Name;
                    arrtemp = list.get_DisciplineInCityList(cty);
                    Size = arrtemp.length + (int)(arrtemp.length/3);
                    Size = getPrime(Size);

                    City[i].SecLayer = new Node[Size];
                    for(int o = 0 ; o < arrtemp.length ; o++)
                    {
                        String Dis = arrtemp[o];
                        Node CityWithDiscipline = new Node(Dis,true);
                        long key = get_Key_City_Discipline(CityWithDiscipline,City[i].SecLayer);
//                        long key = H15(CityWithDiscipline,City[i].SecLayer);
//                        InsertInListLinear(CityWithDiscipline,City[i].SecLayer,key);
                        InsertInListAlternate(CityWithDiscipline,City[i].SecLayer,key);
                    }

                    total = total + City[i].SecLayer.length;
                }
        }
        System.out.println("The number of collisions  = " + collisions + " out of data City_Dis " + total);
        total = 0;
        collisions = 0;
//		//------------------------------------------------------------------------------------------------------------------------
        for(int i = 0 ; i < Country.length ; i++)
        {
            if(Country[i] != null)
            {

                for(int q = 0 ; q < Country[i].SecLayer.length ; q++)
                {
                    if(Country[i].SecLayer[q] != null)
                    {
                        String ct = Country[i].SecLayer[q].Name;
                        arrtemp = list.get_DisciplineInCityList(ct);
                        Size = arrtemp.length + (int)(arrtemp.length/3);
                        Size = getPrime(Size);
                        Country[i].SecLayer[q].ThirdLayer = new Node[Size];

                        for(int o = 0 ; o < arrtemp.length ; o++)
                        {
                            String Dis = arrtemp[o];
                            Node CountryWithDisciplineAndCity = new Node(Dis,true);
                            long key = get_Key_City_Discipline(CountryWithDisciplineAndCity,Country[i].SecLayer[q].ThirdLayer);
//                                long key = H15(CountryWithDisciplineAndCity,Country[i].SecLayer[q].ThirdLayer);
//                                InsertInListLinear(CountryWithDisciplineAndCity,Country[i].SecLayer[q].ThirdLayer,key);
                            InsertInListAlternate(CountryWithDisciplineAndCity,Country[i].SecLayer[q].ThirdLayer,key);
                        }
                        total = total + Country[i].SecLayer[q].ThirdLayer.length;
                    }
                }
            }
        }

        
            System.out.println("The number of collisions  = " + collisions + " out of data Cnty_City_Dis " + total);
            total = 0;
            collisions = 0;
            
            insertUNI();
        }
	
	private int getPrime(int n) 
        {
		 
             while(true) 
             {
                if (isPrime(n)) return n;
                n++;
             }
	 }
	 
	 private boolean isPrime(int n) 
	 {
		 for (int i = 2; i <= n/2; i++) 
		 {
                    if (n % i == 0) return false;
		 }
		 return true;
	 }
        
        public long get_Key_City_Discipline(Node N, Node[] arr)
        {
	String s = N.Name;
	int key = 0;
	for(int i = 0; i < s.length(); i++)
	{
            char c = s.charAt(i);
            switch(c)
            {
                case 'B':
                        key = key + 1*i;
                        break;
                case 'b':
                        key = key + 1*i;
                        break;
                case 'C':
                        key = key + 2*i;
                        break;
                case 'c':
                        key = key + 2*i;
                        break;
                case 'D':
                        key = key + 3*i;
                        break;
                case 'd':
                        key = key + 3*i;
                        break;
                case 'F':
                        key = key + 4*i;
                        break;
                case 'f':
                        key = key + 4*i;
                        break;
                case 'G':
                        key = key + 5*i;
                        break;
                case 'g':
                        key = key + 5*i;
                        break;
                case 'H':
                        key = key + 6*i;
                        break;
                case 'h':
                        key = key + 6*i;
                        break;
                case 'J':
                        key = key + 7*i;
                        break;
                case 'j':
                        key = key + 7*i;
                        break;
                case 'K':
                        key = key + 8*i;
                        break;
                case 'k':
                        key = key + 8*i;
                        break;
                case 'L':
                        key = key + 9*i;
                        break;
                case 'l':
                        key = key + 9*i;
                        break;
                case 'M':
                        key = key + 10*i;
                        break;
                case 'm':
                        key = key + 10*i;
                        break;
                case 'N':
                        key = key + 11*i;
                        break;
                case 'n':
                        key = key + 11*i;
                        break;
                case 'P':
                        key = key + 12*i;
                        break;
                case 'p':
                        key = key + 12*i;
                        break;
                case 'Q':
                        key = key + 13*i;
                        break;
                case 'q':
                        key = key + 13*i;
                        break;
                case 'R':
                        key = key + 14*i;
                        break;
                case 'r':
                        key = key + 14*i;
                        break;
                case 'S':
                        key = key + 15*i;
                        break;
                case 's':
                        key = key + 15*i;
                        break;
                case 'T':
                        key = key + 16*i;
                        break;
                case 't':
                        key = key + 16*i;
                        break;
                case 'V':
                        key = key + 17*i;
                        break;
                case 'v':
                        key = key + 17*i;
                        break;
                case 'W':
                        key = key + 18*i;
                        break;
                case 'w':
                        key = key + 18*i;
                        break;
                case 'X':
                        key = key + 19*i;
                        break;
                case 'x':
                        key = key + 19*i;
                        break;
                case 'Y':
                        key = key + 20*i;
                        break;
                case 'y':
                        key = key + 20*i;
                        break;
                case 'Z':
                        key = key + 21*i;
                        break;
                case 'z':
                        key = key + 21*i;
                        break;
            }
	}
	return key;

        }
        public long get_Key_Country_City(Node N , Node[] arr)
        {
           String s = N.Name;
            long key = 0;
            for(int i = 0; i < s.length(); i++)
            {
                    char c = s.charAt(i);
                    switch(c)
                    {
                        case 'B':
                                key = key + 1;
                                break;
                        case 'b':
                                key = key + 1;
                                break;
                        case 'C':
                                key = key + 2;
                                break;
                        case 'c':
                                key = key + 2;
                                break;
                        case 'D':
                                key = key + 3;
                                break;
                        case 'd':
                                key = key + 3;
                                break;
                        case 'F':
                                key = key + 4;
                                break;
                        case 'f':
                                key = key + 4;
                                break;
                        case 'G':
                                key = key + 5;
                                break;
                        case 'g':
                                key = key + 5;
                                break;
                        case 'H':
                                key = key + 6;
                                break;
                        case 'h':
                                key = key + 6;
                                break;
                        case 'J':
                                key = key + 7;
                                break;
                        case 'j':
                                key = key + 7;
                                break;
                        case 'K':
                                key = key + 8;
                                break;
                        case 'k':
                                key = key + 8;
                                break;
                        case 'L':
                                key = key + 9;
                                break;
                        case 'l':
                                key = key + 9;
                                break;
                        case 'M':
                                key = key + 10;
                                break;
                        case 'm':
                                key = key + 10;
                                break;
                        case 'N':
                                key = key + 11;
                                break;
                        case 'n':
                                key = key + 11;
                                break;
                        case 'P':
                                key = key + 12;
                                break;
                        case 'p':
                                key = key + 12;
                                break;
                        case 'Q':
                                key = key + 13;
                                break;
                        case 'q':
                                key = key + 13;
                                break;
                        case 'R':
                                key = key + 14;
                                break;
                        case 'r':
                                key = key + 14;
                                break;
                        case 'S':
                                key = key + 15;
                                break;
                        case 's':
                                key = key + 15;
                                break;
                        case 'T':
                                key = key + 16;
                                break;
                        case 't':
                                key = key + 16;
                                break;
                        case 'V':
                                key = key + 17;
                                break;
                        case 'v':
                                key = key + 17;
                                break;
                        case 'W':
                                key = key + 18;
                                break;
                        case 'w':
                                key = key + 18;
                                break;
                        case 'X':
                                key = key + 19;
                                break;
                        case 'x':
                                key = key + 19;
                                break;
                        case 'Y':
                                key = key + 20;
                                break;
                        case 'y':
                                key = key + 20;
                                break;
                        case 'Z':
                                key = key + 21;
                                break;
                        case 'z':
                                key = key + 21;
                                break;
                    }
            }
            return key;
        }
        public long get_Key_Country_Discipline(Node N , Node[] arr)
        {
             String str = N.Name;
		long sum = 0;

                str = str.toUpperCase();
                for(int i = 0 ; i < str.length() ; i++)
                {
                    char x = str.charAt(i) ;
                    sum = sum + (long)(((long)x - 65 + 1) * (long)(Math.pow(53,i)));
                }
		return sum;

        }
        
        public long get_Key_Discipline(Node N,Node[] arr)
        {
            String str = N.Name;
            long sum = 0;

            str = str.toUpperCase();
            for(int i = 0 ; i < str.length() ; i++)
            {
                char x = str.charAt(i) ;
                sum = sum + (long)(((long)x - 65 + 1) * (long)(Math.pow(66,i)));
            }
            return sum;
        }
        
        public long get_Key_Country(Node N,Node[] arr)
	{
		
            String str = N.Name;
            long sum = 0;

            str = str.toUpperCase();
            for(int i = 0 ; i < str.length() ; i++)
            {
                char x = str.charAt(i) ;
                sum = sum + (long)(((long)x - 65 + 1) * (long)(Math.pow(66,i)));
            }
            return sum;

	}
        
        public long H1(Node N, Node[] arr)
        {
            String str = N.Name;
		long sum = 0;

                for(int i = 0 ; i < str.length() ; i++)
                {
                    sum = sum + str.charAt(i) * i;
                }
                return sum;
        }
        public long H2(Node N, Node[] arr)
        {
            String str = N.Name;
		long sum = 0;

                for(int i = 0 ; i < str.length() ; i++)
                {
                    sum = sum + str.charAt(i) * 13;
                }
                return sum;
        }
        public long H3(Node N,Node[] arr)
{
	String s = N.Name;
	long key = 0;
	int p = 1;
	for(int i = 0; i < s.length(); i++)
	{
		char c = s.charAt(i);
		p = getPrime(p);
		key = key +(long) (p*(int)c);
		p++;
	}
	return key;
}
        
        public long H4(Node N, Node[] arr)
        {

	String s = N.Name;
	long key = 0;
	for(int i = 0; i < s.length(); i++)
	{
		char c = s.charAt(i);
		if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U')
			key = key + (long)(13*(int)c);
	}
	return key;

        }
        
       public long H5(Node N, Node[] arr)
        {

	String s = N.Name;
	long key = 0;
	for(int i = 0; i < s.length(); i++)
	{
		char c = s.charAt(i);
		if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U')
			key = key + (long)(13*((int)c%arr.length));
	}
	return key;

        }
       
       public long H6(Node N,Node[] arr)
       {
		String str = N.Name;
		long sum = 0;

                str = str.toUpperCase();
                for(int i = 0 ; i < str.length() ; i++)
                {
                    char x = str.charAt(i) ;
                    sum = sum + (((long)x - 65 + 1)* (long) (13));
                }
		return sum;

	
       }
       
       public long H7(Node N,Node[] arr)
       {
           String str = N.Name;
		long sum = 0;

                str = str.toUpperCase();
                for(int i = 0 ; i < str.length() ; i++)
                {
                    char x = str.charAt(i) ;
                    sum = sum + ((long)x - 65 + 1);
                }
		return sum;
       }
       
       public long H8(Node N , Node[] arr)
       {
           String str = N.Name;
		long sum = 0;

                str = str.toUpperCase();
                for(int i = 0 ; i < str.length() ; i++)
                {
                    char x = str.charAt(i) ;
                    sum = sum + (long)(((long)x) * (long)(Math.pow(53,i)));
                }
		return sum;
       }
       
       public long H9(Node N , Node[] arr)
       {
           String str = N.Name;
		long sum = 0;

                str = str.toUpperCase();
                for(int i = 0 ; i < str.length() ; i++)
                {
                    char x = str.charAt(i) ;
                    sum = sum + (long)(((long)x - 65 + 1) * (long)(53*i));
                }
		return sum;
       }
       
       public long H10(Node N,Node[] arr)
       {
            String s = N.Name;
            long key = 0;
            for(int i = 0; i < s.length(); i++)
            {
                    char c = s.charAt(i);
                    switch(c)
                    {
                        case 'B':
                                key = key + 1;
                                break;
                        case 'b':
                                key = key + 1;
                                break;
                        case 'C':
                                key = key + 2;
                                break;
                        case 'c':
                                key = key + 2;
                                break;
                        case 'D':
                                key = key + 3;
                                break;
                        case 'd':
                                key = key + 3;
                                break;
                        case 'F':
                                key = key + 4;
                                break;
                        case 'f':
                                key = key + 4;
                                break;
                        case 'G':
                                key = key + 5;
                                break;
                        case 'g':
                                key = key + 5;
                                break;
                        case 'H':
                                key = key + 6;
                                break;
                        case 'h':
                                key = key + 6;
                                break;
                        case 'J':
                                key = key + 7;
                                break;
                        case 'j':
                                key = key + 7;
                                break;
                        case 'K':
                                key = key + 8;
                                break;
                        case 'k':
                                key = key + 8;
                                break;
                        case 'L':
                                key = key + 9;
                                break;
                        case 'l':
                                key = key + 9;
                                break;
                        case 'M':
                                key = key + 10;
                                break;
                        case 'm':
                                key = key + 10;
                                break;
                        case 'N':
                                key = key + 11;
                                break;
                        case 'n':
                                key = key + 11;
                                break;
                        case 'P':
                                key = key + 12;
                                break;
                        case 'p':
                                key = key + 12;
                                break;
                        case 'Q':
                                key = key + 13;
                                break;
                        case 'q':
                                key = key + 13;
                                break;
                        case 'R':
                                key = key + 14;
                                break;
                        case 'r':
                                key = key + 14;
                                break;
                        case 'S':
                                key = key + 15;
                                break;
                        case 's':
                                key = key + 15;
                                break;
                        case 'T':
                                key = key + 16;
                                break;
                        case 't':
                                key = key + 16;
                                break;
                        case 'V':
                                key = key + 17;
                                break;
                        case 'v':
                                key = key + 17;
                                break;
                        case 'W':
                                key = key + 18;
                                break;
                        case 'w':
                                key = key + 18;
                                break;
                        case 'X':
                                key = key + 19;
                                break;
                        case 'x':
                                key = key + 19;
                                break;
                        case 'Y':
                                key = key + 20;
                                break;
                        case 'y':
                                key = key + 20;
                                break;
                        case 'Z':
                                key = key + 21;
                                break;
                        case 'z':
                                key = key + 21;
                                break;
                    }
            }
            return key;
       }
       
       public long H11(Node N,Node[] arr)
       {
           String s = N.Name;
	long key = 0;
	for(int i = 0; i < s.length(); i++)
	{
		char c = s.charAt(i);
		switch(c)
		{
			case 'B':
				key = key + 1*i;
				break;
			case 'b':
				key = key + 1*i;
				break;
			case 'C':
				key = key + 2*i;
				break;
			case 'c':
				key = key + 2*i;
				break;
			case 'D':
				key = key + 3*i;
				break;
			case 'd':
				key = key + 3*i;
				break;
			case 'F':
				key = key + 4*i;
				break;
			case 'f':
				key = key + 4*i;
				break;
			case 'G':
				key = key + 5*i;
				break;
			case 'g':
				key = key + 5*i;
				break;
			case 'H':
				key = key + 6*i;
				break;
			case 'h':
				key = key + 6*i;
				break;
			case 'J':
				key = key + 7*i;
				break;
			case 'j':
				key = key + 7*i;
				break;
			case 'K':
				key = key + 8*i;
				break;
			case 'k':
				key = key + 8*i;
				break;
			case 'L':
				key = key + 9*i;
				break;
			case 'l':
				key = key + 9*i;
				break;
			case 'M':
				key = key + 10*i;
				break;
			case 'm':
				key = key + 10*i;
				break;
			case 'N':
				key = key + 11*i;
				break;
			case 'n':
				key = key + 11*i;
				break;
			case 'P':
				key = key + 12*i;
				break;
			case 'p':
				key = key + 12*i;
				break;
			case 'Q':
				key = key + 13*i;
				break;
			case 'q':
				key = key + 13*i;
				break;
			case 'R':
				key = key + 14*i;
				break;
			case 'r':
				key = key + 14*i;
				break;
			case 'S':
				key = key + 15*i;
				break;
			case 's':
				key = key + 15*i;
				break;
			case 'T':
				key = key + 16*i;
				break;
			case 't':
				key = key + 16*i;
				break;
			case 'V':
				key = key + 17*i;
				break;
			case 'v':
				key = key + 17*i;
				break;
			case 'W':
				key = key + 18*i;
				break;
			case 'w':
				key = key + 18*i;
				break;
			case 'X':
				key = key + 19*i;
				break;
			case 'x':
				key = key + 19*i;
				break;
			case 'Y':
				key = key + 20*i;
				break;
			case 'y':
				key = key + 20*i;
				break;
			case 'Z':
				key = key + 21*i;
				break;
			case 'z':
				key = key + 21*i;
				break;
		}
	}
	return key;
       }
       
       public long H12(Node N , Node[] arr)
       {
        String s = N.Name;
	long key = 0;
	for(int i = 0; i < s.length(); i++)
	{
		char c = s.charAt(i);
		switch(c)
		{
			case 'B':
				key = key + (1*i % arr.length);
				break;
			case 'b':
				key = key + (1*i % arr.length);
				break;
			case 'C':
				key = key + (2*i % arr.length);
				break;
			case 'c':
				key = key + (2*i % arr.length);
				break;
			case 'D':
				key = key + (3*i % arr.length);
				break;
			case 'd':
				key = key + (3*i % arr.length);
				break;
			case 'F':
				key = key + (4*i % arr.length);
				break;
			case 'f':
				key = key + (4*i % arr.length);
				break;
			case 'G':
				key = key + (5*i % arr.length);
				break;
			case 'g':
				key = key + (5*i % arr.length);
				break;
			case 'H':
				key = key + (6*i % arr.length);
				break;
			case 'h':
				key = key + (6*i % arr.length);
				break;
			case 'J':
				key = key + (7*i % arr.length);
				break;
			case 'j':
				key = key + (7*i % arr.length);
				break;
			case 'K':
				key = key + (8*i  % arr.length);
				break;
			case 'k':
				key = key + (8*i % arr.length);
				break;
			case 'L':
				key = key + (9*i % arr.length);
				break;
			case 'l':
				key = key + (9*i % arr.length);
				break;
			case 'M':
				key = key + (10*i % arr.length);
				break;
			case 'm':
				key = key + (10*i % arr.length);
				break;
			case 'N':
				key = key + (11*i % arr.length);
				break;
			case 'n':
				key = key + (11*i % arr.length);
				break;
			case 'P':
				key = key + (12*i % arr.length);
				break;
			case 'p':
				key = key + (12*i % arr.length);
				break;
			case 'Q':
				key = key + (13*i % arr.length);
				break;
			case 'q':
				key = key + (13*i % arr.length);
				break;
			case 'R':
				key = key + (14*i % arr.length);
				break;
			case 'r':
				key = key + (14*i % arr.length);
				break;
			case 'S':
				key = key + (15*i % arr.length);
				break;
			case 's':
				key = key + (15*i % arr.length);
				break;
			case 'T':
				key = key + (16*i % arr.length);
				break;
			case 't':
				key = key + (16*i % arr.length);
				break;
			case 'V':
				key = key + (17*i % arr.length);
				break;
			case 'v':
				key = key + (17*i % arr.length);
				break;
			case 'W':
				key = key + (18*i % arr.length);
				break;
			case 'w':
				key = key + (18*i % arr.length);
				break;
			case 'X':
				key = key + (19*i % arr.length);
				break;
			case 'x':
				key = key + (19*i % arr.length);
				break;
			case 'Y':
				key = key + (20*i % arr.length);
				break;
			case 'y':
				key = key + (20*i % arr.length);
				break;
			case 'Z':
				key = key + (21*i % arr.length);
				break;
			case 'z':
				key = key + (21*i % arr.length);
				break;
		}
	}
	return key;
       }
       
       public long H13(Node N , Node[] arr)
       {
       
           String str = N.Name;
		long sum = 0;

                str = str.toUpperCase();
                for(int i = 0 ; i < str.length() ; i++)
                {
                    char x = str.charAt(i) ;
                    sum = sum + (long)(((long)x - 65 + 1) * (long)(Math.pow(53,i)));
                }
		return sum;
       
       }
       
       public long H14(Node N , Node[] arr)
       {
       
            String str = N.Name;
            long sum = 0;

            str = str.toUpperCase();
            for(int i = 0 ; i < str.length() ; i++)
            {
                char x = str.charAt(i) ;
                sum = sum + (long)(((long)x - 65 + 1) * (long)(Math.pow(66,i)));
            }
            return sum;
       
       }
       
       
       public long H15(Node N , Node[] arr)
       {
       
           String str = N.Name;
		long sum = 0;

                str = str.toUpperCase();
                for(int i = 0 ; i < str.length() ; i++)
                {
                    char x = str.charAt(i) ;
                    long key = ((long)x - 65 + 1);
                    if(key % 2 == 0)
                    {
                        sum = sum + (long)(((long)key) * (long)(Math.pow(8,i)));

                    }
                    if(key % 2 == 1)
                    {
                        sum = sum + (long)(((long)key) * (long)(Math.pow(36,i)));
                    }
                }
		return sum;
       
       }
       
       
       
       
        public long get_Key_City(Node N,Node[] arr)
	{
		String str = N.Name;
		long sum = 0;

                str = str.toUpperCase();
                for(int i = 0 ; i < str.length() ; i++)
                {
                    char x = str.charAt(i) ;
                    long key = ((long)x - 65 + 1);
                    if(key % 2 == 0)
                    {
                        sum = sum + (long)(((long)key) * (long)(Math.pow(8,i)));

                    }
                    if(key % 2 == 1)
                    {
                        sum = sum + (long)(((long)key) * (long)(Math.pow(36,i)));
                    }
                }
		return sum;

	}
        
        public void InsertInListLinear(Node N , Node[] arr,long key)
        {
            int index = 0;
		int i = 0;
		while (true)
		{
			index =Math.abs(((int)Math.abs(key) + i) % arr.length);
			if (arr[index] == N)       
                        {                    
                            break;
                        }
			else if (arr[index] == null)
			{
				arr[index] = N;
				break;
			}
			i++;
                        collisions++;
		}
	}
        
        
        public void InsertInListAlternate(Node N , Node[] arr , long key)
        {
            int index = 0;
		int i = 0;
		while (true)
		{
                    if ( i % 2 == 0)
                        index =Math.abs(((int)Math.abs(key) + i*i) % arr.length);
                    else if ( i % 2 == 1)
                        index =Math.abs(((int)Math.abs(key) + i) % arr.length);
                    if (arr[index] == N)       
                    {
                        break;
                    }
                    else if (arr[index] == null)
                    {
                        arr[index] = N;
                        break;
                    }
                    i++;
                    collisions++;
		}
        }
        
        
        
	public void print()
	{
		for(int i = 0 ; i < Country.length ; i++ )
		{
			if(Country[i] != null && Country[i].equals("Italy"))
			{
				System.out.println(Country[i].Name +"--" + i +" \n -");
				for(int p = 0 ; p < Country[i].SecLayer.length ; p++)
				{
					if(Country[i].SecLayer[p] != null)
					{
						System.out.println( Country[i].SecLayer[p].Name   +"--" + p +" \n --");
						for(int o = 0 ; o < Country[i].SecLayer[p].ThirdLayer.length ; o++)
						{
							if(Country[i].SecLayer[p].ThirdLayer[o] != null)
							{
								System.out.println(Country[i].SecLayer[p].ThirdLayer[o].Name  + o );
//								Country[i].SecLayer[p].ThirdLayer[o].UniTree.LNR(Country[i].SecLayer[p].ThirdLayer[o].UniTree.root);
							}
						}
					}
					
				}
				System.out.println("\n" + "\n");
			}
		}
	}
	
	public void Print()
	{
		for(int i = 0 ; i < Country.length ; i++ )
		{
			if(Country[i] != null)
			{
				System.out.println(Country[i].Name + " \n -");
				for(int p = 0 ; p < Country[i].SecLayer.length ; p++)
				{

					if(Country[i].SecLayer[p] != null)
					{
						System.out.println(p + ")"+Country[i].SecLayer[p].Name + " \n -----");
						Country[i].SecLayer[p].UniTree.LNR(Country[i].SecLayer[p].UniTree.root);
					}
				}
			}
		}
	}
	
	public void PRINT()
	{
		for(int i = 0 ; i < Country.length ; i++ )
		{
			if(Country[i] != null)
			{
				System.out.println( i+ " = " + Country[i].Name);
				System.out.println();
//				Discipline[i].UniTree.LNR(Discipline[i].UniTree.root);
				
				System.out.println();
				System.out.println();
				System.out.println();
			}
			System.out.println("---------------------------------------------------");
		}
	}
	
	public void insertUNI()
        {
            for(int o = 0 ; o < Country.length;o++)
            {
                    if(Country[o]!= null)
                    {
                            University_Node temp = list.Head;
                            while(temp!= null)
                            {	
                                    if(temp.Country.equals(Country[o].Name))
                                    {
                                            Country[o].UniTree.insert(temp);
                                    }
                                    temp = temp.next;
                            }
                    }
            }

            for(int o = 0 ; o < City.length;o++)
            {
                    if(City[o]!= null)
                    {
                            University_Node temp = list.Head;
                            while(temp!= null)
                            {	
                                    if(temp.City.equals(City[o].Name))
                                    {
                                            City[o].UniTree.insert(temp);
                                    }
                                    temp = temp.next;
                            }
                    }
            }

            for(int o = 0 ; o < Discipline.length;o++)
            {
                    if(Discipline[o]!= null)
                    {
                            University_Node temp = list.Head;
                            while(temp!= null)
                            {	
                                    for(int i = 0 ; i < temp.Discipline.length ; i++)
                                    {
                                            if(temp.Discipline[i].equals(Discipline[o].Name))
                                            {
                                                    Discipline[o].UniTree.insert(temp);
                                            }
                                    }
                                    temp = temp.next;

                            }
                    }
            }


            for(int i = 0 ; i < Country.length;i++)
            {
                    if(Country[i] != null)
                    {
                            for(int o = 0 ; o < Country[i].SecLayer.length ; o++)
                            {
                                    if(Country[i].SecLayer[o] != null )
                                    {
                                            University_Node temp = list.Head;
                                            while(temp!= null)
                                            {	
                                                    if((temp.Country.equals(Country[i].Name)) && (temp.City.equals(Country[i].SecLayer[o].Name)))
                                                    {
                                                            Country[i].SecLayer[o].UniTree.insert(temp);
                                                    }
                                                    temp = temp.next;
                                            }
                                    }
                            }
                    }
            }


            for(int i = 0 ; i < Country.length;i++)
            {
                    if(Country[i] != null)
                    {
                            for(int o = 0 ; o < Country[i].ThirdLayer.length ; o++)
                            {
                                    if(Country[i].ThirdLayer[o] != null )
                                    {
                                            University_Node temp = list.Head;
                                            while(temp!= null)
                                            {	
                                                    for(int w = 0 ; w < temp.Discipline.length;w++)
                                                    {
                                                            if((temp.Country.equals(Country[i].Name)) && (temp.Discipline[w].equals(Country[i].ThirdLayer[o].Name)))
                                                            {
                                                                    Country[i].ThirdLayer[o].UniTree.insert(temp);
                                                            }
                                                    }
                                                    temp = temp.next;
                                            }
                                    }
                            }
                    }
            }

            for(int i = 0 ; i < City.length;i++)
            {
                    if(City[i] != null)
                    {
                            for(int o = 0 ; o < City[i].SecLayer.length ; o++)
                            {
                                    if(City[i].SecLayer[o] != null )
                                    {
                                            University_Node temp = list.Head;
                                            while(temp!= null)
                                            {	
                                                    for(int w = 0 ; w < temp.Discipline.length;w++)
                                                    {
                                                            if((temp.City.equals(City[i].Name)) && (temp.Discipline[w].equals(City[i].SecLayer[o].Name)))
                                                            {
                                                                    City[i].SecLayer[o].UniTree.insert(temp);
                                                            }
                                                    }
                                                    temp = temp.next;
                                            }
                                    }
                            }
                    }
            }

            for(int i = 0 ; i < Country.length;i++)
            {
                    if(Country[i] != null)
                    {
                            for(int o = 0 ; o < Country[i].SecLayer.length ; o++)
                            {
                                    if(Country[i].SecLayer[o] != null )
                                    {

                                            for(int c = 0 ; c < Country[i].SecLayer[o].ThirdLayer.length ; c++)
                                            {
                                                    if(Country[i].SecLayer[o].ThirdLayer[c] != null)
                                                    {
                                                            University_Node temp = list.Head;
                                                            while(temp!= null)
                                                            {	for(int w = 0 ; w < temp.Discipline.length;w++)
                                                                    {
                                                                            if((temp.Country.equals(Country[i].Name)) && (temp.City.equals(Country[i].SecLayer[o].Name)) && (temp.Discipline[w].equals(Country[i].SecLayer[o].ThirdLayer[c].Name)))
                                                                            {
                                                                                    Country[i].SecLayer[o].ThirdLayer[c].UniTree.insert(temp);
                                                                            }
                                                                    }
                                                                    temp = temp.next;
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
            }		
	}
	
	public String search(String country, String city, String discipline)
	{
            String str = "";
		if (country != null && city == null && discipline == null)
		{
			//Display all universities in THIS country                    
                        str = country;
                        long sum = 0;
                        str = str.toUpperCase();
                        for(int i = 0 ; i < str.length() ; i++)
                        {
                            char x = str.charAt(i) ;
                            sum = sum + (long)(((long)x - 65 + 1)* (long)(Math.pow( 66 , i)));
                        }
                        int index = (int)( Math.abs((sum)));
			int Rehash = Math.abs(index % Country.length);
			int i = 0;
                        
			while (Country[Rehash] != null)
                        {
				if( Country[Rehash].Name.equals(country))
				{
					break;
				}
				i++;
				if ( i % 2 == 0)
                                    Rehash = Math.abs((index + i*i) % Country.length);
                                else if(i%2 == 1)
                                    Rehash = Math.abs((index + i) % Country.length);
                                
				
			}
			index = Rehash;
			if (Country[index] == null)
				return "ERROR: Country does not have any universities in Top 200 List";
			else if (Country[index].Name.equals(country))
				return Country[index].UniTree.LNR(Country[index].UniTree.root);	
		}
//-------------------------------------------------------------------------------------------------------
		
		else if (country == null && city != null && discipline == null)
		{
			//Display all universities in THIS city

                        str = city;
                        long sum = 0;
                        int index = 0;

                        str = str.toUpperCase();
                        for(int i = 0 ; i < str.length() ; i++)
                        {
                            char x = str.charAt(i) ;
                            long key = ((long)x - 65 + 1);
                            if(key % 2 == 0)
                            {
                                sum = sum + (long)(((long)key) * (long)(Math.pow(8,i)));

                            }
                            if(key % 2 == 1)
                            {
                                sum = sum + (long)(((long)key) * (long)(Math.pow(36,i)));
                            }
                        }
			int i = 0;
                        index =(int)( Math.abs((sum)));
			int Rehash = Math.abs(index % City.length);
			
			
			while (City[Rehash] != null)
			{	
		
				if(City[Rehash] != null && City[Rehash].Name.equals(city))
				{
                                    break;
				}
				i++;
                                if ( i % 2 == 0)
                                    Rehash = Math.abs((index + i*i) % City.length);
                                else if(i%2 == 1)
                                    Rehash = Math.abs((index + i) % City.length);
				
			}
			index = Rehash;
			if (City[index] == null)
				return "ERROR: City does not have any universities in Top 200 List";
			else if (City[index].Name.equals(city))
				return City[index].UniTree.LNR(City[index].UniTree.root);
		}
		else if (country == null && city == null && discipline != null)
		{
			
			int index = 0;
                        long sum = 0;
			for (int i = discipline.length() - 1; i >= 0; i--)
			{
                              char x = discipline.charAt(i);
                              sum = sum + (long)(((long)x - 65 + 1) * (long)(Math.pow(66,i)));
			}
			
			int i = 0;
                        index = (int)Math.abs(sum);
			index = Math.abs(index % Discipline.length);
			int Rehash = index;
                        
			while (Discipline[Rehash] != null)
			{	
		
				if(Discipline[Rehash] != null && Discipline[Rehash].Name.equals(discipline))
				{
					break;
				}
				i++;
                                if(i%2 == 0)
				Rehash = Math.abs((index + i*i) % Discipline.length);
                                else if(i%2 == 0)
				Rehash = Math.abs((index + i) % Discipline.length);
				System.out.println(Rehash);
				
			}
			index = Rehash;
			if (Discipline[index] == null)
                                return "ERROR: Discipline does not have any universities in Top 200 List";
			else if (Discipline[index].Name.equals(discipline))
				return Discipline[index].UniTree.LNR(Discipline[index].UniTree.root);
		}
		else if (country != null && city != null && discipline == null)
		{
			//Display all universities in THIS city of THIS country
			int CountryIndex = 0;
			int index = 0;
                        str = country;
                        long sum = 0;
                        str = str.toUpperCase();
                        for(int i = 0 ; i < str.length() ; i++)
                        {
                            char x = str.charAt(i) ;
                            sum = sum + (long)(((long)x - 65 + 1)* (long)(Math.pow( 66 , i)));
                        }
                        index = (int)( Math.abs((sum)));
			int Rehash = Math.abs(index % Country.length);
			int i = 0;
                        
			while (Country[Rehash] != null)
                        {
				if( Country[Rehash].Name.equals(country))
				{
					break;
				}
				i++;
				if ( i % 2 == 0)
                                    Rehash = Math.abs((index + i*i) % Country.length);
                                else if(i%2 == 1)
                                    Rehash = Math.abs((index + i) % Country.length);
                                
				
			}
			index = Rehash;
			if (Country[index] == null)
				return "ERROR: Country does not have any universities in Top 200 List";
			else if (Country[index].Name.equals(country))
				CountryIndex = Rehash;
			index = 0;
                        
                        
                        
                        String s = city;
                        int key = 0;
                        for(int o = 0; o < s.length(); o++)
                        {
                                char c = s.charAt(o);
                                switch(c)
                                {
                                        case 'B':
                                                key = key + 1;
                                                break;
                                        case 'b':
                                                key = key + 1;
                                                break;
                                        case 'C':
                                                key = key + 2;
                                                break;
                                        case 'c':
                                                key = key + 2;
                                                break;
                                        case 'D':
                                                key = key + 3;
                                                break;
                                        case 'd':
                                                key = key + 3;
                                                break;
                                        case 'F':
                                                key = key + 4;
                                                break;
                                        case 'f':
                                                key = key + 4;
                                                break;
                                        case 'G':
                                                key = key + 5;
                                                break;
                                        case 'g':
                                                key = key + 5;
                                                break;
                                        case 'H':
                                                key = key + 6;
                                                break;
                                        case 'h':
                                                key = key + 6;
                                                break;
                                        case 'J':
                                                key = key + 7;
                                                break;
                                        case 'j':
                                                key = key + 7;
                                                break;
                                        case 'K':
                                                key = key + 8;
                                                break;
                                        case 'k':
                                                key = key + 8;
                                                break;
                                        case 'L':
                                                key = key + 9;
                                                break;
                                        case 'l':
                                                key = key + 9;
                                                break;
                                        case 'M':
                                                key = key + 10;
                                                break;
                                        case 'm':
                                                key = key + 10;
                                                break;
                                        case 'N':
                                                key = key + 11;
                                                break;
                                        case 'n':
                                                key = key + 11;
                                                break;
                                        case 'P':
                                                key = key + 12;
                                                break;
                                        case 'p':
                                                key = key + 12;
                                                break;
                                        case 'Q':
                                                key = key + 13;
                                                break;
                                        case 'q':
                                                key = key + 13;
                                                break;
                                        case 'R':
                                                key = key + 14;
                                                break;
                                        case 'r':
                                                key = key + 14;
                                                break;
                                        case 'S':
                                                key = key + 15;
                                                break;
                                        case 's':
                                                key = key + 15;
                                                break;
                                        case 'T':
                                                key = key + 16;
                                                break;
                                        case 't':
                                                key = key + 16;
                                                break;
                                        case 'V':
                                                key = key + 17;
                                                break;
                                        case 'v':
                                                key = key + 17;
                                                break;
                                        case 'W':
                                                key = key + 18;
                                                break;
                                        case 'w':
                                                key = key + 18;
                                                break;
                                        case 'X':
                                                key = key + 19;
                                                break;
                                        case 'x':
                                                key = key + 19;
                                                break;
                                        case 'Y':
                                                key = key + 20;
                                                break;
                                        case 'y':
                                                key = key + 20;
                                                break;
                                        case 'Z':
                                                key = key + 21;
                                                break;
                                        case 'z':
                                                key = key + 21;
                                                break;
                                }
                        }
                        index = Math.abs(key); 
			Rehash = Math.abs(index % Country[CountryIndex].SecLayer.length);
                        System.out.println(Country[CountryIndex].SecLayer[Rehash].Name);
			i = 1;
			int FirstAppearance = Rehash;
			while (FirstAppearance != (index + i) %	Country[CountryIndex].SecLayer.length)
			{
				if (Country[CountryIndex].SecLayer[Rehash] != null && Country[CountryIndex].SecLayer[Rehash].Name.equals(city))
					break;
				if (Country[CountryIndex].SecLayer[Rehash] == null)
					break;
                                if ( i % 2 == 0)
				Rehash = Math.abs((index + i*i) % Country[CountryIndex].SecLayer.length);
                                else if ( i % 2 == 1)
                                Rehash = Math.abs((index + i) % Country[CountryIndex].SecLayer.length);
				i++;
			}
			index = Rehash;
                        System.out.println(Country[CountryIndex].Name);
			if (Country[CountryIndex].SecLayer[index] == null || (Country[CountryIndex].SecLayer[index] != null && Country[CountryIndex].SecLayer[index].Name.equals(city) == false))
				return "ERROR: City does not have any universities in Top 200 List";
			else if (Country[CountryIndex].SecLayer[index].Name.equals(city))
				return Country[CountryIndex].SecLayer[index].UniTree.LNR(Country[CountryIndex].SecLayer[index].UniTree.root);
			
		}
		else if (country != null && city == null && discipline != null)
		{
			//Display all universities in THIS discipline in THIS country
			int CountryIndex = 0;
			int index = 0;
                        str = country;
                        long sum = 0;
                        str = str.toUpperCase();
                        for(int i = 0 ; i < str.length() ; i++)
                        {
                            char x = str.charAt(i) ;
                            sum = sum + (long)(((long)x - 65 + 1)* (long)(Math.pow( 66 , i)));
                        }
                        index = (int)( Math.abs((sum)));
			int Rehash = Math.abs(index % Country.length);
			int i = 0;
                        
			while (Country[Rehash] != null)
                        {
				if( Country[Rehash].Name.equals(country))
				{
					break;
				}
				i++;
				if ( i % 2 == 0)
                                    Rehash = Math.abs((index + i*i) % Country.length);
                                else if(i%2 == 1)
                                    Rehash = Math.abs((index + i) % Country.length);
                                
				
			}
			index = Rehash;
			if (Country[index] == null)
				return "ERROR: Country does not have any universities in Top 200 List";
			else if (Country[index].Name.equals(country))
                            CountryIndex = Rehash;
			index = 0;
                        String s = discipline;
                        for(int o = 0; o < s.length(); o++)
                        {
                                 char x = str.charAt(i) ;
                                 sum = sum + (long)(((long)x - 65 + 1) * (long)(Math.pow(53,i)));
                                
                        }
                        index = Math.abs((int)sum);
//                        index = (int)Math.abs(sum);
			Rehash = Math.abs(index % Country[CountryIndex].ThirdLayer.length);
			int FirstAppearance = Rehash;
			i = 1;
			while (FirstAppearance != (index + i) % Country[CountryIndex].ThirdLayer.length)
			{
				if (Country[CountryIndex].ThirdLayer[Rehash] != null && Country[CountryIndex].ThirdLayer[Rehash].Name.equals(discipline))
					break;
				Rehash = Math.abs((index + i) % Country[CountryIndex].ThirdLayer.length);
				i++;
			}
			index = Rehash;
			if (Country[CountryIndex].ThirdLayer[index] == null || (Country[CountryIndex].ThirdLayer[index] != null && !Country[CountryIndex].ThirdLayer[index].Name.equals(discipline)))
				return "ERROR: Discipline does not have any universities in this country in Top 200 List";
			else if (Country[CountryIndex].ThirdLayer[index].Name.equals(discipline))
				return Country[CountryIndex].ThirdLayer[index].UniTree.LNR(Country[CountryIndex].ThirdLayer[index].UniTree.root);
		}
		else if (country == null && city != null && discipline != null)
		{
			//Display all universities in THIS discipline in THIS city
			int CityIndex = 0;                    
                        str = city;
                        long sum = 0;
                        int index = 0;

                        str = str.toUpperCase();
                        for(int i = 0 ; i < str.length() ; i++)
                        {
                            char x = str.charAt(i) ;
                            long key = ((long)x - 65 + 1);
                            if(key % 2 == 0)
                            {
                                sum = sum + (long)(((long)key) * (long)(Math.pow(8,i)));

                            }
                            if(key % 2 == 1)
                            {
                                sum = sum + (long)(((long)key) * (long)(Math.pow(36,i)));
                            }
                        }
			int i = 0;
                        index = (int) Math.abs(sum);
//                        index = Math.abs((int)Math.abs(sum)%City.length);
			int Rehash = Math.abs(index % City.length);
			
			
			while (City[Rehash] != null)
			{	
		
				if(City[Rehash] != null && City[Rehash].Name.equals(city))
				{
					break;
				}
				i++;
                                if ( i % 2 == 0)
                                    Rehash = Math.abs((index + i*i) % City.length);
                                else if(i%2 == 1)
                                    Rehash = Math.abs((index + i) % City.length);
				
			}
			index = Rehash;
			if (City[index] == null)
			{
				return "ERROR: City does not have any universities in Top 200 List";
			}
			else if (City[index].Name.equals(city))
				CityIndex = index;
			index = 0;
                        
                        String s = discipline;
                        int key = 0;
                        for(int o = 0; o < s.length(); o++)
                        {
                                char c = s.charAt(o);
                                switch(c)
                                {
                                        case 'B':
                                                key = key + 1*o;
                                                break;
                                        case 'b':
                                                key = key + 1*o;
                                                break;
                                        case 'C':
                                                key = key + 2*o;
                                                break;
                                        case 'c':
                                                key = key + 2*o;
                                                break;
                                        case 'D':
                                                key = key + 3*o;
                                                break;
                                        case 'd':
                                                key = key + 3*o;
                                                break;
                                        case 'F':
                                                key = key + 4*o;
                                                break;
                                        case 'f':
                                                key = key + 4*o;
                                                break;
                                        case 'G':
                                                key = key + 5*o;
                                                break;
                                        case 'g':
                                                key = key + 5*o;
                                                break;
                                        case 'H':
                                                key = key + 6*o;
                                                break;
                                        case 'h':
                                                key = key + 6*o;
                                                break;
                                        case 'J':
                                                key = key + 7*o;
                                                break;
                                        case 'j':
                                                key = key + 7*o;
                                                break;
                                        case 'K':
                                                key = key + 8*o;
                                                break;
                                        case 'k':
                                                key = key + 8*o;
                                                break;
                                        case 'L':
                                                key = key + 9*o;
                                                break;
                                        case 'l':
                                                key = key + 9*o;
                                                break;
                                        case 'M':
                                                key = key + 10*o;
                                                break;
                                        case 'm':
                                                key = key + 10*o;
                                                break;
                                        case 'N':
                                                key = key + 11*o;
                                                break;
                                        case 'n':
                                                key = key + 11*o;
                                                break;
                                        case 'P':
                                                key = key + 12*o;
                                                break;
                                        case 'p':
                                                key = key + 12*o;
                                                break;
                                        case 'Q':
                                                key = key + 13*o;
                                                break;
                                        case 'q':
                                                key = key + 13*o;
                                                break;
                                        case 'R':
                                                key = key + 14*o;
                                                break;
                                        case 'r':
                                                key = key + 14*o;
                                                break;
                                        case 'S':
                                                key = key + 15*o;
                                                break;
                                        case 's':
                                                key = key + 15*o;
                                                break;
                                        case 'T':
                                                key = key + 16*o;
                                                break;
                                        case 't':
                                                key = key + 16*o;
                                                break;
                                        case 'V':
                                                key = key + 17*o;
                                                break;
                                        case 'v':
                                                key = key + 17*o;
                                                break;
                                        case 'W':
                                                key = key + 18*o;
                                                break;
                                        case 'w':
                                                key = key + 18*o;
                                                break;
                                        case 'X':
                                                key = key + 19*o;
                                                break;
                                        case 'x':
                                                key = key + 19*o;
                                                break;
                                        case 'Y':
                                                key = key + 20*o;
                                                break;
                                        case 'y':
                                                key = key + 20*o;
                                                break;
                                        case 'Z':
                                                key = key + 21*o;
                                                break;
                                        case 'z':
                                                key = key + 21*o;
                                                break;
                                }
                        }
                        index = Math.abs(key);
                        
                        Rehash = Math.abs(index%City[CityIndex].SecLayer.length);
			int FirstAppearance = Rehash;
                        i = 1;
			while (FirstAppearance != (index + i) % City[CityIndex].SecLayer.length)
			{
				if (City[CityIndex].SecLayer[Rehash] != null && City[CityIndex].SecLayer[Rehash].Name.equals(discipline))
					break;
                                if(i % 2 == 0)
                                    Rehash = Math.abs((index + i*i) % City[CityIndex].SecLayer.length);
                                else if(i%2 == 1)
                                    Rehash = Math.abs((index + i) % City[CityIndex].SecLayer.length);
				i++;
			}
			index = Rehash;
			if (City[CityIndex].SecLayer[index] == null || (City[CityIndex].SecLayer[index] != null && !City[CityIndex].SecLayer[index].Name.equals(discipline)))
				return "ERROR: Discipline does not have any universities in this city in Top 200 List";
			else if (City[CityIndex].SecLayer[index].Name.equals(discipline))
				return City[CityIndex].SecLayer[index].UniTree.LNR(City[CityIndex].SecLayer[index].UniTree.root);
			
		}
		else if (country != null && city != null && discipline != null)
		{
                    System.out.println(country + " -------------" + city + " ------------------ " + discipline);
			//Display all universities in THIS discipline in THIS city in THIS country
			int CountryIndex = 0;
			int CityIndex = 0;
			int index = 0;

                        str = country;
                        long sum = 0;
                        str = str.toUpperCase();
                        for(int i = 0 ; i < str.length() ; i++)
                        {
                            char x = str.charAt(i) ;
                            sum = sum + (long)(((long)x - 65 + 1)* (long)(Math.pow( 66 , i)));
                        }
                        index = (int)( Math.abs((sum)));
			int Rehash = Math.abs(index % Country.length);
			int i = 0;
                        
			while (Country[Rehash] != null)
                        {
				if( Country[Rehash].Name.equals(country))
				{
					break;
				}
				i++;
				if ( i % 2 == 0)
                                    Rehash = Math.abs((index + i*i) % Country.length);
                                else if(i%2 == 1)
                                    Rehash = Math.abs((index + i) % Country.length);
                                
				
			}
			index = Rehash;
			if (Country[index] == null)
				return "ERROR: Country does not have any universities in Top 200 List";
			else if (Country[index].Name.equals(country))
                            	CountryIndex = Rehash;

                        index = 0;
                        
                        
                        
                        String s = city;
                        int key = 0;
                        for(int o = 0; o < s.length(); o++)
                        {
                                char c = s.charAt(o);
                                switch(c)
                                {
                                        case 'B':
                                                key = key + 1;
                                                break;
                                        case 'b':
                                                key = key + 1;
                                                break;
                                        case 'C':
                                                key = key + 2;
                                                break;
                                        case 'c':
                                                key = key + 2;
                                                break;
                                        case 'D':
                                                key = key + 3;
                                                break;
                                        case 'd':
                                                key = key + 3;
                                                break;
                                        case 'F':
                                                key = key + 4;
                                                break;
                                        case 'f':
                                                key = key + 4;
                                                break;
                                        case 'G':
                                                key = key + 5;
                                                break;
                                        case 'g':
                                                key = key + 5;
                                                break;
                                        case 'H':
                                                key = key + 6;
                                                break;
                                        case 'h':
                                                key = key + 6;
                                                break;
                                        case 'J':
                                                key = key + 7;
                                                break;
                                        case 'j':
                                                key = key + 7;
                                                break;
                                        case 'K':
                                                key = key + 8;
                                                break;
                                        case 'k':
                                                key = key + 8;
                                                break;
                                        case 'L':
                                                key = key + 9;
                                                break;
                                        case 'l':
                                                key = key + 9;
                                                break;
                                        case 'M':
                                                key = key + 10;
                                                break;
                                        case 'm':
                                                key = key + 10;
                                                break;
                                        case 'N':
                                                key = key + 11;
                                                break;
                                        case 'n':
                                                key = key + 11;
                                                break;
                                        case 'P':
                                                key = key + 12;
                                                break;
                                        case 'p':
                                                key = key + 12;
                                                break;
                                        case 'Q':
                                                key = key + 13;
                                                break;
                                        case 'q':
                                                key = key + 13;
                                                break;
                                        case 'R':
                                                key = key + 14;
                                                break;
                                        case 'r':
                                                key = key + 14;
                                                break;
                                        case 'S':
                                                key = key + 15;
                                                break;
                                        case 's':
                                                key = key + 15;
                                                break;
                                        case 'T':
                                                key = key + 16;
                                                break;
                                        case 't':
                                                key = key + 16;
                                                break;
                                        case 'V':
                                                key = key + 17;
                                                break;
                                        case 'v':
                                                key = key + 17;
                                                break;
                                        case 'W':
                                                key = key + 18;
                                                break;
                                        case 'w':
                                                key = key + 18;
                                                break;
                                        case 'X':
                                                key = key + 19;
                                                break;
                                        case 'x':
                                                key = key + 19;
                                                break;
                                        case 'Y':
                                                key = key + 20;
                                                break;
                                        case 'y':
                                                key = key + 20;
                                                break;
                                        case 'Z':
                                                key = key + 21;
                                                break;
                                        case 'z':
                                                key = key + 21;
                                                break;
                                }
                        }
                        index = Math.abs(key); 
			Rehash = Math.abs(index % Country[CountryIndex].SecLayer.length);
                        System.out.println(Country[CountryIndex].SecLayer[Rehash].Name);
			i = 1;
			int FirstAppearance = Rehash;
			while (FirstAppearance != (index + i) %	Country[CountryIndex].SecLayer.length)
			{
				if (Country[CountryIndex].SecLayer[Rehash] != null && Country[CountryIndex].SecLayer[Rehash].Name.equals(city))
					break;
				if (Country[CountryIndex].SecLayer[Rehash] == null)
					break;
                                if ( i % 2 == 0)
				Rehash = Math.abs((index + i*i) % Country[CountryIndex].SecLayer.length);
                                else if ( i % 2 == 1)
                                Rehash = Math.abs((index + i) % Country[CountryIndex].SecLayer.length);
				i++;
			}
			index = Rehash;
                        System.out.println(Country[CountryIndex].Name);
			if (Country[CountryIndex].SecLayer[index] == null || (Country[CountryIndex].SecLayer[index] != null && Country[CountryIndex].SecLayer[index].Name.equals(city) == false))
				return "ERROR: City does not have any universities in Top 200 List";
			else if (Country[CountryIndex].SecLayer[index].Name.equals(city))
				CityIndex = index;
			index = 0;
                        s = discipline;
                        key = 0;
                        for(int o = 0; o < s.length(); o++)
                        {
                                char c = s.charAt(o);
                                switch(c)
                                {
                                        case 'B':
                                                key = key + 1*o;
                                                break;
                                        case 'b':
                                                key = key + 1*o;
                                                break;
                                        case 'C':
                                                key = key + 2*o;
                                                break;
                                        case 'c':
                                                key = key + 2*o;
                                                break;
                                        case 'D':
                                                key = key + 3*o;
                                                break;
                                        case 'd':
                                                key = key + 3*o;
                                                break;
                                        case 'F':
                                                key = key + 4*o;
                                                break;
                                        case 'f':
                                                key = key + 4*o;
                                                break;
                                        case 'G':
                                                key = key + 5*o;
                                                break;
                                        case 'g':
                                                key = key + 5*o;
                                                break;
                                        case 'H':
                                                key = key + 6*o;
                                                break;
                                        case 'h':
                                                key = key + 6*o;
                                                break;
                                        case 'J':
                                                key = key + 7*o;
                                                break;
                                        case 'j':
                                                key = key + 7*o;
                                                break;
                                        case 'K':
                                                key = key + 8*o;
                                                break;
                                        case 'k':
                                                key = key + 8*o;
                                                break;
                                        case 'L':
                                                key = key + 9*o;
                                                break;
                                        case 'l':
                                                key = key + 9*o;
                                                break;
                                        case 'M':
                                                key = key + 10*o;
                                                break;
                                        case 'm':
                                                key = key + 10*o;
                                                break;
                                        case 'N':
                                                key = key + 11*o;
                                                break;
                                        case 'n':
                                                key = key + 11*o;
                                                break;
                                        case 'P':
                                                key = key + 12*o;
                                                break;
                                        case 'p':
                                                key = key + 12*o;
                                                break;
                                        case 'Q':
                                                key = key + 13*o;
                                                break;
                                        case 'q':
                                                key = key + 13*o;
                                                break;
                                        case 'R':
                                                key = key + 14*o;
                                                break;
                                        case 'r':
                                                key = key + 14*o;
                                                break;
                                        case 'S':
                                                key = key + 15*o;
                                                break;
                                        case 's':
                                                key = key + 15*o;
                                                break;
                                        case 'T':
                                                key = key + 16*o;
                                                break;
                                        case 't':
                                                key = key + 16*o;
                                                break;
                                        case 'V':
                                                key = key + 17*o;
                                                break;
                                        case 'v':
                                                key = key + 17*o;
                                                break;
                                        case 'W':
                                                key = key + 18*o;
                                                break;
                                        case 'w':
                                                key = key + 18*o;
                                                break;
                                        case 'X':
                                                key = key + 19*o;
                                                break;
                                        case 'x':
                                                key = key + 19*o;
                                                break;
                                        case 'Y':
                                                key = key + 20*o;
                                                break;
                                        case 'y':
                                                key = key + 20*o;
                                                break;
                                        case 'Z':
                                                key = key + 21*o;
                                                break;
                                        case 'z':
                                                key = key + 21*o;
                                                break;
                                }
                        }
                        index = Math.abs(key);
                        Rehash = Math.abs(index %  Country[CountryIndex].SecLayer[CityIndex].ThirdLayer.length);                                
			i = 1;
			FirstAppearance = Rehash;
			while ( FirstAppearance != (index +i ) % Country[CountryIndex].SecLayer[CityIndex].ThirdLayer.length)
			{
				if (Country[CountryIndex].SecLayer[CityIndex].ThirdLayer[Rehash] != null && Country[CountryIndex].SecLayer[CityIndex].ThirdLayer[Rehash].Name.equals(discipline))
					break;
                                if(i%2 == 0)
                                    Rehash = Math.abs((index + i*i) % Country[CountryIndex].SecLayer[CityIndex].ThirdLayer.length);
                                else if(i%2 == 1)
                                    Rehash = Math.abs((index + i) % Country[CountryIndex].SecLayer[CityIndex].ThirdLayer.length);
				i++;
			}
			index = Rehash;
                        
			if (Country[CountryIndex].SecLayer[CityIndex].ThirdLayer[index] == null || (Country[CountryIndex].SecLayer[CityIndex].ThirdLayer[index] != null && !Country[CountryIndex].SecLayer[CityIndex].ThirdLayer[index].Name.equals(discipline)))
				return "ERROR: Discipline does not have any universities in this city in this country in Top 200 List";
			else if (Country[CountryIndex].SecLayer[CityIndex].ThirdLayer[index].Name.equals(discipline))
				return Country[CountryIndex].SecLayer[CityIndex].ThirdLayer[index].UniTree.LNR(Country[CountryIndex].SecLayer[CityIndex].ThirdLayer[index].UniTree.root);
		}
           return "";
	}
        
    public void Update(String Uni_Name ,String Country,String City,String[] Descipline, String rank) throws IOException
    {
        boolean x = list.contains(Uni_Name);
        if(x == false)
        {
            University_Node temp = list.Head;
            list.insert(Uni_Name, Country, City, Descipline, rank);
            buildHash(list);
            
            File file = new File("C:\\Users\\Dell\\Desktop\\DS-Lab\\DSPROJECT4\\src\\main\\java\\Fake.csv");
            FileWriter writer = new FileWriter(file);
            while(temp != null)
            {
                writer.write("\n");
                String Dis = temp.Discipline[0];
                for(int i = 1 ; i < temp.Discipline.length;i++)
                {
                    Dis = Dis + "-" + temp.Discipline[i];
                }
                writer.write(temp.Name + "," +Dis + "," + temp.City + "," + temp.Country + "," + temp.rank);
                temp = temp.next;
            }
            writer.close();
        }
        else
        {
            System.out.println("University already exist");
        }
    }



    
}
