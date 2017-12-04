package Tree;

public class CommonAncestor {
	//Algorithm: the common ancestor has value between the two nodes 
	
	//Q1: Binary Search Tree, no duplicates
	public Node getCommonAncestor1(Node root, Node n1, Node n2) {
		if (root == null) {
			return null;
		}

		int largerValue = n1.value > n2.value ? n1.value : n2.value;
		int smallerValue = n1.value < n2.value ? n1.value : n2.value;

		if (root.value >= smallerValue && root.value <= largerValue) {
			return root;
		}else if (root.value > largerValue) {
			return getCommonAncestor1(root.left, n1, n2);
		}else if (root.value < smallerValue) {
			return getCommonAncestor1(root.right, n1, n2);
		}
		
		return null;
	}
	
	//Q2: Binary Search Tree, with duplicates and goes to left
	Node getCommonAncestor2(Node root, Node n1, Node n2) {
		if (root == null) {
			return null;
		}

		int largerValue = n1.value > n2.value ? n1.value : n2.value;
		int smallerValue = n1.value < n2.value ? n1.value : n2.value;

		if (root.value >= smallerValue && root.value <= largerValue) {
			if (root.left.value == root.value) {
				return getCommonAncestor2(root.left, n1, n2);
			} else {
				return root;
			}
		}

		if (root.value > largerValue) {
			return getCommonAncestor2(root.left, n1, n2);
		}

		if (root.value < smallerValue) {
			return getCommonAncestor2(root.right, n1, n2);
		}
		
		return null;
	}	
	
	
}
