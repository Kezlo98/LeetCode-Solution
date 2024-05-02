package src.com.leetcode.solution;

public class _875_KokoEatingBananas {
    /*
        Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

        Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

        Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

        Return the minimum integer k such that she can eat all the bananas within h hours.



        Example 1:

        Input: piles = [3,6,7,11], h = 8
        Output: 4
        Example 2:

        Input: piles = [30,11,23,4,20], h = 5
        Output: 30
        Example 3:

        Input: piles = [30,11,23,4,20], h = 6
        Output: 23


        Constraints:

        1 <= piles.length <= 104
        piles.length <= h <= 109
        1 <= piles[i] <= 109
     */

    public static void main(String[] args) {
        int[] piles = {312884470};
        System.out.printf("Result: " + minEatingSpeed(piles,968709470));
    }

    private static  int minEatingSpeed(int[] piles, int h){
        int maxValue = 0;
        for (int pile: piles){
            maxValue = Math.max(maxValue,pile);
        }
        int result = maxValue;
        if(piles.length == h){
            return maxValue;
        }
        int slowestTryIndex = 0;
        int fastestTryIndex = maxValue;
        while (slowestTryIndex <= fastestTryIndex){
            int minTryIndex = slowestTryIndex + (fastestTryIndex - slowestTryIndex)/2;
            if (minTryIndex == 0){
                break;
            }
            int totalTime = 0;
            for (int pile : piles){
                totalTime += (pile + minTryIndex - 1 ) / minTryIndex;
            }
            if (totalTime > h){
                slowestTryIndex = minTryIndex + 1;
            } else {
                result = Math.min(result,minTryIndex);
                fastestTryIndex = minTryIndex - 1;
            }
        }

        return result;
    }
}
