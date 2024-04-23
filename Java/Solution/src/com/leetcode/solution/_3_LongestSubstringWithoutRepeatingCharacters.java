package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

public class _3_LongestSubstringWithoutRepeatingCharacters {
    /*
        Given a string s, find the length of the longest
        substring without repeating characters.



        Example 1:

        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.
        Example 2:

        Input: s = "bbbbb"
        Output: 1
        Explanation: The answer is "b", with the length of 1.
        Example 3:

        Input: s = "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.
        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.print("Result: " + lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> existCharacter = new HashMap<>();
        int result = 0;
        int firstIndexOfWindow = 0;

        for (int i = 0; i < s.length(); i ++){
            char temp = s.charAt(i);
            if(!existCharacter.containsKey(temp) || existCharacter.get(temp) < firstIndexOfWindow){
                existCharacter.put(temp,i);
                result = Math.max(result,i - firstIndexOfWindow + 1);
            } else {
                firstIndexOfWindow = existCharacter.get(temp) + 1;
                existCharacter.put(temp,i);
            }
        }
        return result ;
    }
}
