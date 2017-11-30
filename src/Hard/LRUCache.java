package Hard;

import java.util.HashMap;
import java.util.Stack;

public class LRUCache {
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
}
