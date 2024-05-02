package src.com.leetcode.solution;

/*
https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/

  Given a string s, return the length of the longest
  substring
   that contains at most two distinct characters.



  Example 1:

  Input: s = "eceba"
  Output: 3
  Explanation: The substring is "ece" which its length is 3.
  Example 2:

  Input: s = "ccaabbb"
  Output: 5
  Explanation: The substring is "aabbb" which its length is 5.


  Constraints:

  1 <= s.length <= 105
  s consists of English letters.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _159_LongestSubstringwithAtMostTwoDistinctCharacters {

  public static void main (String[] args) {

    System.out.printf("Result: " + lengthOfLongestSubstringTwoDistinct("cacbcaaccbccaccccccbcaba"));
  }

  public static int lengthOfLongestSubstringTwoDistinct(String s) {
    if(s.length() <= 2){
      return s.length();
    }
    char[] charArray = s.toCharArray();
    int slow = 0;
    int fast = 1;
    Map<Character, Integer> charCount = new HashMap<>();
    Set<Character> existChar = new HashSet<>();
    existChar.add(charArray[slow]);
    charCount.put(charArray[slow], 1);

    int result = 1;

    while (fast < s.length()){
      Character cur = charArray[fast];
      charCount.put(cur,charCount.getOrDefault(cur,0) + 1);
      existChar.add(cur);
      while (existChar.size() > 2 && charCount.get(charArray[slow]) >= 0){
        charCount.put(charArray[slow],charCount.get(charArray[slow]) - 1);
        if(charCount.get(charArray[slow]) == 0){
          existChar.remove(charArray[slow]);
        }
        slow ++;
      }
      result = Math.max(result, fast - slow + 1);
      fast ++;
    }

    return result;
  }
}
