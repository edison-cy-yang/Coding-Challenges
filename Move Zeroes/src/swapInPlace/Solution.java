package swapInPlace;

public class Solution {
	
	public static void moveZeroes(int[] nums) {
		int i = 0;
		int countZeros = 0;
        while(i < nums.length - countZeros) {
            if(nums[i] == 0) {
            	countZeros++;
                int j = i;
                while(j < nums.length - 1) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    j++;
                }
            }
            else {
            	i++;
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,0,1};
		moveZeroes(nums);
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

}
