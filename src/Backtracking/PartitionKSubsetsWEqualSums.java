package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class PartitionKSubsetsWEqualSums {
    //Idea: using backtracking
    public boolean canPartitionKSubsets(int[] nums, int k) {
        //sorted the array
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        return partitionSubsetWithSum(nums, list, new ArrayList<Integer>(), k, nums[0], 0); //start with first num, set sum to nums[0]
    }

    public boolean partitionSubsetWithSum(int[] nums, List<List<Integer>> list, List<Integer> tempList, int k, int sum, int start){
        //Iterate through the array
        if(k==0){
            if(calSum(tempList) == sum) return true;
            else return false;
        }

        list.add(tempList);
        for(int i = start; i<nums.length; i++){
            //finding subset 1
            tempList.add(nums[i]);
            //calculate sum
            int curr_sum = calSum(tempList);
            //now (k-1) subset left
            //pass sum, k-1, available set nums to recursive function
            if(curr_sum == sum){
                return partitionSubsetWithSum(nums, list, tempList, k-1, curr_sum, start+1);
            }else{
                tempList.remove(nums[i]);
                return partitionSubsetWithSum(nums, list, tempList, k-1, curr_sum, start+1);
            }

                //if it holds, add this subset to our list + return true
                    //if it doesn't hold: remove this element
        }
        //if nothing works, return false
        list.remove(tempList);
        return false;
    }

    public int calSum(List<Integer> temp){
        return 0;
    }
}
