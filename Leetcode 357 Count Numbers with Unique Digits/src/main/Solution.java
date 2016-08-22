package main;

public class Solution {
    public static int countNumbersWithUniqueDigits(int n) {
        int[] arr = new int[n+1];
        arr[0] = 1;
        
        /**
         * Let i be the number of digits
         * When i = 1, there are 10 unique numbers, solved by 9 - i - 2
         * when i = 2, there are:
         * 10 from when i = 1,
         * 9 * 9 from when i = 2 (1-9 for first digit, 0-9 except the digit in first digit)
         * when i = 3, 
         * ans = 10 + 9*9 + 9*9*8
         */
        for(int i = 1; i <= n; i++) {
            arr[i] = 9; //since it goes by 9 * (9-i-2)...
            for(int x = 9; x >= 9 - i + 2;x--){ // dp[i] = dp[i] ....(9 * ...)
                arr[i] *= x;
            }
        }
        int ans = 0;
        for(int i= 0;i<arr.length;i++) {
        	ans += arr[i];
        }
        return ans;
    }
    
    public static void main(String[] args) {
    	countNumbersWithUniqueDigits(3);
    }
}