package main;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner stdin=new Scanner(System.in);
        int n=stdin.nextInt();
        int k=stdin.nextInt();
        
        //System.out.println("k is " + k + ", n is " + n);
        
        int[] prices = new int[n];
        
        for(int i=0;i<n;i++) {
            prices[i]=stdin.nextInt();
            //System.out.print(prices[i] + " ");
        }
        
        for(int m = 0; m < prices.length; m++) {
        	System.out.print(prices[m] + " ");
        }
        
        int answer = 0;
        // Compute the final answer from n,k,prices 
        //int[] sorted = new int[n];
        Arrays.sort(prices);
        
        int count = 0;
        for(int j = 0; j < prices.length; j++) {
            if(k - prices[j] > 0) {
                k = k - prices[j];
                count++;
            }
            else {
                break;
            }
        }
        
        //System.out.println(count);
    }
}
