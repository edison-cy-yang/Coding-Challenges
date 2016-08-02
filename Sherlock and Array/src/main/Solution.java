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
        //System.out.println("t: " + t);
        for(int t_i = 0; t_i < t; t_i++) {
        	//System.out.println("t_i: " + t_i);
            int n = scn.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            boolean found = false;
            for(int i = 0; i < n; i ++) {
                arr[i] = scn.nextInt();
                sum += arr[i];
            }
            
            int[] leftSum = new int[n];
            int[] rightSum = new int[n];
            
            
            for(int j = 0; j < n; j++) {
                if(j == 0) {
                    leftSum[j] = 0;
                    rightSum[j] = sum - arr[j];
                    sum -= arr[j];
                }
                else {
                    leftSum[j] = leftSum[j-1] + arr[j-1];
                    rightSum[j] = sum - arr[j];
                    sum = sum - arr[j];
                }
            }
            
            for(int k = 0; k < n; k++) {
                //System.out.println("leftSum[k]: " + leftSum[k] + " rightSum[k]: " + rightSum[k]);
                if(rightSum[k] == leftSum[k]) {
                    //System.out.println("YES");
                    found = true;
                    //break;
                }
            }
            if(!found)
            	System.out.println("NO");
            else
            	System.out.println("YES");
        }
       
    }
}