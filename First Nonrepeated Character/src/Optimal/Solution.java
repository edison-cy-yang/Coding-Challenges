package Optimal;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		
		for(int i = 0; i < s.length(); i++) { 
			char c = s.charAt(i);
			
			if(!map.containsKey(c)) {
				map.put(c, 1);
			}
			
			else {
				map.put(c, map.get(c) + 1);
			}
		}
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(map.get(c) == 1) {
				System.out.println(c);
				break;
			}
		}
	}

}
