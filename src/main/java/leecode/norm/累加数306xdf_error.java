package leecode.norm;


import org.apache.commons.lang3.StringUtils;

/**
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 *
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 *
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 *
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 *
 * 示例 1:
 *
 * 输入: "112358"
 * 输出: true
 * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 示例 2:
 *
 * 输入: "199100199"
 * 输出: true
 * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 * 进阶:
 * 你如何处理一个溢出的过大的整数输入?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/additive-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/additive-number/solution/java-hui-su-by-jio-deng/
 * https://leetcode-cn.com/problems/additive-number/solution/hui-su-bao-li-qiu-jie-by-haha123-3/
 * https://leetcode-cn.com/problems/additive-number/solution/bu-yong-di-gui-zhi-jie-zhao-by-ljjack/
 */
public class 累加数306xdf_error {


    public static void main(String[] args) {
        System.out.println(isAdditiveNumber("112358"));

    }

    public static boolean isAdditiveNumber(String num) {
        // 1.临界值判断
        if(StringUtils.isBlank(num)){
            return false;
        }
        if(num.length() <= 3){
            return false;
        }
        char[] ch = num.toCharArray();
        // 初始值为0直接false
        if(ch[0]=='0'){
            return false;
        }


        long nowValue = 0;
        long sumValue = 0;
        int nowIndex = 0;
        for (int i = nowIndex,len=ch.length; i < len; i++) {
            for (int j = i +1 ; j < len; j++) {
                //

            }


        }



        return false;
    }
}
