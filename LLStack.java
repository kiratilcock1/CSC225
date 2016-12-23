/*
* Assignment3: V00810384: Kira Tilcock
* LLStack.java 
* This program implements stack, and uses the node.java. 
* Through various methods: size, empty, push, pop, peek, makeEmpty Stacks are given different functions.  
* The program calls other classes, and identifies and modifies Stacks through various methods. 
* Implements Stack
*/
public class LLStack<T> implements Stack<T> {

private Node<T> top; 
private int count; 
	
//Initializes the constructors
 public LLStack(){
	
		top = null; 
		count = 0; 
	}
//Makes a method size and returns the count. 
	public int size(){
		return count;
	}
//Makes a boolean method empty and returns the top element in the stack to null. 
	public boolean empty(){
		return (top == null);
	}
	
//Creates a stack by pushing(adding) an element to the stack. 
	public void push (T element){
		Node<T> newNode = new Node<T>(element);
		newNode.setNext(top);
		top = newNode;
		count++;
	}
//Method pop, "pop's" off the top element of the stack, with the stack exception that it is not empty. 	
	public T pop() throws StackEmptyException{
		
		if(empty()){
			throw new StackEmptyException("Stack empty");
		}else{
			T temp = top.getData();
			top = top.getNext();
			count --;
			return temp; 
		}	
	}
//Method peek looks at the top element in the stack, with the stack exception that it is not empty. 	
	public T peek() throws StackEmptyException{
		
		if(empty()){
			throw new StackEmptyException("Stack empty");
        }		
	  return top.getData();
	}
	
//Method empty makes sets the whole stack to null. 		
	public void makeEmpty(){
		top = null; 
		count = 0; 
	}

}
