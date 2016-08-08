package main;

import java.util.*;

public class Solution {

	static String[] braces(String[] values) {
        // Key value pairs of (){}[]
        
        String[] ans = new String[values.length];
        
        
        
        for(int i = 0; i < values.length; i++) {
            Stack<Character> stack = new Stack<Character>(); // stack to store the call stack of brackets
            for(int j = 0; j < values[i].length(); j++) {
                char curr = values[i].charAt(j);
                
                if(curr == '{' || curr == '(' || curr == '[') {
				    stack.push(curr);
			    }
			    else if(curr == '}' || curr == ')' || curr == ']') {
                    if(stack.empty()) {
                        values[i] = "NO";
                        break;
                    }
					
				    char last = stack.peek();
				    if((curr =='}' && last == '{') || (curr == ')' && last == '(') || (curr == ']' && last == '[')) {
					   stack.pop();	
				    }
				    else {
					   values[i] = "NO";
                        break;
                    }
				
			     }
            }
            
            if(stack.empty()) {
                ans[i] = "YES";
            }
            else {
                ans[i] = "NO";
            }
            
        }
        
        return ans;

    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = {"{}[]()", "[]{})"};
		String[] ans = braces(str);
		for(int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}

	}

}
