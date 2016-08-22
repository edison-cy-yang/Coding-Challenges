package main;

import java.util.*;

public class Solution {
	
	public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, NumFreq> map = new HashMap<>();
        //Find out the frequence for each element.
        for(int i=0; i<nums.length; i++){
            NumFreq nf = map.get(nums[i]);
            if(nf == null){
                map.put(nums[i], new NumFreq(nums[i], 1));
            }else{
                nf.freq += 1;
            }
        }
        List<NumFreq> list = new ArrayList<>(map.values());
        //Sort the elements by its frequence.
        Collections.sort(list);
        List<Integer> r = new ArrayList<>(k);
        for(int i=0; i<k; i++){
            r.add(list.get(i).num);
        }
        return r;
    }
    static class NumFreq implements Comparable<NumFreq>{
        int num;
        int freq;
        NumFreq(int n, int f){
            num = n;
            freq = f;
        }
        @Override
        public int compareTo(NumFreq another){
            //Sort by frequence.
            return another.freq - freq;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 1, 1, 2, 2, 3};
		int k = 2;
		List<Integer> list = topKFrequent(nums, k);
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

}
