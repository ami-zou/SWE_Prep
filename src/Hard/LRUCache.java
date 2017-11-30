package Hard;

import java.util.HashMap;
import java.util.Stack;

public class LRUCache {
	class Node {
		int key;
		int value;
		Node pre;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	HashMap<Integer, Node> map;
	int capicity, count;
	Node head, tail;
	
	public LRUCache(int capacity) {
		this.capicity = capacity;
		map = new HashMap<>();
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.pre = head;
		head.pre = null;
		tail.next = null;
		count = 0;
	}

	public void deleteNode(Node node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}

	public void addToHead(Node node) {
		node.next = head.next;
		node.next.pre = node;
		node.pre = head;
		head.next = node;
	}

	public int get(int key) {
		if (map.get(key) != null) {
			Node node = map.get(key);
			int result = node.value;
			deleteNode(node);
			addToHead(node);
			return result;
		}
		return -1;
	}

	public void set(int key, int value) {
		if (map.get(key) != null) {
			Node node = map.get(key);
			node.value = value;
			deleteNode(node);
			addToHead(node);
		} else {
			Node node = new Node(key, value);
			map.put(key, node);
			if (count < capicity) {
				count++;
				addToHead(node);
			} else {
				map.remove(tail.pre.key);
				deleteNode(tail.pre);
				addToHead(node);
			}
		}
	}	
/* However, since we are accessing by the most recent node, Stack doesn't work	
	public HashMap<Integer, Integer> table;
    public int capacity;
    public Stack<Integer> s;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        s = new Stack<Integer>();
        table = new HashMap<Integer, Integer>();
        //has a hashMap for storing values
        //has a set of key set <-- 
        
    }
    
    public int get(int key) {
        if( !table.containsKey(key) ){
            return -1;
        }else{
            return table.get(key);   
        } 
    }
    
    public void put(int key, int value) {
        if(table.size() == capacity ){
            int k = s.pop();
            table.remove(k);
        }
        table.put(key, value);
        s.push(key);
    }
*/    
}
