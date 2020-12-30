package leecode.norm;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 */
public class 跳跃游戏55xdf {

    public static void main(String[] args) {
        int[] num = {3,2,1,0,4};
        System.out.println(canJump(num));


    }


    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了81.10%的用户
     * 内存消耗：40.5 MB, 在所有 Java 提交中击败了48.29%的用户
     *
     * 可以求最大能抵达的位置，如果大于最后一位，则成功。
     * 计算每个下标+当前位置的最大步长，就可以计算出当前位置最远抵达的位置，1
     * 但是在计算前，需要判断当前下标需要小于等于最大值，如3,2,1,0,4在下标4的地方最大值还是3，很明显是不能继续执行的。
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0,len = nums.length; i < len; i++) {
            if(max >= i){
                max = Math.max(max,i + nums[i]);
                // 如果最大值已经能够抵达最后一位下标了，直接返回true
                if(max >= len-1){
                    return true;
                }
            }
        }
        return false;
    }
}
