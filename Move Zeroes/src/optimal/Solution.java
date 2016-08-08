package optimal;

public class Solution {
	
	public static void moveZeroes(int[] nums) {
	    int i = 0;
	    int j = 0;
	    
	    while(j < nums.length){
	    	if(nums[j] == 0) {
	    		j++;
	    	}
	    	else {
	    		nums[i] = nums[j];
	    		i++;
	    		j++;
	    	}
	    }
	    
	    while(i < nums.length){
	    	nums[i] = 0;
	    	i++;
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
