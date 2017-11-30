package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 315
You are given an integer array nums and you have to return a new counts array. 
The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].

 */

public class CountSmallerNoAfterSelf {
	class Node {
        Node left, right;
        int val, sum, dup = 1;
        public Node(int v, int s) {
            val = v;
            sum = s;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }
    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null) {
            node = new Node(num, 0);
            ans[i] = preSum;
        } else if (node.val == num) {
            node.dup++;
            ans[i] = preSum + node.sum;
        } else if (node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else {
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }
	
    //No, need to keep track of the direction
    //Just a binary tree will mess up with the orders 
    /*
	 class Node {
	        Node left;
	        Node right;
	        int value;
	        
	        public Node(int i){
	            this.value = i;
	        }
	    }
	    
	    public List<Integer> countSmaller(int[] nums) {
	        //build tree
	        Node root = buildTree(nums);
	        
	        //int[] rt = new int[nums.length];
	        List<Integer> rt = new ArrayList<Integer>();
	        
	        //in-order travel
	        for(int i = 0; i < nums.length; i ++){
	            Node curr = findNode(root, nums[i]);
	            //check child each time (left kids)
	            int c = 0;
	            if(curr.left != null){
	                c = count(curr.left, c);
	            }     
	            //rt[i] = c;
	            rt.add(c);
	        }
	        return rt;    
	    }
	    
	    public Node buildTree(int[] nums){
	        Node root = new Node(nums[0]);
	        for(int i = 1; i < nums.length; i ++){
	            Node insert = new Node(nums[i]);
	            insertNode(insert, root);
	        }
	        
	        return root;
	    }
	    
	    public void insertNode(Node insert, Node root){
	        if(insert.value < root.value){
	            if(root.left == null){
	                root.left = insert; 
	                return;
	            }
	            insertNode(insert, root.left);
	        }else{
	            if(root.right == null){
	                root.right = insert;
	                return;
	            }
	            insertNode(insert, root.right);
	        }
	    }
	    
	    public Node findNode(Node root, int value){
	        if(value == root.value){
	            return root;
	        }else if(value < root.value){
	            return findNode(root.left, value);
	        }else{
	            return findNode(root.right, value);
	        }
	    }
	    
	    public int count(Node root, int c){
	    		if(root != null){
	            c++;
	            c += count(root.left, 0);
	            c += count(root.right, 0);
	        }
	        return c;
	    }
	*/    
}
