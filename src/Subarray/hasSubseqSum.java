package Subarray;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class hasSubseqSum {
	static boolean containSum(int[] array, int n) {
		if (array == null)
			return false;
		else {
			HashSet<Integer> hs = new HashSet<>();
			int total = 0;
			
			for (int i = 0; i < array.length; i++) {
				total += array[i];
				if (total == n)
					return true;
				if (hs.contains(total - n)) {
					return true;
				} else {
					hs.add(total);
				}
			}
			return false;
		}
	}
	
	public int countSubArraysSumZero(int[] nums) { //Correct answer for sum to 0!
	      Map<Integer, Integer> count = new HashMap<Integer, Integer>();
	      count.put(0, 1);

	      int sum = 0, res = 0;
	      for(int i : nums) {
	          sum += i;
	          if(count.containsKey(sum)) {
	              res += count.get(sum);
	              count.put(sum, count.get(sum)+1);
	          }else{
	              count.put(sum, 1);
	          }
	      }

	      return res;
	  }
}
