package main;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();
        StringBuilder str = new StringBuilder(s);
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= 65 && c <=90) {
                c = (char) (c + k);
                if(c <= 90)
                    str.setCharAt(i, c);
                else if(c > 90) {
                    if((c-90) % 26 == 0)
                    	c = (char) (64 + 26);
                    else {
                    	c = (char) (64 + ((c-90) % 26)); 
                    }
                    str.setCharAt(i, c);
                }
            }
            else if(c >= 97 && c <= 122) {
                c = (char) (c+k);
                if(c <=122)
                    str.setCharAt(i, c);
                else if(c > 122){
                	//System.out.println((int) c);
                	if((c-122) % 26 == 0)
                		c = (char) (96 + 26);
                	else {
                		c = (char) (96 + ((c-122) % 26));
                	}
                    //System.out.println(c);
                    str.setCharAt(i, c);
                }
            }
                        
        }
        
        System.out.println(str.toString());

	}

}
