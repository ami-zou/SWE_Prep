package Medium;

import java.util.HashMap;
import java.util.Stack;

public class balancedBrackets {
	public static boolean solution1(String braces) {
		Stack<Character> stack = new Stack<Character>();
		
		for(char c : braces.toCharArray()) {
	        if(c == '(' || c == '[' || c == '{') {
	            stack.push(c);
	        } else if((c == ')' && (stack.isEmpty() || stack.pop() != '(')) ||
	                  (c == ']' && (stack.isEmpty() || stack.pop() != '[')) ||
	                  (c == '}' && (stack.isEmpty() || stack.pop() != '{'))) {
	            return false;
	        }
	    }

	    return stack.isEmpty();		
	}
	
	public static boolean solution2(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
	 
		Stack<Character> stack = new Stack<Character>();
	 
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
	 
			if (map.keySet().contains(curr)) {
				stack.push(curr);
			} else if (map.values().contains(curr)) {
				if (!stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
	 
		return stack.empty();
	}
}
