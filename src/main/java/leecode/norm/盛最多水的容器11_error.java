package leecode.norm;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 * 示例 3：
 *
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * 示例 4：
 *
 * 输入：height = [1,2,1]
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 盛最多水的容器11_error {


    public static void main(String[] args) {
        maxArea(new int[]{});

    }


    public static int maxArea(int[] height) {
        Integer max = 0;

        // 找出最大和第二大的值以及对应的下标
        int index1 = 0;
        int index2 = 0;
        int max1 = 0;
        int max2 = 0;
        for (int i = 0,len = height.length; i < len; i++) {
            if(height[i] > max1){
                max1 = height[i];
            }
            if(height[i] > max2){
                max2 = height[i];
            }
            
        }
        


        return max;
    }

}
