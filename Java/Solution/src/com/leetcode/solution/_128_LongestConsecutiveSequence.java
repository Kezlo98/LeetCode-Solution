package src.com.leetcode.solution;

import java.util.Arrays;
import java.util.HashMap;

public class _128_LongestConsecutiveSequence {
    /*
        Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

        You must write an algorithm that runs in O(n) time.



        Example 1:

        Input: nums = [100,4,200,1,3,2]
        Output: 4
        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
        Example 2:

        Input: nums = [0,3,7,2,5,8,4,6,0,1]
        Output: 9


        Constraints:

        0 <= nums.length <= 105
        -109 <= nums[i] <= 109
     */

    public static void main(String[] args) {
        int[] nums = {1,2,0,1};

        System.out.println("Result: " + longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if(nums.length <=1 ){
            return nums.length;
        }
        Arrays.sort(nums);
        int result = 1;
        int temp = 1;
        for (int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                if(nums[i] -1 == nums[i-1]){
                    temp++;
                } else {
                    result = Math.max(result, temp);
                    temp = 1;
                }
            }
        }
        return Math.max(result, temp);
    }
}
