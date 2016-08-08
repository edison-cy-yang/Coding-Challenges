package main;

import java.util.*;

public class Solution {

	public static int countPalindromes(String str) {
		Set<String> set = new HashSet<String>();
		
		for(int j = 0; j <= 1; j++) {
			for(int i = 0; i < str.length() - j; i++) {
				String c = str.substring(i, i+1+j);
				if(j == 0) {
					if(!set.contains(c))
						set.add(c);
					int forward = i + 1;
					int backward = i - 1;
					while(forward < str.length() && backward >= 0) {
						if(str.charAt(forward) == str.charAt(backward)) {
							String temp = str.substring(backward, forward+1);
							if(!set.contains(temp)) {
								set.add(temp);
								forward++;
								backward--;
							}
						}
						else {
							break;
						}
					}
				}
				else {
					if(c.charAt(0) == c.charAt(1)) {
						if(!set.contains(c))
							set.add(c);
						int forward = i + j + 1;
						int backward = i - 1;
						while(forward < str.length() && backward >= 0) {
							if(str.charAt(forward) == str.charAt(backward)) {
								String temp = str.substring(backward, forward+1);
								if(!set.contains(temp)) {
									set.add(temp);
									forward++;
									backward--;
								}
							}
							else {
								break;
							}
						}
					}
				}
			}
		}
		
		Iterator<String> i = set.iterator();
		
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		return set.size();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abaaa";
		
		System.out.println(countPalindromes(str));
	}

}
