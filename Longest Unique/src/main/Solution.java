package main;
import java.util.*;

public class Solution {
	
	public static int longestUnique(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int i = 0, count = 0, maxCount = 0;
		
		while(i < str.length()) {
			char c = str.charAt(i);
			if(!map.containsKey(c)) {
				map.put(c, i);
				count++;
				i++;
			}
			else {
				maxCount = Math.max(maxCount, count);
				
				count = 0;
				i = map.get(c) + 1;
				map.clear();
			}
		}
		return maxCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ccabcdefgggg";
		System.out.println(longestUnique(str));

	}

}
