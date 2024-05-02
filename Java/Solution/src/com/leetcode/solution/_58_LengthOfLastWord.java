package src.com.leetcode.solution;

public class _58_LengthOfLastWord {
    /*
        Given a string s consisting of words and spaces, return the length of the last word in the string.

        A word is a maximal
        substring
         consisting of non-space characters only.



        Example 1:

        Input: s = "Hello World"
        Output: 5
        Explanation: The last word is "World" with length 5.
        Example 2:

        Input: s = "   fly me   to   the moon  "
        Output: 4
        Explanation: The last word is "moon" with length 4.
        Example 3:

        Input: s = "luffy is still joyboy"
        Output: 6
        Explanation: The last word is "joyboy" with length 6.
    * */

    public static void main(String[] args) {
        String s = "luffy";

        System.out.printf("Length of Last Word: " + lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        return s.length() - s.lastIndexOf(" ") - 1;
    }
}
