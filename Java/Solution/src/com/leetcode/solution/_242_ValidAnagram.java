package src.com.leetcode.solution;

import java.util.HashMap;

public class _242_ValidAnagram {
    /*
        Given two strings s and t, return true if t is an anagram of s, and false otherwise.

        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

        

        Example 1:

        Input: s = "anagram", t = "nagaram"
        Output: true
        Example 2:

        Input: s = "rat", t = "car"
        Output: false

        Constraints:

        1 <= s.length, t.length <= 5 * 104
        s and t consist of lowercase English letters.

        
        Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case? 
     */

     public static void main(String[] args) {
        String s = "rat";
        String t = "car";

        System.out.println("Is Anagram: " + isAnagram(s, t));
     }

    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> charExist = new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }
        for (char word : t.toCharArray()){
            if(charExist.containsKey(word)){
                charExist.put(word, charExist.get(word) + 1);
            } else {
                charExist.put(word, 1);
            }
        }

        for (char word : s.toCharArray()){
            if(!charExist.containsKey(word)){
                return false;
            } else {
                int temp = charExist.get(word);
                if(temp == 1){
                    charExist.remove(word);
                } else {
                    charExist.put(word, temp - 1);
                }
            }
        }

        return true;
    }
}


