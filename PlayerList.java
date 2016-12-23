/* 
* Kira Tilcock 
* V00810384
* Assignment1
* PlayerList
* Through different methods PlayerList takes players and values from the 
* tester and Player to use acording to the speicfic methods. 
* 
*/ 


public class PlayerList
{
	private static final int INITIAL_SIZE = 2;
	
	private Player[] storage;
	private int count;

	//
	// Purpose:
	//	Initialize a new instance of PlayerList
    // of size INITIAL_SIZE and
    // count initialized to 0
	//
	
	public PlayerList()
	{
		storage = new Player[INITIAL_SIZE];
		count = 0;
		
	}

	//
	// Purpose: 
	// 	return the element at position index
	//
	// Pre-Conditions:
	// 	for a PlayerList x:
	//	index >= 0 AND
	//	index < x.size()
	//
	// Examples:
	//
	// If x is {"Derek Jeter:300", "Jose Bautista:400", "Michael Saunders:250"} then:
	//	x.get(0) returns "Derek Jeter:300"
	//	x.get(1) returns "Jose Bautista:400"
	//	the result of calling x.get(3) is undefined
	//
	public Player get (int index)
	{
	if(index >=0 && index < storage.length){
		// NOTE NOTE NOTE
		// 
		// This line needs to be removed.  It is only
		// so the tester works.  You should NOT
		// allocate a new PhoneNumber in this method
		return storage[index];
	}else{
		return null;
		}
	} 


	// Purpose:
	//	remove the element at position index

	
	public void remove (int index)
	{
	
	if(index >=0 && index < storage.length) {
	
	for (int i = index; i < count-1; i++) {
			storage[i] = storage[i+1];
			
			                                       }
     
     count--;
											}
	}

	//
	// Purpose:
	//	return the number of elements in the list
	//
	// Returns:
	//	the number of elements in the list
	//
	public int size()
	{
		return count;
	}

	// 
	// Purpose:
	//	add the player p to the list
	//
	public void add (Player p)
	
	{
	if(storage.length == count){ 
	Player [] temp = new Player [storage.length + 1];
	for(int i = 0; i < count; i++){ 
	temp[i] = storage[i];
								  }
	storage = temp;
								} 
	storage[count] = p;
	count++; 
	}
	

	//
	// Purpose:
	//	return the index where p is in the list, -1 otherwise
	//
	// Pre-Conditions:
	//	none
	//
	// Returns:
	//	true - if p is in the list
	//	false - if p is not in the list
	//
	public int find (Player p)
			{
		for(int i = 0; i < count; i++){ 
		
		if(storage[i].equals(p)){
			
			return i;	
			
								}		
									  }
			return -1;
				
			}
}