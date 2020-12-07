package leecode.easy;

import java.util.Stack;

/**
 *用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路是：
 * 第一个in栈只添加，还有个栈只有在删除时才使用，如果需要删除，就把in栈全部倒入out栈，然后pop第一个值就是删除头部的数据了
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/solution/mian-shi-ti-09-yong-liang-ge-zhan-shi-xian-dui-l-3/
 *
 *
 *
 */
public class 用两个栈实现队列 {

    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        // 如果第二个栈为空
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        if (outStack.isEmpty()) {
            return -1;
        } else {
            int deleteItem = outStack.pop();
            return deleteItem;
        }
    }


}
