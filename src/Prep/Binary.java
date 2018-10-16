package Prep;

import java.util.ArrayList;
import java.util.Scanner;

public class Binary {
	public static void main(String args[] ) throws Exception {
		Scanner s = new Scanner(System.in);
        int pairs = s.nextInt(); 
        ArrayList<Integer> answers = new ArrayList<Integer>();
        
        for(int i = 0; i < pairs; i ++) {
        		int a = s.nextInt();
        		int b = s.nextInt();
        		getDifference(a, b, answers);
        }
        
        for(int a : answers) {
        		System.out.println(a);
        }
	}
	
	private static void getDifference(int a, int b, ArrayList<Integer> answers) {
		Integer rt = 0;
		
		if(a-b == 0) { //Case: a equals b ==> no differenec (return 0)
			answers.add(rt);
			return;
		}
		
		//Convert Decimal to Binary	
		ArrayList<Integer> containerA = new ArrayList<Integer>();
		ArrayList<Integer> containerB = new ArrayList<Integer>();

		int c = 0;
		
	    while (a > 0 || b > 0){
	    		if(a > 0) {
	    			containerA.add(a%2);
	    			a = a/2;
	    		}else {
	    			containerA.add(0);
	    		}
	    		
	    		if(b > 0) {
	    			containerB.add(b%2);
	    			b = b/2;
	    		}else {
	    			containerB.add(0);
	    		}
	    		
	    		c++;
	    }
	    
	    
	    //Method 1: Compare and count directly
	    for(int k = 0; k < c; k ++) {
	    		int aK = containerA.get(k);
	    		int bK = containerB.get(k);
	    
	    		if(aK != bK) {
	    			rt ++;
	    		}
	    }
		
		//Method 2: XOR + Count 
		
		
		answers.add(rt);
	}
}
