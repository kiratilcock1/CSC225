/* TripleSum.java
   CSC 225 - Spring 2016
   Programming Assignment 1 - Template for TripleSum
   
   This template includes some testing code to help verify the implementation.
   To interactively provide test inputs, run the program with
	java TripleSum
	
   To conveniently test the algorithm with a large input, create a 
   text file containing space-separated integer values and run the program with
	java TripleSum file.txt
   where file.txt is replaced by the name of the text file.

   B. Bird & M. Simpson - 05/01/2014
*/

import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.io.File;

//Do not change the name of the TripleSum class
public class TripleSum{
	/* TripleSum225()
		The input array A will contain non-negative integers. The function
		will search the array A for a triple of elements which sum to 225.
		If such a triple is found, return true. Otherwise, return false.
		The function may modify the array A.
		Do not change the function signature (name/parameters).
	*/
	public static boolean TripleSum225(int[] A){
        
        int n = A.length;
        
        int[] green = new int[226];
        for (int i = 0; i < n; i++){
            int val = A[i];
            if (val <= 225) {
                green[val] = 1;
            }
        }
        

  	     for (int j = 0; j < green.length; j++){
            if (green[j] == 1){
            	int num = 225 - j;
                	for (int k = j+1 ; k <= num; k++){
                    	if(green[k] == 1){ 
                    		if(green[num-k] == 1 && (num-k > k && num-k <=255)){
                       			return true;
                       		}		
                        }
                    }
            }
        }
        
        return false;
	}

	/* main()
	   Contains code to test the TripleSum225 function. Nothing in this function 
	   will be marked. You are free to change the provided code to test your 
	   implementation, but only the contents of the TripleSum225() function above 
	   will be considered during marking.
	*/
	public static void main(String[] args){
		Scanner s;
		if (args.length > 0){
			try{
				s = new Scanner(new File(args[0]));
			} catch(java.io.FileNotFoundException e){
				System.out.printf("Unable to open %s\n",args[0]);
				return;
			}
			System.out.printf("Reading input values from %s.\n",args[0]);
		}else{
			s = new Scanner(System.in);
			System.out.printf("Enter a list of non-negative integers. Enter a negative value to end the list.\n");
		}
		Vector<Integer> inputVector = new Vector<Integer>();
		
		int v;
		while(s.hasNextInt() && (v = s.nextInt()) >= 0)
			inputVector.add(v);
		
		int[] array = new int[inputVector.size()];
		
		for (int i = 0; i < array.length; i++)
			array[i] = inputVector.get(i);

		System.out.printf("Read %d values.\n",array.length);
		
		
		long startTime = System.currentTimeMillis();
		
		boolean tripleExists = TripleSum225(array);
		
		long endTime = System.currentTimeMillis();
		
		double totalTimeSeconds = (endTime-startTime)/1000.0;
		
		System.out.printf("Array %s a triple of values which sum to 225.\n",tripleExists? "contains":"does not contain");
		System.out.printf("Total Time (seconds): %.4f\n",totalTimeSeconds);
	}
}
