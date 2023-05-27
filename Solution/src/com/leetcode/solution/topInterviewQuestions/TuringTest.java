package com.leetcode.solution.topInterviewQuestions;

import java.util.HashMap;
import java.util.Map;

public class TuringTest {

  public static void main(String[] args) {
    System.out.println(solution("aaaaaaaaaaaj"));
  }

  public static int solution(String s){
    char[] sChar = s.toCharArray();
    int length = s.length();
    Map<Character, Integer> mapChar = new HashMap<>();

    for (int i = 0; i < length; i ++){
      char c = sChar[i];
      if(mapChar.containsKey(c)){
        mapChar.put(c,i-1);
      } else {
        mapChar.put(c,0);
      }
    }

    int result = -1;

    for(Integer path : mapChar.values()){
      if(path != 0 && path > result){
        result = path;
      }
    }

    return result;
  }
}
