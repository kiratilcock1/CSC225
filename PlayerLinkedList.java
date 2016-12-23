/*
* Assignment2: V00810384: Kira Tilcock
* PlayerLinkedList.java 
* Through various methods: addAt, append, size, get, find, removeAt, remove and toString. 
* The program calls other classes, and identifies and modifies a doubly LinkedList and 
* manipulates player objects within the lists, in addition to rearranging the linked
* lists head and tail. 
* Implements PlayerList
*/

public class PlayerLinkedList implements PlayerList

{
	private PlayerNode	head;
	private PlayerNode	tail;

	private	int		count;

	public PlayerLinkedList()
	{
		head = null; 
		tail = null; 
		count = 0; 
	}

	public void addAt (Player p, int pos)
	{
		
	PlayerNode nn = new PlayerNode(p); 
		//If the list is empty the new node will equal the head and the tail. 
		if(count==0){
			head = nn; 
			tail = nn;
		//If it is adding at the first position, nn will now equal to the head. 
		 }else if(pos==0){
			nn.next = head; 
			head.prev = nn;
			head = nn; 
		//If your adding in between nodes, it sets the prevs' and nexts' nodes that will 
		//be on the right and left of nn, to nn next and prev. 
		 }else if(0<pos && pos<count){
			PlayerNode temp = head;
			 for(int i=0;i<pos;i++){
			 		temp = temp.next;
			 }
			 	temp.prev.next = nn;
			 	nn.prev = temp.prev; 
			 	temp.prev = nn;
				nn.next = temp; 
										
			 }	
		count++;	 
	}

	public void append (Player p)
	{	
	
	PlayerNode nn = new PlayerNode(p); 
		//If the list is empty, the head and tail will equal to the item it is appending. 
		if(count==0){
			head = nn;
			tail = nn;
			//Else the nn prev will be inserted at the back of the list. 
		 }else{
				nn.prev = tail;
				tail.next = nn;
				tail = nn;
		 }
		count++;
	}


	public int size()
	{
	//Returns the the size of the list. 
		return count;
	}
	

	public Player  get (int pos)
	{
	//Finds what player to get, and then uses the get method from PlayerNode. 
		PlayerNode temp = head; 
			for(int i = 0;i<pos;i++){ 
			  temp = temp.next; 
			}
			return temp.getPlayer(); 
			
	}

	public int find (Player p)
	{
		PlayerNode tmp = head; 
			for(int i =0; i<count; i++){	
				//If at the position, temp gets the player and compares it to the postion 
				// of p, and if it does it it returns the position. 				
				if(tmp.getPlayer().equals(p)){
					return i; 
			}else{
				tmp = tmp.next;
			}
		 }
		return -1;		
	}
	 
	public void clear()
	{
		//Clears the list. 
		head = null; 
		count = 0; 
	}
	
	public void removeAt (int pos)
	{
		//If the list only has one element and is removed the head and tail are null. 
		if(count==1){ 
			head = null; 
			tail = null; 
		//If it's removing the first element
		}else if(pos==0 && count>1){
			PlayerNode temp = head; 
				head = temp.next; 
				temp.next.prev = null; 
				temp.next = null; 
		//If it is removing the last element
		}else if(pos == (count-1)) {
			PlayerNode temp = tail; 
				tail = temp.prev; 	
		//If it is removing and element in the middle of the list. 
		}else{ 
			PlayerNode temp = head;
			 for(int i=0;i<pos;i++){
			 		temp = temp.next;
			 		}
				temp.next.prev = temp.prev; 
				temp.prev.next = temp.next; 
				temp.setNext(null); 
				temp.setPrev(null); 
			}
			//Removes the element. 
			count--; 
	}
	 
	public void remove (Player p)
	{
		//find the p element, with the conditions that list is positive. 
		int index = find(p);

		while(index != -1) 
		{
		//Removes at the index position. 
			removeAt(index);
			index = find(p);
		}

	}

public String toString()
	{
	//Returns the string of the lists.
	//If there is no list, it returns an empty bracket. 
	if(count==0){
			return "{}";
		}else if(count==1){ 
			String t = "{" + head.getPlayer() + "}";
			return t;
		}else{	
			String t = "{" + head.getPlayer() + ",";
			PlayerNode temp = head.next; 
				for(int i=0; i<count-2; i++){
					t += temp.getPlayer()+",";
					temp = temp.next; 
				}
			t += tail.getPlayer() + "}";
			return t;
		}
}	
	/*
	 * Here you see some basic testing I did before moving on to
	 * the more detailed testing provided by a2tester.java
	 *
 	 * You can run this by typing:
	 * javac PlayerArrayList.java
 	 * java PlayerArrayList
	 *
	 */
	public static void main (String[] args)
	{
	
		PlayerLinkedList l = new PlayerLinkedList();
		
		System.out.println(l);
		l.append(new Player("one"));
		l.append(new Player("two"));
		l.append(new Player("ten"));
		l.append(new Player("five"));
		System.out.println(l);
		System.out.println();
		
		l.clear();
		System.out.println(l);
		System.out.println();	
		
		l.addAt(new Player("one"),0);
		l.addAt(new Player("two"),0);
		l.addAt(new Player("ten"),0);
		l.addAt(new Player("five"),2);
		System.out.println(l);
		System.out.println();
	}


}

