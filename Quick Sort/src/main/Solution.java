package main;

import java.util.*;
public class Solution {
       
       static int partition(int[] ar, int left,int right) {
           //Select the last element as pivot
    	   int pivot = ar[right];
    	   int i = left, j = right;
    	   int temp;
    	   while(i <= j) {
	           while(i < ar.length && ar[i] < pivot) {
	        	   i++;
	           }
	           
	           while(j > 0 && ar[j] > pivot) {
	        	   j--;
	           }
	            
	           //System.out.println("left: " + left + " right: " + right + " arr[left]: " + ar[left] + " arr[right]: " + ar[right]);
	           
	           if(i <= j) {
		           temp = ar[j];
		           ar[j] = ar[i];
		           ar[i] = temp;
		           i++;
		           j--;
	           }
    	   }
    	   
    	   //printArray(ar);
           
           return i;         
       }   
 
      static void printArray(int[] ar) {
         for(int n: ar){
            System.out.print(n+" ");
         }
         System.out.println();
      }
       
      static void quickSort(int[] arr, int left, int right) {
    	  int index = partition(arr, left, right);
    	  //System.out.println("index: " + index);
    	  if(left < index - 1)
    		  quickSort(arr, left, index - 1);
    	  if(index < right) 
    		  quickSort(arr, index, right);
      }
      public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt(); 
           }
           quickSort(ar, 0, ar.length - 1);
           
           printArray(ar);
       }    
   }