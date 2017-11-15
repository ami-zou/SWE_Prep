package Medium;

public class SearchForARange_34 {
    public int[] searchRange(int[] nums, int target) {
        return searchRangeAux(0, nums.length-1, nums, target);
    }

    public int[] searchRangeAux(int start, int end, int[] nums, int target){
        int[] range = {-1, -1};
        int middle_index = (int)Math.floor((end+start)/2); //the distance is (end-start+1)
        int middle = nums[middle_index];

        if(end-start<=1 || start<0 || start>nums.length-1){
            range[0] = start;
            range[1] = end;
            return range;
        }

        if(middle > target){ //go to left side
            range = searchRangeAux(start, middle_index-1, nums, target);
        }else if(middle < target){ //go to right side
            range = searchRangeAux(middle_index+1, end, nums, target);
           // range = searchRangeAux(middle_index+1, q, nums, target);
        }else{//go to left side to find start, end right side to find end
            range[0] = middle_index;
            range[0] = middle_index;

            int[] rangeL = searchRangeAux(start, middle_index-1, nums, target);
            int[] rangeR = searchRangeAux(middle_index+1, end, nums, target);
            //could be null
            if(rangeL[0]!=-1)range[0] = rangeL[0];
            if(rangeR[1]!=-1)range[1] = rangeR[1];
        }

        return range;
    }

    public static void main(String[] args){
        SearchForARange_34 search = new SearchForARange_34();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] range = search.searchRange(nums, target);
        System.out.println("Range for "+target+" is ["+range[0]+","+range[1]+"]");
    }
}
