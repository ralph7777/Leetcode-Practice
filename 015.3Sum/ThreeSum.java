package ralphLC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
	
    public static List<List<Integer>> threeSum(int[] nums) {
	/** Algorithm (Two Pointer): 
	    1. Sort the integer array;
	    2. Iterate through array, assume every entry as the first number of three numbers;
	    3. Search the remaining (n-1) entries, set two points at the beginning and the end,
	       use two pointers method to find other two numbers;
	    4. For every right solution, store the three numbers in a List and add it to the output List.    
	    Step 1 runs O(nlgn); Step 2 iterates through n entries, then step 3 use two pointers to find
	    the other two entries, so it totally costs O(n*(n-1))=O(n*n).The algorithm runs O(n2) time.
	  */    

	Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        int i=0;
        int len=nums.length;
        
        while (i<len) {
            int start=i+1;
            int end=nums.length-1;
        	while (start<end) {

        		//System.out.printf("i=%d,nums[i]=%d\n",i,nums[i]);
        		//System.out.printf("start=%d,nums[start]=%d\n",start,nums[start]);
        		//System.out.printf("end=%d,nums[end]=%d\n",end,nums[end]);
        		
        		if (start==i) {
        			start++;
        			continue;
        		}
        		if (end==i) {
        			end--;
        			continue;
        		}
        		int twosum=nums[start]+nums[end];
        		if (twosum<(-nums[i])) {
        			start++;
        		}
        		else if (twosum>(-nums[i])) {
        			end--;
        		}
        		else {
                		List<Integer> subset=new ArrayList<Integer>();
        			subset.add(nums[i]);
        			subset.add(nums[start]);
        			subset.add(nums[end]);
        			if (!result.contains(subset)) {
        				result.add(subset);
        			}
        			start++;
        		}
        	}
        	i++;
        }
        return result;
    }
	
    public static List<List<Integer>> threeSum2(int[] nums) {
	/** Modified Two Pointers: 
	    This is a modified two pointer method. It removes all the duplicate consideration
	    of same element in the array, and it is so far the most efficient one. It successfully
	    passed all the test cases in the LeetCode website (313 cases).
	  */  
	    
    	Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        int i=0;
        int len=nums.length;
        int former=Integer.MAX_VALUE;
        
        while (i<len) {
            //avoid duplicate check of 1st
            if (nums[i]==former) {
        	i++;
        	continue;
            }
        	
            former=nums[i];
            int start=i+1;
            int end=nums.length-1;
            
        	while (start<end) {

        		System.out.printf("i=%d,nums[i]=%d\n",i,nums[i]);
        		System.out.printf("start=%d,nums[start]=%d\n",start,nums[start]);
        		System.out.printf("end=%d,nums[end]=%d\n",end,nums[end]);
        		
        		int twosum=nums[start]+nums[end];
        		if (twosum<(-nums[i])) {
        			start++;
        		}
        		else if (twosum>(-nums[i])) {
        			end--;
        		}
        		else {
                	List<Integer> subset=new ArrayList<Integer>();
        			subset.add(nums[i]);
        			subset.add(nums[start]);
        			subset.add(nums[end]);
        			result.add(subset);
        			
        			//avoid duplicate check of 2nd and 3rd
        			while (start<end && nums[start+1]==nums[start]) start++;
        			while (start<end && nums[end-1]==nums[end]) end--;

        			start++;
        			end--;
        		}
        	}
        	i++;
        }
        return result;
    }
    
    public static List<List<Integer>> threeSum3(int[] nums) {
	/** Algorithm (Triple nested Loop): 
	    Iterate through all entries in array, try combination of all possible three numbers,
	    store right three numbers in a List and add it to the output List.
	    This is a brutal force algorithms, using triple nested loop, so it runs O(n3) time.
	*/
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        int len=nums.length;
        for (int i=0; i<len; i++) {
        	for (int j=i+1; j<len; j++) {
        		for (int k=j+1; k<len; k++) {
        			if ((nums[i]+nums[j]+nums[k])==0) {
        				List<Integer> subset=new ArrayList<Integer>();
            				subset.add(nums[i]);
            				subset.add(nums[j]);
            				subset.add(nums[k]);
            				Collections.sort(subset);
            				if (!result.contains(subset)) {
            					result.add(subset);
            				}	
            			}
        		}
        	}
        }
        return result;
    }
    
    //Test driver
    public static void main(String[] args) {
		int[] nums={-1,0,1,2,-1,-4};
		System.out.println(threeSum(nums));		
		System.out.println(threeSum2(nums));
	    	System.out.println(threeSum3(nums));	
	}
    
}
