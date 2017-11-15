package Backtracking;
import java.util.*;

public class getFactors {
    public List<List<Integer>> getFactors(int n) {
        //back tracking and check if it is the correct answer
    		List list = new ArrayList();
    		factorization(n, new ArrayList<Integer>(), list);
    		return list;
    }
    
    public void factorization(int n, List<Integer> temp, List list) {
    		if( isProductRight(temp) == n ) {
    			list.add(temp);
    		}else {
    			for(int i = 1; i < n ; i ++) {
    				temp.add(i);
    				if(isProductRight(temp) < n) {
    					list.add(temp);
    					factorization(n, temp, list);
    				}else {
    					temp.remove(i);
    				}
        			
        		}	
    		}
    		
    }
    
    public int isProductRight(List<Integer> temp) {
    		int product = 1;
    		for(int i = 0; i < temp.size(); i++) {
    			product = product * temp.get(i);
    		}
    		return product;
    }
}
