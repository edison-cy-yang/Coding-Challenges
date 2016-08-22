package main;

import java.util.*;

public class Solution {
	
	public static int majorityElement(int[] nums) {
        int size = nums.length;
        double majority = 0;
        int ans = nums[0];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }
            
            else {
                map.put(nums[i], map.get(nums[i]) + 1);
                if((double)map.get(nums[i])/(double)size > majority) {
                    majority = (double)map.get(nums[i])/(double)size;
                    ans = nums[i];
                }
            }
        }
        
        return ans;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {6,5,5};
		System.out.println(majorityElement(nums));
	}

}
