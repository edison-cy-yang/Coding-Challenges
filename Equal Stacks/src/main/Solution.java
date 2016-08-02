package main;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	public static boolean equalHeight(int[] arr) {
		int h0 = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != h0) {
				return false;
			}
		}
		
		return true;
	}
	
	
	/*
	 * Find the index of the highest stack
	 */
	public static int highest(int[] arr) {
		int highest = arr[0];
		int highest_i = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > highest) {
				highest = arr[i];
				highest_i = i;
			}
		}
		
		return highest_i;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        
        int[] height = new int[3]; //Used to store the height of each stack
        
        int h1[] = new int[n1];
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
            height[0] += h1[h1_i];
        }
        int h2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
            height[1] += h2[h2_i];
        }
        int h3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
            height[2] += h3[h3_i];
        }
        
        //System.out.println("h1: " + height[0] + " h2: " + height[1] + " h3: " + height[2]);
        
        int h1_i = 0, h2_i = 0, h3_i = 0;
        
        boolean found = false;
        
        while(!found) {
        	if(equalHeight(height)) {
        		found = true;
        		break;
        	}
        	
        	else {
        		int i = highest(height); //the highest stack
        		if(i == 0) {
        			height[0] = height[0] - h1[h1_i]; 
        			h1_i++;
        		}
        		else if(i == 1) {
        			height[1] = height[1] - h2[h2_i]; 
        			h2_i++;
        		}
        		else if(i == 2) {
        			height[2] = height[2] - h3[h3_i]; 
        			h3_i++;
        		}
        	}
        }
        
        System.out.println(height[0]);
        
        
    }
}
