package Hard;

public class FirstMissingPosInt {
	 public static int firstMissingPositive(int[] nums) {
	        //find the range
	        int small = 100000000; int large = 1;
	        for(int i = 0; i < nums.length; i ++){
	            int num = nums[i];
	            large = Math.max(large, num);
	            if(0 <= num){ //now from 0
	                small = Math.min(num, small);
	            }
	        }
	        System.out.println("small: " + small + " large: " + large);
	        //sort
	        for(int i = 0 ; i < nums.length; i ++){
	            int num = nums[i];
	            if(num >= small){ //swap in order
	                int temp = nums[num-small];
	                nums[num-small] = num;
	                nums[i] = temp;
	            }
	            System.out.println("sorted: " + nums[i]);
	        }
	        	        //find the unmatched one
	        int rt = large+1;
	        for(int i = 0 ; i < large-small+1; i ++){
	            if(nums[i] != i+small){
	                rt = i+small;
	                break;
	            }
	        } 
	        
	        return rt;
	    }
	 
	 public static void main(String[] args) {
		 int[] input1 = new int[] {1,2,0};
		 int[] input2 = new int[] {3, 4, -1, 1};
		 System.out.println(firstMissingPositive(input2));
	 }
}
