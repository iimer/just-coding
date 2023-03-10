package com.cryon.base.math;

/**
 * @author iimer
 * @description 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。
 *              如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。
 * @date 2023-03-02 19:32:47
 */
public class 二进制数转字符串面试题05_02 {
    /**
     * 原解法
     * @param num
     * @return
     */
    public String printBin(double num) {
        StringBuilder res = new StringBuilder();
        while(res.length() < 30 && num != 0) {
            num = num*2;
            if (num>1) {
                res.append(1);
                num = num - 1;
            } else {
                res.append(0);
            }
        }
        if (res.length() == 30 && num != 0) {
            return "error";
        }
        return res.toString();
    }

    //数学总结：只需要k次遍历，k为小数最大位数
}
