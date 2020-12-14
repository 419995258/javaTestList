package leecode.norm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
 *
 * 返回 A 的任意排列，使其相对于 B 的优势最大化。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [2,7,11,15], B = [1,10,4,11]
 * 输出：[2,11,7,15]
 * 示例 2：
 *
 * 输入：A = [12,24,8,32], B = [13,25,32,11]
 * 输出：[24,32,8,12]
 *  
 *
 * 提示：
 *
 * 1 <= A.length = B.length <= 10000
 * 0 <= A[i] <= 10^9
 * 0 <= B[i] <= 10^9
 *
 * 来源：力扣（LeetCode）1
 * 链接：https://leetcode-cn.com/problems/advantage-shuffle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 优势洗牌870xdf {
    public static void main(String[] args) {
        int[] A = new int[]{2,3,5,4};
        int[] B = new int[]{4,1,3,2};
        advantageCount(A,B);
    }


    private static int[] advantageCount(int[] a, int[] b) {
        int n = b.length;
        Arrays.sort(a);
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i ++){
            pair[i] = new int[]{b[i], i};//把下标保存下来
        }
        Arrays.sort(pair, (x, y)->x[0] - y[0]);

        int[] res = new int[n];
        //r最大值，l标明最小值；
        for (int i = 0, r = n - 1, l = 0; i < n; i ++){
            if (a[i] <= pair[l][0]) {
                res[pair[r --][1]] = a[i];//要放到原数组对应的位置上
            } else {
                res[pair[l ++][1]] = a[i];////要放到原数组对应的位置上
            }
        }
        return res;
    }


    private static int[] advantageCount2(int[] A, int[] B) {
        int[] c = new int[4];

        for (int i = 0; i < B.length; i++) {
            int b = B[i];
            int chazhi = 0;
            int index = 0;

            List<Integer> AList = new ArrayList();
            for (int i1 : A) {
                AList.add(i1);
            }
            // 获取最小差值的下标
            for (int j = 0; j < AList.size(); j++) {
                int a = (int) AList.get(j);
                if(a > b){
                    if(chazhi == 0){
                        chazhi = a-b;
                        index = j;
                    }else{
                        if(a-b < chazhi){
                            chazhi = a-b;
                            index = j;
                        }
                    }
                }
            }

            // 赋值
            c[i] = AList.get(index);
            // 删除AList
            AList.remove(index);
        }

        System.out.println(c.toString());
        return c;
    }


}
