package ralphLC;

import java.util.Arrays;

/** Algorithm: 
    1. Sort the integer array;
    2. Set two points, search from the beginning and the end of sorted array to find two numbers;
    3. Determine the indices in the original array.    
    Step 1 runs O(nlgn), Step 2 runs O(n), Step 3 runs O(n). The algorithm runs O(nlgn) time.
*/
public class TwoSum {
	
    public static int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int[] nums2 = Arrays.copyOf(nums,n);
        
        int i=0;
        int j=n-1;
        int[] indices={-1,-1};
        
        //Step 1:
        Arrays.sort(nums2);
        
        //Step 2:
        while (i<j) {
            int sum=nums2[i]+nums2[j];
            if (sum < target) i++;
            else if (sum > target) j--;
            else {
                
                //Step 3:
                if (nums2[i]!=nums2[j]) {
                    for (int k=0;k<n;k++) {
                        if (nums[k]==nums2[i]) indices[0]=k;
                        if (nums[k]==nums2[j]) indices[1]=k;
                    	}
                    }
                else {
                    for (int k=0;k<n;k++) {
                        if (nums[k]==nums2[i]) {
                            indices[0]=k;
                            while (k<n) {
                                k++;
                                if (nums[k]==nums2[i]) {
                                    indices[1]=k;
                                    break;
                                    }
                            	}
                            break;
                            }
                    	}
                    }
                break;
            	}
 	    }
        return indices;
    }


/** Algorithm: 
    1. Compute the difference value between target and each integer in the array;
    2. Compare those integers behind to the value, if match, update the return indices.
    This is a brutal force algorithms, using nested loop, so the algorithm runs O(nlgn) time.
*/    
    public static int[] twoSum2(int[] nums, int target) {
        int[] indices={-1,-1};
        
        for (int i=0; i<nums.length; i++) {
            int diff=target-nums[i];
            for (int j=i+1; j<nums.length; j++) {
                if (nums[j]==diff) {
                    indices[0]=i;
                    indices[1]=j;
                }
            }
        }        
        return indices;
    } 

    
    //Test driver
    public static void main(String[] args) {
	int[] nums={3,2,4};
	int target=6;
	int[] indices=twoSum(nums,target);
	System.out.printf("[%d,%d]\n",indices[0],indices[1]);		
		
	int[] nums2={3,2,3};
	target=6;
	indices=twoSum(nums2,target);
	System.out.printf("[%d,%d]",indices[0],indices[1]);
	}
}