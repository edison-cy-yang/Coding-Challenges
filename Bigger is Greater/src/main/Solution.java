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
        //scn.nextLine();
        for(int t_i = 0; t_i < t; t_i++) {
            String str = scn.nextLine();
            char[] c = str.toCharArray();
            System.out.println(str);
        }
    }
}