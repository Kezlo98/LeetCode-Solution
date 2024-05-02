package src.com.leetcode.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class validParentheses {

  public static void main(String[] args) {
    if(isValid("((")){
      System.out.print("true");
    } else {
      System.out.print("false");
    }
  }

  public static boolean isValid(String s) {

    if(s.length() < 2){
      return false;
    }

    List<Character> bracketArrays = Arrays.asList('(','[','{','}',']',')');
    LinkedList<Character> parentheses = new LinkedList<>();

    for (int i = 0; i < s.length() ; i ++){
      int index = bracketArrays.indexOf(s.charAt(i));
      if(index > -1){
        if(index < 3){
          parentheses.add(s.charAt(i));
        } else {
          if(parentheses.isEmpty()){
            return false;
          }
          Character parenthe = parentheses.getLast();
          if(parenthe != bracketArrays.get(5-index) ){
            return false;
          }
          parentheses.removeLast();
        }
      }
    }

    return parentheses.isEmpty();
  }

}
