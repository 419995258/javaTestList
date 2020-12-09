package leecode.norm;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 把所有的字符串给拆解排序
 *  作者：LeetCode
 *     链接：https://leetcode-cn.com/problems/group-anagrams/solution/zi-mu-yi-wei-ci-fen-zu-by-leetcode/
 *     来源：力扣（LeetCode）
 *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class 字母异位词分组49 {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Map<String,Object> m = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String str : strs) {
            // 字符串转换
            char[] c = str.toCharArray();
            // 排序，从小到大排序
            Arrays.sort(c);
            // 转换成字符串
            String k = String.valueOf(c);

            // map取值赋值
            if(m.get(k) == null){
                list = new ArrayList<>();
            }else{
                list = (List<String>) m.get(k);
            }
            list.add(str);
            m.put(k,list);
        }
        System.out.println(m.toString());
        System.out.println(new ArrayList<>(m.values()));

    }



}
