package src.com.leetcode.solution;

import java.util.HashMap;

public class _205_IsomorphicStrings {
    /*
    Given two strings s and t, determine if they are isomorphic.

    Two strings s and t are isomorphic if the characters in s can be replaced to get t.

    All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.



    Example 1:

    Input: s = "egg", t = "add"
    Output: true
    Example 2:

    Input: s = "foo", t = "bar"
    Output: false
    Example 3:

    Input: s = "paper", t = "title"
    Output: true


    Constraints:

    1 <= s.length <= 5 * 104
    t.length == s.length
    s and t consist of any valid ascii character.
     */

    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";

        System.out.println("Result: " + isIsomorphic(s,t));
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> mapStringS = new HashMap<>();
        HashMap<Character,Character> mapStringT = new HashMap<>();

        for (int i = 0; i < s.length(); i ++){
            if((mapStringS.containsKey(s.charAt(i)) && mapStringS.get(s.charAt(i)) != t.charAt(i)) ||
                    (mapStringT.containsKey(t.charAt(i)) && mapStringT.get(t.charAt(i)) != s.charAt(i)))
            {
                return false;
            }
            mapStringS.putIfAbsent(s.charAt(i),t.charAt(i));
            mapStringT.putIfAbsent(t.charAt(i),s.charAt(i));
        }

        return true;
    }
}
