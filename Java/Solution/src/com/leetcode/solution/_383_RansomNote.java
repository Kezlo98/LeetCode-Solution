package src.com.leetcode.solution;

import java.util.HashMap;

public class _383_RansomNote {
    /*
    Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

    Each letter in magazine can only be used once in ransomNote.



    Example 1:

    Input: ransomNote = "a", magazine = "b"
    Output: false
    Example 2:

    Input: ransomNote = "aa", magazine = "ab"
    Output: false
    Example 3:

    Input: ransomNote = "aa", magazine = "aab"
    Output: true


    Constraints:

    1 <= ransomNote.length, magazine.length <= 105
    ransomNote and magazine consist of lowercase English letters.
     */

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";

        System.out.println("Result: " + canConstruct(ransomNote,magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }

        int[] freq = new int[26];
        for (char c : magazine.toCharArray()){
            freq[c - 'a'] ++;
        }

        for (char c : ransomNote.toCharArray()){
            if(freq[c - 'a'] == 0){
                return false;
            } else {
                freq[c - 'a']--;
            }
        }

        return true;
    }
}
