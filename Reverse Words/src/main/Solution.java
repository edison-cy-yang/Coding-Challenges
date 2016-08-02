package main;

public class Solution {
	
	public static String reverseWords(String str) {
		String[] words = str.split(" ");
		int length = words.length;
		StringBuilder newString = new StringBuilder();
		
		for(int i = length - 1; i >= 0; i--) {
			newString.append(words[i]).append(" ");
		}
		
		return newString.toString();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "piglet quantum";
		System.out.println(reverseWords(str));
	}

}
