package src.com.leetcode.solution;

import java.util.*;

public class _347_TopKFrequentElements {
    /*
        Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



        Example 1:

        Input: nums = [1,1,1,2,2,3], k = 2
        Output: [1,2]
        Example 2:

        Input: nums = [1], k = 1
        Output: [1]


        Constraints:

        1 <= nums.length <= 105
        -104 <= nums[i] <= 104
        k is in the range [1, the number of unique elements in the array].
        It is guaranteed that the answer is unique.


        Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
     */

    public static void main(String[] args) {
        int[] nums = {5,3,1,1,1,3,73,1};
        System.out.print("Result: ");
        int[] result = topKFrequent(nums, 2);
        for (int num : result) {
            System.out.print("\t" + num);
        }
    }

    public static int[] topKFrequent(int[] nums, int k){
        HashMap<Integer,Integer> countNums = new HashMap<>();

        for (int num : nums){
            if (countNums.containsKey(num)){
                countNums.put(num,countNums.get(num) + 1);
            } else {
                countNums.put(num,1);
            }
        }

        HashMap<Integer, List<Integer>> countMap = new HashMap<>();
        int indexKey = 0;

        for (Map.Entry<Integer,Integer> element : countNums.entrySet()){
            indexKey = Math.max(indexKey,element.getValue());
            if (countMap.containsKey(element.getValue())){
                countMap.get(element.getValue()).add(element.getKey());
            } else {
                List<Integer> numList = new ArrayList<>();
                numList.add(element.getKey());
                countMap.put(element.getValue(),numList);
            }
        }
        int count = k;
        int[] result = new int[k];
        while (count > 0){
            List<Integer> numList = countMap.get(indexKey);
            if (numList == null) {
                indexKey--;
                continue;
            }
            for (Integer integer : numList) {
                result[--count] = integer;
            }
            indexKey --;
        }

        return result;
    }
}
