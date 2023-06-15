package com.leetcode.solution.topInterviewQuestions;

public class _135_candy {

    public static void main(String[] args) {
        int[] ratings = {1,0,2};

        int count = candy(ratings);
        System.out.printf(String.valueOf(count));
    }

    public static int candy(int[] ratings) {
        int length = ratings.length;
        int[] candies = new int[length];

        for(int i = 1; i < length; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }

        for(int i = length-2; i >= 0; i --){
            if(ratings[i] > ratings[i+1]){
                if(candies[i] <= candies[i+1]){
                    candies[i] = candies[i+1] +1;
                }
            }
        }

        int result = 0;
        for (int i : candies){
            result += i;
        }

        return (result + length);
    }
}
