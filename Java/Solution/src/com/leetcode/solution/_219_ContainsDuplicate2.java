package src.com.leetcode.solution;

import java.util.HashMap;

public class _219_ContainsDuplicate2 {
    /*
    Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.



    Example 1:

    Input: nums = [1,2,3,1], k = 3
    Output: true
    Example 2:

    Input: nums = [1,0,1,1], k = 1
    Output: true
    Example 3:

    Input: nums = [1,2,3,1,2,3], k = 2
    Output: false

    1 <= nums.length <= 105
    -109 <= nums[i] <= 109
    0 <= k <= 105
     */

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        System.out.println("Result: " + containsNearbyDuplicate(nums, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> tracking = new HashMap<>();

        for (int i = 0; i < nums.length; i ++ ){
            if(tracking.containsKey(nums[i]) && (i - tracking.get(nums[i]) <= k)){
                    return true;
                }
                tracking.put(nums[i], i );
            }
        return false;
    }
}
