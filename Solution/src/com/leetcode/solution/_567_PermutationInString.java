package com.leetcode.solution;

import java.util.HashMap;

public class _567_PermutationInString {
    /*
        Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

        In other words, return true if one of s1's permutations is the substring of s2.



        Example 1:

        Input: s1 = "ab", s2 = "eidbaooo"
        Output: true
        Explanation: s2 contains one permutation of s1 ("ba").
        Example 2:

        Input: s1 = "ab", s2 = "eidboaoo"
        Output: false


        Constraints:

        1 <= s1.length, s2.length <= 104
        s1 and s2 consist of lowercase English letters.
     */

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbyaooo";
        System.out.printf("Result: " + checkInclusion2(s1,s2));
    }

    public static boolean checkInclusion2(String s1, String s2){
        HashMap<Character, Integer> characterCount = new HashMap<>();
        int count = s1.length();
        for (Character s : s1.toCharArray()){
            characterCount.putIfAbsent(s,0);
            characterCount.put(s,characterCount.get(s) + 1);
        }

        for (int i = 0; i < s2.length(); i ++){
            if (i >= s1.length()) {
                char firstIndexKey = s2.charAt(i - s1.length());
                if (characterCount.containsKey(firstIndexKey)) {
                    if (characterCount.get(firstIndexKey) >= 0) {
                        count++;
                    }
                    characterCount.merge(firstIndexKey, 1, Integer::sum);
                }
            }
            if(characterCount.containsKey(s2.charAt(i))){
                if(characterCount.get(s2.charAt(i)) > 0) {
                    count--;
                }
                characterCount.merge(s2.charAt(i),-1,Integer::sum);
            }
            if (count == 0) {
                return true;
            }
        }

        return false;
    }
}
