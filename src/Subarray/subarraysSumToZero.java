package Subarray;
import java.util.*;

public class subarraysSumToZero {
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
	
	public static List<List<Integer>> subsets(int[] nums) { //
	    List<List<Integer>> list = new ArrayList<>();
	    //Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    //System.out.println("final subsets list: " + list);
	    //return list.size();
	    return list;
	}
	
	public static int subarrays(int[] nums) {
		//if(nums==null) return 0;
		List<List<Integer>> list = new ArrayList<>();
		
		helper(list, new ArrayList<>(), nums, 0);
		System.out.println("final returned list: " + list);
		return list.size();
	}
	
	public static void helper(List<List<Integer>> list, List<Integer> curr, int[] nums, int start) {
	//	if(isSumZero(curr)) {	
			list.add(new ArrayList<>(curr));
			//System.out.println(list);
	//	}else {
			for(int i = start; i < nums.length; i++) {
				curr.add(nums[i]);
				helper(list, curr, nums, start + 1);
				curr.remove(curr.size()-1);
			}
	//	}
	}
	
	private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
		if(isSumZero(new ArrayList<>(tempList))) {
		list.add(new ArrayList<>(tempList));
		}else {
	    for(int i = start; i < nums.length; i++){
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
		}
	}
	
	public static boolean isSumZero(ArrayList<Integer> curr) {
		if(curr.size()==0) return false;
		int sum = 0;
		for(int i : curr) {
			sum+= i;
		}
		return sum == 0;	
	}
	
	public static void main(String[] args) {
		int[] input = new int[] {-1, 1, -1, 1};
		int[] input2 = new int[] {-1 ,-1, 1, 1};
		System.out.println("first test: " + subarrays(input));
		
		System.out.println("all subsets: " + subsets(input2));
		System.out.println("all subsets size: " + subsets(input2).size() );
	}
	
}
