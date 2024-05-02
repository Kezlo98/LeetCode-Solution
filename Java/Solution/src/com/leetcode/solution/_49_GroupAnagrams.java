package src.com.leetcode.solution;

import java.util.*;

public class _49_GroupAnagrams {
    /*
    Given an array of strings strs, group the anagrams together. You can return the answer in any order.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



    Example 1:

    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    Example 2:

    Input: strs = [""]
    Output: [[""]]
    Example 3:

    Input: strs = ["a"]
    Output: [["a"]]


    Constraints:

    1 <= strs.length <= 104
    0 <= strs[i].length <= 100
    strs[i] consists of lowercase English letters.
     */

    public static void main(String[] args) {
        String[] strs = {"a"};

        System.out.println("Result");
        List<List<String>> lists = groupAnagrams(strs);
        for (List<String> list : lists) {
            System.out.print("[");
            for (String s : list) {
                System.out.print(s + ",");
            }
            System.out.print("]");
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> tracking = new HashMap<>();

      for (String str : strs) {
        String s = str;
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        s = Arrays.toString(temp);
        if(tracking.containsKey(s)) {
          tracking.get(s).add(str);
        } else {
          List<String> index = new ArrayList<>();
          index.add(str);
          tracking.put(s, index);
        }
      }

        return new ArrayList<>(tracking.values());
    }
}
