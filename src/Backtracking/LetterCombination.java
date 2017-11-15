package Backtracking;

import java.util.*;

public class LetterCombination {
	public static String[] alphabet;

	public static List<String> letterCombinations(String digits) {
		// initialize alphabet
		alphabet = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		if(digits.length() ==0 ) return new ArrayList<String>();
		List<String> list = new ArrayList<String>();
		helper(digits, 0 , digits.length(), new StringBuilder(), list);
		return list;
	}

	public static void helper(String digits, int i, int n, StringBuilder curr, List<String> list) {
		if (curr.length() == n) {
			list.add(curr.toString());
		} else {
			int id = ((int) digits.charAt(i));
			int d = Integer.valueOf(id)-48;
			char[] alp = alphabet[d].toCharArray();
			for (char s : alp) {
				curr.append(s);
				helper(digits, i + 1, n, curr, list);
				curr.deleteCharAt(curr.length() - 1);
			}
		}
	}

	public static void main(String[] args) {

		System.out.println("input 123: " + letterCombinations("123"));
	}

}
