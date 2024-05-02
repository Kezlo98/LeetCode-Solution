package src.com.leetcode.solution;

public class _45_JumGame_2 {

    /*
    * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

        Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

        0 <= j <= nums[i] and
        i + j < n
        Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].



        Example 1:

        Input: nums = [2,3,1,1,4]
        Output: 2
        Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
        Example 2:

        Input: nums = [2,3,0,1,4]
        Output: 2
    * */

    public static void main(String[] args) {
        int[] nums = {3,4,3,2,5,4,3};
        System.out.printf("Jump step: " + jump(nums));
    }

    public static int jump(int[] nums) {
        int maximumIndex = 0;
        int end = 0;
        int jumpCount = 0;
        for (int i = 0; i < nums.length-1; i++) {
            maximumIndex = Math.max(maximumIndex, i + nums[i]);
            if(i == end){
                jumpCount ++;
                end = maximumIndex;
            }
        }

        return jumpCount;
    }
}
