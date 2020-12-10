package leecode.norm;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class 最长回文子串5 {
    public static void main(String[] args) {
        String str = "babad";
        Map<Character,Integer> m = new HashMap<>();
        Integer left = 0;
        Integer len = 0;
        if(str.length() < 2){

        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(m.containsKey(c)){
                // 存在了
                if(i+1-m.get(c) > len){
                   len =  i+1-m.get(c);
                   left = m.get(c);
                }

            }else{
                // 不存在
                m.put(c,i);
            }
        }
        System.out.println(str.substring(left,left + len));

    }
}
