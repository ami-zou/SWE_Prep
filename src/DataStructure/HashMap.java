package DataStructure;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/internal-working-of-hashmap-java/
	
public class HashMap {
//capacity = number of buckets * load factor
//index = hashCode(key) & (n-1)
	int buckets = 16;
	double loadFactor = 0.8;
	int capacity = (int) ((int) buckets * loadFactor);
	ArrayList<Node> map;
	
	HashMap(){
		map = new ArrayList<Node>(); 
	}
	
	public Value get(Key key) {
		int index = key.hashCode();
		Node node = map.get(index);
		
		while(node != null) {		
			if(node.key.equals(key)) {
				return node.value;
			}
			
			node = node.next;
		}
		
		return null;
	}
	
	public void put(Key key, Value value) {
		int index = key.hashCode();
		Node node = new Node(index, key, value, null);
		Node current = map.get(index);
		
		if(current == null) {
			map.add(index, node);
		}
		
		while(current != null) {
			current = current.next;
			
			if(current == null) {
				map.add(index, node);
				break;
			}
		}
	}
	
}

class Node {
	int hash;
	Key key;
	Value value;
	Node next;
	
	Node() {
		this(0, null, null, null);
	}
	
	Node(int hash, Key key, Value value, Node next){
		this.hash = hash;
		this.key = key;
		this.value = value;
		this.next = next;
	}
	
	Node(int hash, Key key, Value value){
		this(hash, key, value, null);
	}
}

class Value{
	
}

//custom Key class to override hashCode()
//and equals() method
class Key {
	String key;

	Key(String key){
		this.key = key;
	}

	@Override
	public int hashCode() {
		return (int)key.charAt(0);
	}

	@Override
	public boolean equals(Object obj){
		return key.equals((String)obj);
	}
}