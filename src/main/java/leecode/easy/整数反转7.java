package leecode.easy;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 *
 * https://leetcode-cn.com/problems/reverse-integer/
 * 解析：
 * 思路一：转换成str,字符串倒拼
 * 思路二：获取每个位数的值。
 *
 */
public class 整数反转7 {


    public static void main(String[] args) {
        Integer i = 150;
        String s = i + "";
        String ss = "";
        for (int j = s.length(); j > 0; j--) {
            ss = ss + s.charAt(j);
        }
    }



}
