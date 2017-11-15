package Tree;

class Node {
	int key, value;
	Node left, right;

	public Node(int item) {
		key = item;
		value = item;
		left = right = null;
	}
}
