package com.leetcode.solution.topInterviewQuestions;

public class _125_ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.printf("Is s valid palindrome: " + isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int forwardIndex = 0;
        int backwardIndex = s.length() - 1;

        while (forwardIndex < backwardIndex){
            while (!isAlphaNumeric(s.charAt(forwardIndex)) && forwardIndex < backwardIndex){
                forwardIndex ++;
            }
            while (!isAlphaNumeric(s.charAt(backwardIndex)) && backwardIndex > forwardIndex){
                backwardIndex -- ;
            }
            if(s.charAt(forwardIndex) != s.charAt(backwardIndex)){
                return false;
            }
            forwardIndex++;
            backwardIndex--;
        }

        return true;
    }

    private static boolean isAlphaNumeric(char char1) {
        return (char1 >= 'a' && char1 <= 'z') ||
                (char1 >= 'A' && char1 <= 'Z') ||
                (char1 >= '0' && char1 <= '9');
    }
}
