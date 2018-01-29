package Tree;
import java.util.*;

public class FindLeaves {
	public List<List<Integer>> findLeaves(Node root) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    helper(result, root);
	    return result;
	}
	 
	// traverse the tree bottom-up recursively
	private int helper(List<List<Integer>> list, Node root){
	    if(root==null) //If root == null, set it to -1, then line 18 will set all leaves with level 0;
	        return -1;
	 
	    int left = helper(list, root.left); //recursively counting current node's level
	    int right = helper(list, root.right);
	    int curr = Math.max(left, right)+1;
	 
	    // the first time this code is reached is when curr==0,
	    //since the tree is bottom-up processed.
	    if(list.size()<=curr){
	        list.add(new ArrayList<Integer>());
	    }
	 
	    list.get(curr).add(root.value);
	 
	    return curr;
	}
}
