package com.cryon.dynamicprogramming.core;

/**
 * @author iimer
 * @description 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 *
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 注意：a + b 意味着字符串 a 和 b 连接。
 *
 * 提示：
 *
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1、s2、和 s3 都由小写英文字母组成
 * @date 2023-03-23 11:19:08
 */
public class 交错字符串97 {
    /*
    假设：
    双指针：在匹配到s3一个字符的时候，假如s1、s2的当前位置都是那个字符，则不好进行下去。
    单数组dp:dp[i]代表s3的i位置是否能匹配，因为不知道上个dp是s1、s2哪个位置匹配的，且无法拿到所有匹配的位置，无法根据dp[0~i-1]来判断i位置。
    双数组dp:dp[i][j]代表s1 i位置和s2 j位置是否匹配，
        如果s3.charAt(i+j)==s1.charAt(i) 则dp[i][j] = dp[i-1][j]
        如果s3.charAt(i+j)==s2.charAt(i) 则dp[i][j] = dp[i][j-1]
        如果都等于则 取或
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length()!=s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        char[] s1a = s1.toCharArray();
        char[] s2a = s2.toCharArray();
        char[] s3a = s3.toCharArray();
        for (int i = 1; i <= s1a.length && s1a[i-1]==s3a[i-1]; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= s2a.length && s2a[i-1]==s3a[i-1]; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= s1a.length; i++) {
            for (int j = 1; j <= s2a.length; j++) {
                dp[i][j] = dp[i-1][j]&&s1a[i-1]==s3a[i+j-1] || dp[i][j-1]&&s2a[j-1]==s3a[i+j-1];
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        isInterleave("aabcc","dbbca","aadbbcbcac"
        );
    }
}
