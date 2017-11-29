package Medium;

public class TrapContainer {
	public static void main(String[] args) {
		int[] input1 = {1 , 2};
		int[] input2 = {1, 2, 3, 3, 2, 1}; //should be 2*3 = 6
		System.out.println(maxArea(input1));
	}
	
	//Notice: this problem is similar to trapping water
	//However, it's simpler:
	// 1. No need first find the valid l and r //in trapping water, need to find the first edge s.t. heights[l]>=heights[l++] and etc
	// 2. No need to find the corresponding other edge (inner while loops)
	//      Because whenever we find an updated one, it is essentially the same as updating everything before it
	
	public int sampleMaxArea(int[] height) {
	    int left = 0, right = height.length - 1;
		int maxArea = 0;

		while (left < right) {
			maxArea = Math.max(maxArea, Math.min(height[left], height[right])
					* (right - left));
			if (height[left] < height[right])
				left++;
			else
				right--;
		}

		return maxArea;
	}
	
	public static int maxArea(int[] height) {
        //two pointers moving together
        //fix the lower one, and move the other one inwards
            //once find a valid one, finish this loop, and move the fixed one up
		
		
		//edge case
        if(height.length < 2){
            return 0;
        }
        
        int l = 0;
        int r = height.length-1;
        int water = 0; //water = (r-l)* height[lower_value]
        
        if(height.length == 2){
            return Math.min(height[l], height[r]);
        }
        
        while(l < r){
            int left = height[l];
            int right = height[r];
            if(left < right){ //==> fix l, move r inwards
                int k = r;
                while( l < k){
                    if(height[k] <= height[l]){ //find the first valid one
                        int s = (k-l)*left;
                        water = Math.max(water, s);
                        break;
                    }
                    k --;
                }
                l++;
            }else{ // left > right //==> fix r, move l inwards
                int k = l;
                while( k < r){
                    if(height[k] <= height[r]){ //find the first valid one
                        int s = (r-k)*right;
                        water = Math.max(water, s);
                        break;
                    }
                    k ++;
                }
                r--;
            }
        }
        
        return water;
    }
}
