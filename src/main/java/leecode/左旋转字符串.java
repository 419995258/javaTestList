package leecode;

public class 左旋转字符串 {

    /**
     * 题目：
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     *
     * 示例 1：
     *
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     * 示例 2：
     *
     * 输入: s = "lrloseumgh", k = 6
     * 输出: "umghlrlose"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     *
     *
     * 答案参考资料：
     * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/solution/mian-shi-ti-58-ii-zuo-xuan-zhuan-zi-fu-chuan-qie-p/
     * @param args
     */
    public static void main(String[] args) {
        String s = "abcdef";
        Integer n = 2;
        // 1.拼接字符串
        String s1 = s.substring(0,n);
        String s2 = s.substring(n,s.length());
        String s3 = s2 + s1;
        System.out.println(s3);

        // 2.切割成list
        StringBuffer sb = new StringBuffer("");
        for(int i = n; i < s.length(); i++){
            sb.append(s.charAt(i));
            /** 大牛的做法：通过取余运算计算一次循环就可以，不用下面的循环
             *  s.charAt(i % s.length());
             */

        }
        for(int i = 0; i < n; i++){
            sb.append(s.charAt(i));
        }

        System.out.println(sb);
    }
}
