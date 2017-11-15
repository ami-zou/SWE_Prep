package Hard;

public class TrapRainWater {
	public int trap(int[] A) {
	    if (A.length < 3) return 0;
	    
	    int ans = 0;
	    int l = 0, r = A.length - 1;
	    
	    // find the left and right edge which can hold water
	    while (l < r && A[l] <= A[l + 1]) l++;
	    while (l < r && A[r] <= A[r - 1]) r--;
	    
	    while (l < r) {
	        int left = A[l];
	        int right = A[r];
	        if (left <= right) {
	            // add volum until an edge larger than the left edge
	            while (l < r && left >= A[++l]) {
	                ans += left - A[l];
	            }
	        } else {
	            // add volum until an edge larger than the right volum
	            while (l < r && A[--r] <= right) {
	                ans += right - A[r];
	            }
	        }
	    }
	    return ans;
	}
	
	public int t(int[] height) {
        //Read from line, start with non-zero; initialization
        int total = 0;
        int curr = 0;
        int left = 1;
        boolean hasWater = false;
        
        for(int i = 0 ; i < height.length; i ++){
        //first mark: left
            int h = height[i];
            if(h >= left){ //either same left, or hit right
                if(hasWater){// >= left: right mark; end this session; add water to total; update left mark and start a new one
                    total += curr;
                    curr = 0;
                    hasWater = false;
                }
                left = h;
            }else{  //keep updating till get < left ::start counting water, ++diff
                curr += (left-h);
                hasWater = true;
            }
        // .. if that never happens (e.g.reach the end): doesn't add but end 
        }
        return total;
	}
	
}
