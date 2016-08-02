package trivial;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		
		for(int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			boolean repeated = false;
			
			for(int j = 0; j < s.length(); j++) {
				if(j != i) {
					char c2 = s.charAt(j);
					System.out.println("c1: " + c1 + " c2: " + c2);
					if(c1 == c2) {
						repeated = true;
						break;
					}
				}
			}
			
			if(!repeated) {
				System.out.println(c1);
				break;
			}
		}
	}

}
