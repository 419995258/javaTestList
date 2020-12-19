package leecode.norm;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 题目数据保证答案肯定是一个 32 位的整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 *
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 *
 * 输入：s = "0"
 * 输出：0
 * 示例 4：
 *
 * 输入：s = "1"
 * 输出：1
 * 示例 5：
 *
 * 输入：s = "2"
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 *
 * 来源：力扣（LeetCode）1
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 解码方法91xdf {

    public static void main(String[] args) {
        numDecodings("12345");

    }


    /**
     * 执行用时：
     * 1 ms, 在所有 Java 提交中击败了99.96%的用户
     * 内存消耗：
     * 36.6 MB, 在所有 Java 提交中击败了81.65%的用户
     *
     *
     *
     */
    public static int numDecodings(String s) {
        // 如果为0则肯定为0，或者开头为0
        if(s.charAt(0) == '0'){
            return 0;
        }
        // 如果是一个字符只有一种解法
        if(s.length() == 1){
            return 1;
        }
        // 如果是多个字符 >=2 ：
        // 以2位数字举例，11,22等2种解题结果，以0结尾并且小于30只有1种，大于30就是0了
        int val1 = 1; // 前两位
        int val2 = 1; // 前一位
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            int now = val2;

            if(chars[i] == '0') {
                // 如果当前数字是0
                if(chars[i-1] == '1' || chars[i-1] == '2'){
                    // 如10这种情况是不增加解答数量的，取val1 前两位的值
                    now = val1;
                }else{
                    // 不是1和2开头直接就超过26了，无解
                    return 0;
                }
            }else if(chars[i-1] == '1' || (chars[i-1] == '2' && chars[i] < '7')){
                // 当前数字和前一位组成的数字不能大于26
                now = now + val1; // 当前的值是前面的聚合

            }
            val1 = val2;
            val2 = now;

        }
        return val2;
    }

    public static int numDecodings2(String s) {
        if(s.charAt(0) == '0') {
            //说明无解
            return 0;
        }
        char[] charArray = s.toCharArray();
        int last_2 = 1, last_1 = 1;  //last_2 代表i-2  last_1 代表i-1 temp 代表当前
        for(int i=1; i<s.length(); i++) {
            int temp = last_1;

            if(charArray[i] == '0') {
                if(charArray[i-1] == '1' || charArray[i-1] == '2') {
                    temp = last_2;
                }else {
                    return 0;
                }
            }else if( charArray[i-1] == '1' || (charArray[i-1] == '2' && charArray[i] - '0'>0 && charArray[i] - '0'<7)) {
                temp += last_2;
            }
            last_2 = last_1;
            last_1 = temp;
        }
        return last_1;
    }

    public static int numDecodings3(String s) {
        if(s.charAt(0)=='0'){
            return 0;
        }
        int [] dp = new int [s.length()+1];//长度为n时，的排列组合种类
        dp[0] = 1;
        dp[1] = 1;
        if(s.length()==1)   return dp[1];
        for(int i=2;i<=s.length();i++){
            int num = Integer.valueOf(String.valueOf(s.charAt(i-1)));//得到当前数；
            int nums2 = Integer.valueOf(String.valueOf(s.charAt(i-2)));//得到当前数的前一个数
            if (nums2+num==0||(num==0&&nums2>2)){
                return 0;
            }else if(num==0||nums2==0){
                dp[i] = num==0?dp[i-2]:dp[i-1];
            }else{
                dp[i] = nums2*10+num>26?dp[i-1]:dp[i-2]+dp[i-1];
            }

        }
        return dp[s.length()];
    }
}
