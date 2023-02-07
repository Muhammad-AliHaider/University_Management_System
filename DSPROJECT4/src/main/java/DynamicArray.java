
public class DynamicArray
{

	 String[] arr;
	 int currIndex;
	 int capacity;

	 public DynamicArray() 
	 { // default constructor to create an array
		 arr = new String [5];
	 currIndex=-1;
	 capacity = 0;
	 }
	 
	 public DynamicArray(int size) 
	 { // constructor to create an array
		 arr = new String[size];
	 currIndex=-1;
	 capacity = 0;
	 }
	 
	 
	 //---------------------------toSting method-------------------------------------
	 public String toString()
	 {
		 String str = "";								// 1
		 for(int i = 0 ; i<arr.length ; i++)                                            // N+1
		 {
			 str = str + arr[i] + "\n";						// N
		 }
		 return str;                                                                    // 1
	 }															// = 2N+ 3
	 // The Big O of toSting Method is                                                      = O(N)
	 
	 
	 // -------------------------------------Trim Function--------------------------------------
	 public void Trim()
	 {
		 int value = 0;											// 1
		 for(int i = 0;i<arr.length ;i++)                                                               // N+1
		 {														
			 if(arr[i] == null)									// N
			 value++;											// N
		 }
		 String[] arr1 = new String[arr.length - value];                                                // 1
		 for(int i = 0; i< arr1.length ; i++)                                                           // N+1
		 {
			 arr1[i] = arr[i];									// N
		 }
		 arr = arr1;											// 1
	 }															// = 5N+5
	 // The Big O of Trim Function is                                                                       = O(N)
	
		public int Length() 
		{
			return capacity;													// 1
		}																		//= 1

	public void addAtEnd(String v) {
		 if (currIndex == arr.length-1)                                                                 // 1 
		 {		 
			 String[] arr1 =new String [arr.length*2];                                              // 1
		 
	 	 for(int i = 0 ; i < arr.length ; i++)                                                          // N+1
	 	 {
	 		 arr1[i] = arr[i];									// N
	 	 }
	 	 currIndex++;											// 1
	 	 arr1[currIndex] = v;                                                                           // 1
	 	 capacity++;											// 1
	 	 arr = arr1;											// 1
	 	 
	 	 
		 }
		 else if (currIndex == -1){                                                                     // 1
			 currIndex++;										// 1
			 arr[currIndex] = v;                                                                    // 1
			 capacity++;										// 1
		 }
		 else{
			 currIndex++;										// 1
			 arr[currIndex] = v;                                                                    // 1
			 capacity++;										// 1
                                                                                                                // in the worst case only the first condition runs
		 }												// = 7N+12
		 }
		// Big O of Add at end is                                                                       // O(N)
		
public boolean contains(String x)
{
	for(int  i = 0 ; i<= currIndex ; i++)
	{
		if(arr[i].equals(x))
		{
			return true;
		}
	}
	return false;
}

public String[] ReturnArray()
{
	Trim();
	return arr;
        // O(N)

}

	
}
