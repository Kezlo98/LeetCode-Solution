package com.leetcode.solution;

import java.util.HashMap;

public class _424_LongestRepeatingCharacterReplacement {

    /*
    You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

    Return the length of the longest substring containing the same letter you can get after performing the above operations.



    Example 1:

    Input: s = "ABAB", k = 2
    Output: 4
    Explanation: Replace the two 'A's with two 'B's or vice versa.
    Example 2:

    Input: s = "AABABBA", k = 1
    Output: 4
    Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA"
    The substring "BBBB" has the longest repeating letters, which is 4.
    There may exist other ways to achieve this answer too.


    Constraints:

    1 <= s.length <= 105
    s consists of only uppercase English letters.
    0 <= k <= s.length
     */

    public static void main(String[] args) {
        String s = "AABABBA";
        System.out.printf("Result: " + characterReplacement(s,1));
    }

    public static int characterReplacement(String s, int k) {
        int maxFreq = 0;
        int[] arrays = new int[26];
        int firstWindowIndex = 0;
        int windowLength = 0;

        for (int i = 0; i < s.length(); i++){
            arrays[s.charAt(i) - 'A'] ++;
            maxFreq = Math.max(maxFreq,arrays[s.charAt(i) - 'A']);

            if ((i - firstWindowIndex - maxFreq + 1) > k){
                arrays[s.charAt(firstWindowIndex) - 'A'] --;
                firstWindowIndex ++;
            }
            windowLength = Math.max(maxFreq, i - firstWindowIndex + 1);
        }

        return windowLength;
    }

    /*
        Solution:
            Slide-Window: Find the longest slide-window length with condition:
                Length - maxFreq <= k
            maxFreq: The max frequency of character appears in string.

            => To find max Length, we need to find maxFreq character in a substring
            We will slide a window to find substring and record the total number appears of each character in window
            Then we compare with maxFreq to update new value.
            IF (Length - maxFreq <= k) => the window is sink => need to shift first index of window
            We need to update count of shifted character, but we do not need to update maxFreq in window
            Because we only care if 1 character is appeared more than maxFreq to update
            Then window length = Math.max(maxFreq, length of final window slide)

     */
}
