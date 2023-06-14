package com.leetcode.solution.topInterviewQuestions;

import java.util.Arrays;

public class _88_MergeSortedArray {

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
