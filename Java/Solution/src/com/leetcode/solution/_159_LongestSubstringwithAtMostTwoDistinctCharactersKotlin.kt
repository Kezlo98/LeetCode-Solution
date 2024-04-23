package com.leetcode.solution

import kotlin.math.max

fun main() {
    print("Result: ${lengthOfLongestSubstringTwoDistinct("")}")
}

fun lengthOfLongestSubstringTwoDistinct(s: String): Int {
    if (s.length < 2){
        return s.length
    }

    var l = 0;
    var r = 1;
    val charCount = mutableMapOf<Char, Int>()
    charCount[s[l]] = 1;
    var result = 1

    while (r < s.length){
        charCount[s[r]] = (charCount[s[r]]?: 0) +1
        while (charCount.size > 2 && charCount[s[l]]!! >= 0){
            charCount[s[l]] = (charCount[s[l]]?: 0) - 1
            if(charCount[s[l]] == 0){
                charCount.remove(s[l])
            }
            l ++;
        }
        result = max(result, r-l+1)
        r ++
    }
    return r

}