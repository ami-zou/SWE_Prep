package Prep;

import java.util.ArrayList;
import java.util.List;

//Try to solve it in O(N) runtime and O(1) space
//Notice: range is 0 to N-1

public class findDuplicates {
	public int xorMethod(int[] arr){
		return 0;
	}
	
	public List<Integer> restoreBasedOnMod(int[] arr, int n) { // n is != arr.length; one is size, but the other is range
		// First check all the values that are
	    // present in an array then go to that
	    // values as indexes and increment by
	    // the size of array
		List<Integer> rt = new ArrayList<Integer>();
	    for (int i = 0; i < n; i++)
	    {
	        int index = arr[i] % n;
	        arr[index] += n;
	    }
	 
	    // Now check which value exists more
	    // than once by dividing with the size
	    // of array
	    for (int i = 0; i < n; i++)
	    {
	        if ((arr[i]/n) > 1)
	            rt.add(i);
	    }	
	    
	    return rt;
	}
	
	public void mathEquationForTwoDuplicates(int[] arr, int size) {
/*
Let summation of all numbers in array be S and product be P:

X + Y = S – n(n+1)/2
XY = P/n!		

Then we can use Math.sqrt and other functions to calculate X and Y
 */
		/* S is for sum of elements in arr[] */
        int S = 0;
         
        /* P is for product of elements in arr[] */
        int P = 1;
         
        /* x and y are two repeating elements */
        int x, y;
         
        /* D is for difference of x and y, i.e., x-y*/
        int D;
         
        int n = size - 2, i;
 
        /* Calculate Sum and Product of all elements in arr[] */
        for (i = 0; i < size; i++) 
        {
            S = S + arr[i];
            P = P * arr[i];
        }
 
        /* S is x + y now */
        S = S - n * (n + 1) / 2;
         
        /* P is x*y now */
        P = P / factorial(n); //TODO optimize it using DP
        
        /* D is x - y now */
        D = (int) Math.sqrt(S * S - 4 * P);
         
 
        x = (D + S) / 2;
        y = (S - D) / 2;
 
        System.out.println("The two repeating elements are :");
        System.out.print(x + " " + y);		
	}
	
	int factorial(int n) {
        return (n == 0) ? 1 : n * factorial(n - 1);
    }
}
