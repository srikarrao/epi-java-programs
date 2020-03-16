package com.eop.java.programs.dynamicprogramming;

/**
 * Sources:
 * https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubstring(null));
        System.out.println(longestPalindromeBruteForce(null));

        System.out.println(longestPalindromeSubstring(""));
        System.out.println(longestPalindromeBruteForce(""));

        System.out.println(longestPalindromeSubstring("a"));
        System.out.println(longestPalindromeBruteForce("a"));

        System.out.println(longestPalindromeSubstring("abcba"));
        System.out.println(longestPalindromeBruteForce("abcba"));

        System.out.println(longestPalindromeSubstring("abba"));
        System.out.println(longestPalindromeBruteForce("abba"));

        System.out.println(longestPalindromeSubstring("acba"));
        System.out.println(longestPalindromeBruteForce("acba"));

        System.out.println(longestPalindromeSubstring("aaaa"));
        System.out.println(longestPalindromeBruteForce("aaaa"));

        System.out.println(longestPalindromeSubstring("ab"));
        System.out.println(longestPalindromeBruteForce("ab"));

        System.out.println(longestPalindromeSubstring("aba"));
        System.out.println(longestPalindromeBruteForce("aba"));

        System.out.println(longestPalindromeSubstring("abaccab"));
        System.out.println(longestPalindromeBruteForce("abaccab"));

        System.out.println(longestPalindromeSubstring("abccbb"));
        System.out.println(longestPalindromeBruteForce("abccbb"));
    }

    public static String longestPalindromeSubstring(String str) {

        if (str == null || str.length() < 2) {
            return str;
        }

        String longestPalindrome = str.substring(0, 1);
        int maxLength = 1;

        boolean[][] dp = new boolean[str.length()][str.length()];

        for (int i = 0; i < str.length(); i++) {
            dp[i][i] = true;
        }
        int offset = 0;
        while (offset < str.length()) {
            int i = 0;
            int j = 1;
            while (j + offset < str.length()) {
                if (str.charAt(i) != str.charAt(j + offset)) {
                    dp[i][j + offset] = false;
                } else {
                    dp[i][j + offset] = j + offset - i > 1 ? dp[i + 1][j + offset - 1] : true;
                    if (dp[i][j + offset]) {
                        maxLength = Integer.max(maxLength, j + offset - i > 1 ? j + offset - i : 1);
                        if (maxLength == j + offset - i) {
                            longestPalindrome = str.substring(i, j + offset + 1);
                        }
                    }
                }
                i++;
                j++;
            }
            offset++;
        }

        return longestPalindrome;
    }

    public static String longestPalindromeBruteForce(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        String longestPalindrome = "";
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i; j < s.length(); j++) {
                if (i == 0 || i != j) {
                    if (isPalindrome(s, i, j)) {
                        String temp = j == s.length() - 1 ? s.substring(i) : s.substring(i, j + 1);
                        if (temp.length() > longestPalindrome.length()) {
                            longestPalindrome = temp;
                        }
                    }
                }
            }
        }

        return longestPalindrome;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
