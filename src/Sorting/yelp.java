package Sorting;

import java.util.*;

//Calculate the median of a given input
public class yelp {
	 public static double calculateMedianRating(List<BusinessInfo> businessInfoList) {
	      int n = businessInfoList.size();
	      double median = 0.0;
	      
	      //edge case: one number
	      if(n==1){
	          return businessInfoList.get(0).rating;
	      }
	      
	      List<Double> ratings = new ArrayList<Double>();
	      for(BusinessInfo b : businessInfoList) {
	    	      ratings.add(b.rating);
	      }
	      
	      Collections.sort(ratings);
	      
	      if(n%2 == 0){ //even number, get the middle two, and calculate mode
	          int n1 = n/2;
	          int n2 = n1+1;
	          median = (ratings.get(n1) + ratings.get(n2) )/2;
	          
	      }else{ //odd number the the middle
	          int i = (n+1)/2;
	          median = ratings.get(i-1);
	      }
	      
	      return median;
     }
	 
	 public class BusinessInfo implements Comparable<BusinessInfo> {
		  int id;
		  double rating;

		  public BusinessInfo(int id, double rating) {
		    this.id = id;
		    this.rating = rating;
		  }

		  public int compareTo(BusinessInfo b1) {
		      if (this.rating < b1.rating) {
		          return -1;
		      }
		      if (this.rating > b1.rating) {
		          return 1;
		      }
		      return 0;
		  }
		}
}

