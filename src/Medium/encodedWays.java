package Medium;

/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 */

import java.util.*;

public class encodedWays {
    //TODO algorithm: get all the subsets, and then test if it is valid
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();

    public int numDecodings(String s) {
        map.put('A', 1);
        int ways = 0;
        return ways;
    }

    public void helper(int ways, char[] inputs, ArrayList<Integer> curr, int start){
        if(parse(curr) < 0 || parse(curr) > 26) return;

        if(curr.size() == inputs.length){
            ways++;
        }else{
            for(int i = start; i < inputs.length; i++){
                curr.add((int) inputs[i]);
                helper(ways, inputs, curr, i++);
                curr.remove(curr.size()-1);
            }

        }
    }

    public int parse(ArrayList<Integer> input){
        int rt = 0;
        for(int i = 0; i <= input.size()-1 ; i++){
            rt *= 10^i;
            rt += input.get(i);
        }
        return rt;
    }
}
