package main;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        
        for(int t_i = 0; t_i < t; t_i++) {
            String s1 = scn.nextLine();
            String s2 = scn.nextLine();
            s1.replaceAll("\\s+","");
            s2.replaceAll("\\s+","");
            
            Set<String> set1 = new HashSet<String>();
            Set<String> set2 = new HashSet<String>();
            
            for(int i = 0; i < s1.length(); i++) {
                String temp = s1.substring(i);
                set1.add(temp);
                //System.out.println(temp);
                for(int j = i + 1; j < s1.length(); j++) {
                    String temp1 = s1.substring(i,j);
                    //System.out.println(temp1);
                    set1.add(temp1);
                }
            }
            
            for(int m = 0; m < s2.length(); m++) {
                String temp = s2.substring(m);
                set2.add(temp);
                for(int n = m + 1; n < s2.length(); n++) {
                    String temp1 = s2.substring(m, n);
                    set2.add(temp1)    ;                
                }
            }
            
            //System.out.println("set 1 size: " + set1.size() + ", set 2 size: " + set2.size());
            
            
            set1.retainAll(set2);
            
            if(set1.size() > 0) {
                System.out.println("YES");
            }
            else
                System.out.println("NO");
        }
    }
}