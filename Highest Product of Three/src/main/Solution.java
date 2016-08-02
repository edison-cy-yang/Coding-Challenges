package main;

public class Solution {
	
	public static int highestProductOfThree(int[] arr) {
		//int maxProduct = 1;
		 
		if(arr.length < 3)
			throw new IllegalArgumentException("Need at least 3 numbers in the array!");
		
		int highestProductOfThree = arr[0] * arr[1] * arr[2];
		int highestProductOfTwo = 1;
		int lowestProductOfTwo = 1;
//		if(arr[0] * arr[1] > arr[1] * arr[2]) {
//			highestProductOfTwo = arr[0] * arr[1];
//			lowestProductOfTwo = arr[1] * arr[2];
//		}
//		else {
//			highestProductOfTwo = arr[1] * arr[2];
//		}
		
		highestProductOfTwo = arr[0] * arr[1];
		lowestProductOfTwo = arr[0] * arr[1];
		
		int highest = Math.max(arr[0], arr[1]);
		int lowest = Math.min(arr[0], arr[1]);
		
		/*
		 * Keep track of:
		 * highestProductOfThree
		 * highestProductOfTwo
		 * highest
		 * lowestProductOfTwo
		 * lowest
		 */
		
		
		
		for(int i = 2; i < arr.length; i++) {
			
			highestProductOfThree = Math.max(Math.max(highestProductOfTwo * arr[i], lowestProductOfTwo * arr[i]), highestProductOfThree);
			
			highestProductOfTwo = Math.max(Math.max(highest * arr[i], lowest * arr[i]), highestProductOfTwo);
			lowestProductOfTwo = Math.min(Math.min(highest * arr[i], lowest * arr[i]), lowestProductOfTwo);
			highest = Math.max(highest, arr[i]);
			lowest = Math.min(lowest, arr[i]);
			
				 							
		}
		
		return highestProductOfThree;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{1, 4, 2, 3, 5};
		
		int product = Solution.highestProductOfThree(array);
		System.out.println(product);

	}

}
