package Prep;

import java.util.ArrayList;
import java.util.List;

//Try to solve it in O(N) runtime and O(1) space
//Notice: range is 0 to N-1

public class findDuplicates {
	public void xorMethod(int[] arr, int size){
		 /* Will hold xor of all elements */
        int xor = arr[0];
         
        /* Will have only single set bit of xor */
        int set_bit_no;
         
        int i;
        int n = size - 2;
        int x = 0, y = 0;
 
        /* Get the xor of all elements in arr[] and {1, 2 .. n} */
        for (i = 1; i < size; i++)
            xor ^= arr[i];
        for (i = 1; i <= n; i++)
            xor ^= i;
 
        /* Get the rightmost set bit in set_bit_no */
        set_bit_no = (xor & ~(xor - 1));
 
        /* Now divide elements in two sets by comparing rightmost set
           bit of xor with bit at same position in each element. */
        for (i = 0; i < size; i++) {
            int a = arr[i] & set_bit_no;
            if (a != 0)
                x = x ^ arr[i]; /*XOR of first set in arr[] */
            else
                y = y ^ arr[i]; /*XOR of second set in arr[] */
        }
        
        for (i = 1; i <= n; i++) {
            int a = i & set_bit_no;
            if (a != 0)
                x = x ^ i; /*XOR of first set in arr[] and {1, 2, ...n }*/
            else
                y = y ^ i; /*XOR of second set in arr[] and {1, 2, ...n } */
        }
 
        System.out.println("The two reppeated elements are :");
        System.out.println(x + " " + y);
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
