package Medium;

public class removeDuplicates {
	public static int rmDuplicates(int[] nums) {
		int val = nums[0];
        for(int i = 0; i < nums.length; i++){
            val ^= nums[i];
            System.out.println(val);
        }
        return val;
	}
	
	public static void main(String[] args) {
		int[]nums = new int[] {1,2,3,4,3};
		System.out.println(rmDuplicates(nums));
	}
}
