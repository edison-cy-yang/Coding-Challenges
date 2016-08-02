package main;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void reduce(StringBuilder str) { 
        int i = 0;
        while(i < str.length() -1) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i+1);
            if(c1 == c2) {
                str.delete(i,i+2);
                reduce(str);
                return;
            }
            i++;
        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        StringBuilder sB = new StringBuilder(str);
        Solution.reduce(sB);
    }
}
