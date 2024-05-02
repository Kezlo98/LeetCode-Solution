package src.com.leetcode.solution;

public class _88_MergeSortedArray {

    /*
    * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

        Merge nums1 and nums2 into a single array sorted in non-decreasing order.

        The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.



        Example 1:

        Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        Output: [1,2,2,3,5,6]
        Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
        The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
    *
    * */

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        System.out.print("Result: \n");
        merge(nums1,3,nums2,3);
        for (int i : nums1){
            System.out.printf(i + " ");
        }
    }

    public static void merge (int[] nums1, int m, int[] nums2, int n){
        if(n == 0){
            return;
        }

        if(m == 0){
            System.arraycopy(nums2, 0, nums1, 0, n);
        } else {
            int i = m-1;
            int j = n-1;
            int tempIndex = m + n - 1;
            while (tempIndex >= 0){
                if(i <0 || (j >= 0 && nums1[i] <= nums2[j])){
                    nums1[tempIndex] = nums2[j];
                    tempIndex --;
                    j --;
                } else if (i == tempIndex){
                    return;
                } else  {
                    nums1[tempIndex] = nums1[tempIndex] + nums1[i];
                    nums1[i] = nums1[tempIndex] - nums1[i];
                    nums1[tempIndex] = nums1[tempIndex] - nums1[i];
                    tempIndex --;
                    i--;
                }
            }
        }

    }
}
