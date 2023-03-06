package com.cryon.dynamicprogramming;

/**
 * @author iimer
 * @description 给你一个字符串 s ，它仅包含字符 'a' 和 'b'​​​​ 。
 *
 *              你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，
 *              且 s[i] = 'b' 的同时 s[j]= 'a' ，此时认为 s 是 平衡 的。
 *
 *              请你返回使 s 平衡 的 最少 删除次数。
 * @date 2023-03-06 10:35:01
 */
public class 使字符串平衡的最少删除次数1653 {
    /**
     * 分析：
     * 判断遍历时当前的字符是'a'还是'b'
     * (1)'b':最少删除次数=上一个位置的最少删除次数=i
     * (2)'a':
     *      (1)不删除当前字符，最少删除次数：前面的b的总数
     *      (2)删除当前字符，i+1
     *      取两者最小值，即为当前位置的最少删除次数
     * 初始化:因为只需要借助上一个位置的最少删除次数，所以得到0坐标的就可以，最少删除次数为0
     */
    public int minimumDeletions(String s) {
        if (s.length()<=1) {
            return 0;
        }
        int[] bNum = new int[s.length()];
        int[] lastMin = new int[s.length()];
        lastMin[0] = 0;
        bNum[0] = s.charAt(0) == 'b'?1:0;
        for (int i = 1; i < s.length(); i++) {
            if ('a' == s.charAt(i)) {
                lastMin[i] = Math.min(lastMin[i-1] + 1,bNum[i-1]);
                bNum[i] = bNum[i-1];
            } else {
                lastMin[i] = lastMin[i-1];
                bNum[i] = bNum[i-1] + 1;
            }
        }
        return lastMin[s.length()-1];
    }

    /**
     * 代码优化
     */
    public int minimumDeletionsOp(String s) {
        int bNum = 0;
        int lastMin = 0;
        for (char c : s.toCharArray()) {
            if ('a' == c) lastMin = Math.min(lastMin + 1,bNum);
            else bNum+=1;
        }
        return lastMin;
    }
}
