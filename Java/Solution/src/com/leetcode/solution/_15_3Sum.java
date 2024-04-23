package com.leetcode.solution;

import java.util.*;

public class _15_3Sum {

    /*
        Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

        Notice that the solution set must not contain duplicate triplets.



        Example 1:

        Input: nums = [-1,0,1,2,-1,-4]
        Output: [[-1,-1,2],[-1,0,1]]
        Explanation:
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
        The distinct triplets are [-1,0,1] and [-1,-1,2].
        Notice that the order of the output and the order of the triplets does not matter.
        Example 2:

        Input: nums = [0,1,1]
        Output: []
        Explanation: The only possible triplet does not sum up to 0.
        Example 3:

        Input: nums = [0,0,0]
        Output: [[0,0,0]]
        Explanation: The only possible triplet sums up to 0.


        Constraints:

        3 <= nums.length <= 3000
        -105 <= nums[i] <= 105
     */
    public static void main(String[] args) {
        int[] nums = {34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49};
        List<List<Integer>> result = threeSum(nums);

        System.out.print("Result: ");
        for (List<Integer> list : result){
            System.out.print("\n");
            for (Integer num : list) {
                System.out.print("\t" + num);
            }
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i ++){
            int forwardPointer = i + 1;
            int backwardPointer = nums.length - 1;
            while (forwardPointer < backwardPointer){

                if( nums[forwardPointer] + nums[backwardPointer] == (-nums[i])){
                    result.add(Arrays.asList(nums[i], nums[forwardPointer], nums[backwardPointer]));
                    forwardPointer ++;
                    backwardPointer--;
                } else if (nums[forwardPointer] + nums[backwardPointer] < (-nums[i])){
                    forwardPointer ++;
                } else {
                    backwardPointer--;
                }
            }
        }

        return new ArrayList<>(result);
    }
}
