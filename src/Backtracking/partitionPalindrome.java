package Backtracking;

import java.util.ArrayList;
import java.util.List;
//Prob 131. Actual prob from an Uber Interview

public class partitionPalindrome {
//Solution 1:
	//Using backtracking to get every subsets
	//Check if it is a valid partition palindrome 
	 List<List<String>> resultLst;
	 ArrayList<String> currLst;
	 
	 public List<List<String>> partition(String s) {
		 resultLst = new ArrayList<List<String>>();
		 currLst = new ArrayList<String>();
		 backTrack(s,0);
		 return resultLst;
	 }
	    
	 public void backTrack(String s, int l){
		 if(currLst.size()>0 && l>=s.length()){ //the initial String is a palindrome (has finished, l>= s.length() )
			 List<String> r = (ArrayList<String>) currLst.clone(); //if not adding a clone, when empty currLst => reference changes
			 resultLst.add(r);
	     }
		 
		 for(int i=l;i<s.length();i++){
			 if(isPalindrome(s,l,i)){
				 if(l==i) {
					currLst.add(Character.toString(s.charAt(i)));
				 }else {
	        	 		currLst.add(s.substring(l,i+1));
	        	 		backTrack(s,i+1);
	        	 		currLst.remove(currLst.size()-1);
				 }
			 }
		 }
	 }
	 
	 public boolean isPalindrome(String str, int l, int r){
		 if(l==r) return true;
		 while(l<r){
			 if(str.charAt(l)!=str.charAt(r)) return false;
			 l++;r--;
		 }
		 return true;
	 }
}
