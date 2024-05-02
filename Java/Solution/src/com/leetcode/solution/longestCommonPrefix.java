package src.com.leetcode.solution;

public class longestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"",""};
        String longestPrefix = longestCommonPrefix(strs);
        System.out.printf(longestPrefix);
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length < 1){
            return "";
        } else if (strs.length == 1){
            return strs[0];
        }
        // Max element of array is 200 and max length of single element is 200
        int prefixLength = 0;
        for (int i = 0; i < 200; i ++){
            Character validChar = null;
            boolean breakLoop = false;
            for (String str : strs) {
                if (str.length() < 1) {
                    return "";
                }
                if (str.length() < (i + 1)) {
                    breakLoop = true;
                    break;
                }
                if (validChar == null) {
                    validChar = str.charAt(i);
                } else {
                    if (validChar != str.charAt(i)) {
                        breakLoop = true;
                        break;
                    }
                }
            }
            if(breakLoop){
                break;
            } else {
                prefixLength = i+1;
            }
        }
        return prefixLength == 0 ? "" : strs[0].substring(0,prefixLength);
    }
}
