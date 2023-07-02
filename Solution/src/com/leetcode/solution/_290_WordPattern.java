package com.leetcode.solution;

import java.util.HashMap;

public class _290_WordPattern {
    /*
        Given a pattern and a string s, find if s follows the same pattern.

        Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.



        Example 1:

        Input: pattern = "abba", s = "dog cat cat dog"
        Output: true
        Example 2:

        Input: pattern = "abba", s = "dog cat cat fish"
        Output: false
        Example 3:

        Input: pattern = "aaaa", s = "dog cat cat dog"
        Output: false


        Constraints:

        1 <= pattern.length <= 300
        pattern contains only lower-case English letters.
        1 <= s.length <= 3000
        s contains only lowercase English letters and spaces ' '.
        s does not contain any leading or trailing spaces.
        All the words in s are separated by a single space.
     */

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog dog dog dog";
        System.out.println("Result: " + wordPattern(pattern,s));
    }

    public static boolean wordPattern(String pattern, String s) {
        char[] patternChar = pattern.toCharArray();
        String[] stringArray = s.trim().split(" ");
        if(patternChar.length != stringArray.length){
            return false;
        }
        HashMap<Character,String> mappingPattern = new HashMap<>();
        HashMap<String,Character> mappingWord = new HashMap<>();

        for (int i = 0; i < pattern.length(); i ++){
            if((mappingPattern.containsKey(patternChar[i]) && !mappingPattern.get(patternChar[i]).equals(stringArray[i])) ||
                    mappingWord.containsKey(stringArray[i]) && !mappingWord.get(stringArray[i]).equals(patternChar[i])
            ){
                    return false;
            } else {
                mappingPattern.put(patternChar[i], stringArray[i]);
                mappingWord.put(stringArray[i], patternChar[i]);
            }
        }

        return true;
    }
}
