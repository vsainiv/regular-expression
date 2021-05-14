package com.regular.expression;

/**
 * Implement regular expression matching with support for '.' and '*'.
 *   '.' Matches any single character.
 *   '*' Matches zero or more of the preceding element.
 *
 * isMatch("aa","a") return false
 * isMatch("aa","aa") return true
 * isMatch("aaa","aa") return false
 * isMatch("aa", "a.") return true
 *
 * isMatch("aa", "a*") return true
 * isMatch("aa", ".*") return true
 * isMatch("ab", "a*b*") return true
 * isMatch("aab", "c*a*b") return true
 */
public class RegularExpression {

  public static boolean isMatch(String input, String regularExp) {

    if (regularExp.length() == 0) {
      return input.length() == 0;
    }

    if (regularExp.length() == 1) {
      if (input.length() == 0) {
        return false;
      } else if(input.charAt(0) != regularExp.charAt(0) && regularExp.charAt(0) != '.'){
        return false;
      } else {
        return isMatch(input.substring(1), regularExp.substring(1));
      }
    }

    if (regularExp.charAt(1) != '*') {
      if (input.length() == 0) {
        return false;
      }
      if (input.charAt(0) != regularExp.charAt(0) && regularExp.charAt(0) != '.') {
        return false;
      } else {
        return isMatch(input.substring(1), regularExp.substring(1));
      }
    } else {

      if (isMatch(input, regularExp.substring(2))) {
        return true;
      }

      int i = 0;
      while (i < input.length() &&
          (input.charAt(i) == regularExp.charAt(0) || regularExp.charAt(0) == '.')) {
        if (isMatch(input.substring(i + 1), regularExp.substring(2))) {
          return true;
        }
        i++;
      }
      return false;
    }

  }

  public static void main(String[] args) {
    System.out.println(isMatch("aa","a"));
    System.out.println(isMatch("aa","aa"));
    System.out.println(isMatch("aaa","aa"));
    System.out.println(isMatch("aa","a."));

    System.out.println(isMatch("aa","a*"));
    System.out.println(isMatch("aa",".*"));
    System.out.println(isMatch("ab", ".*b*"));
    System.out.println(isMatch("aab", "c*a*b"));
  }


}
