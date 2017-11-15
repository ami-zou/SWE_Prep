package Medium;

public class jumpGame {
	//Solution 1: back up
	public boolean canJump1(int[] nums) {
        int last = nums.length-1;
        //return helper(0, nums, last, 0);
        for(int i = last - 1; i>=0; i--){
            if( i + nums[i] >= last) last = i;
        }
        return last <=0;
    }

    //Solution 2: build by steps 
    public boolean canJump2(int[] nums) {
    int reachable = 0;
    for (int i=0; i<nums.length; ++i) {
        if (i > reachable) return false;
        reachable = Math.max(reachable, i + nums[i]);
    }
    return true;
    }
    
    public boolean helper(int index, int[] nums, int goal, int step){
        if(index == goal) return true;
        if(index > goal) return false;
        
        int max = nums[index];
        //index < goal
        while(step <= max){
            if( helper(index+step, nums, goal, step) ){
                index += step;
                return true;
            }
            step++;   
        }
        
        return false;
    }
   
}
