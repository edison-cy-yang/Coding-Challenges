package evenMoreOptimal;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		HashMap<Character, Object> map = new HashMap<Character, Object>();
		Object seen;
		Object seenOnce = new Object();
		Object seenMultiple = new Object();
		
		
		for(int i = 0; i < s.length(); i++) { 
			char c = s.charAt(i);
			
			if(!map.containsKey(c)) {
				map.put(c, seenOnce);
			}
			
			else {
				map.put(c, seenMultiple);
			}
		}
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(map.get(c) == seenOnce) {
				System.out.println(c);
				break;
			}
		}
	}

}
