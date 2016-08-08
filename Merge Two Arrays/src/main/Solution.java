package main;

import java.util.*;

public class Solution {
	
	public static int[] mergeArrays(int[] a, int[] b) {
		int indexA = 0;
		int indexB = 0;
		int[] merged = new int[a.length + b.length];
		int mergedIndex = 0;
		
		while(indexA < a.length && indexB < b.length) {
			if(a[indexA] <= b[indexB]) {
				merged[mergedIndex] = a[indexA];
				indexA++;
			}
			else {
				merged[mergedIndex] = b[indexB];
				indexB++;
			}
			mergedIndex++;
		}
		
		while(indexA < a.length){
			merged[mergedIndex] = a[indexA];
			indexA++;
			mergedIndex++;
		}
		
		while(indexB < b.length){
			merged[mergedIndex] = b[indexB];
			indexB++;
			mergedIndex++;
		}
		
		return merged;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,3,4,6,9,11};
		int[] b = {2,3,5,8,9,10,14};
		int[] merged = mergeArrays(a, b);
		
		for(int i = 0; i < merged.length; i++) {
			System.out.print(merged[i] + " ");
		}
	}

}
