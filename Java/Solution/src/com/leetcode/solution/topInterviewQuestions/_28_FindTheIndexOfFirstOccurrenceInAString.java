package src.com.leetcode.solution.topInterviewQuestions;

public class _28_FindTheIndexOfFirstOccurrenceInAString {
    /*
    Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.



    Example 1:

    Input: haystack = "sadbutsad", needle = "sad"
    Output: 0
    Explanation: "sad" occurs at index 0 and 6.
    The first occurrence is at index 0, so we return 0.
    Example 2:

    Input: haystack = "leetcode", needle = "leeto"
    Output: -1
    Explanation: "leeto" did not occur in "leetcode", so we return -1.
     */

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issipi";

        System.out.print("Result " + strStr(haystack,needle));
    }

    public static int strStr(String haystack, String needle) {
        int lengthN = needle.length();
        int lengthH = haystack.length();

        if(lengthN > lengthH){
            return -1;
        }
        if(lengthN == lengthH){
            if (haystack.equals(needle)){
                return 0;
            } else {
                return -1;
            }
        }
        boolean isFound;

        for (int i = 0; i < lengthH; i ++){
            if(haystack.charAt(i) == needle.charAt(0)){
                isFound = true;
                for(int j = 1; j < lengthN; j ++){
                    if(j + i == lengthH){
                        return -1;
                    }
                    if (haystack.charAt(j + i) != needle.charAt(j)){
                        isFound = false;
                        break;
                    }
                }
                if(isFound) {
                    return i;
                }
            }
        }

        return -1;
    }
}
