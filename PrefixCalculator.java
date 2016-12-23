/*
* Assignment3: V00810384: Kira Tilcock
* PrefixCalculator.java 
* Through various methods: processInput, isOperator, addOperator, this program calculates 
* simple calculations via stack. By using "+" add, "-" minus, "X" times and "/" divide 
* this code will output the calculates value or will output Invalid Expression, if what is 
* inputed is not able to be calculated. 
* 
*/

public class PrefixCalculator{ 

		public static LLStack<String> s = new LLStack<String>();;
		public static int count; 
		public static String value; 
	  

  public static void main(String[] args){
		processInput(args); 
	}	
		
	//This method carries the bulk of the program.  		 		
  public static void processInput(String[] Array){
	//Sets the string value to ""		
				String value = "";  
	//Starts the try      
	 try{ 	
	 			//Looks through the array starting with the first element.
				for (int i=0;i<Array.length; i++){	
					value = Array[i];
					//If the element is a operator it pushed the element on the stack. 
					if(isOperator(value)){
						s.push(value); 
					//If it is not a operator:
					}else{ 
						//If there is a stack and is not an operator it will pop the next two elements. 
						while(s.size() != 0 && !isOperator(s.peek())){
							String poppedValue = s.pop();
							String poppedValue2 = s.pop(); 	
								//If the seconde element is not a operator it will output: "Invalid Expression". 
								if(!isOperator(poppedValue2)){ 
										System.out.println("invalid expression");
										System.exit(-1);
								}
							//Here is reference the value and the two popped values, where the method addOperator
							//can access the elements.
							value = addOperator(poppedValue, poppedValue2, value); 
				        }
				       	//Once the value has been created in addOperator it is pushed on to the stack. 
				        s.push(value); 	
				    }
				    
             	}
        		 //This is just making sure that what is being inputted is a vail expression
        		 if(s.size()==1){
        		 System.out.println(s.pop());
       			 }else if(s.size()>1){ 
        			System.out.println("invalid expression");
        			System.exit(-1);
       			 }
        
    //It catches the exception and prints out invalid expression. 
   		 }catch(StackEmptyException e){
    	//|NumberFormatException
	    	System.out.println("invalid expression");
	    	System.exit(-1);
	    	
	    }catch(NumberFormatException e){
	    	System.out.println("invalid expression");
	    	System.exit(-1);
	    }
	}
	   			
	public static boolean isOperator(String value){
	
	//Here we are comparing if the value equals the element within the brackets. If value does equal the corresponding 
	//element then it returns true.  
	 	if(value.equals("+") || value.equals("-") || value.equals("X") || value.equals("/")){
			return true; 
		}else{
	//If value does not equal one of elements then it returns false. 
			return false; 
		 }   
	}
			
			
	public static String addOperator(String poppedValue, String poppedValue2, String value){ 
		
		int result = 0; 
		int value1 = 0; 
		int value2 = 0;
		
		//Sets the values to integers. 
		value1 = Integer.parseInt(poppedValue);
		value2 = Integer.parseInt(value);
		
		//With the use of if and else statements it first compares the strings and if they are equal it makes the 
		//corresponding calculations. And returns the result as a toString. 
		if(poppedValue2.equals("+")){
			result = (value1 + value2);
			return Integer.toString(result); 
		}else if(poppedValue2.equals("-")){
			result = (value1 - value2); 
				return Integer.toString(result); 
		}else if(poppedValue2.equals("X")){
			result = (value1 * value2); 
				return Integer.toString(result); 
		}else{ 
			result = (value1 / value2); 
				return Integer.toString(result); 
		}
		
		
			
   }
   
}


