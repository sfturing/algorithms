package cn.sfturing.offer;

/**
 * Created by Shi Xiaohao on 2017/9/18 下午9:06.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */

import java.util.Stack;

/**
 * 21.输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class IsPopOrder {
    /**
     * @ClassName:IsPopOrder
     * @Description:利用辅助栈来解决这个问题。我认为要想解决是否满足出栈顺序，那么入栈之后能出栈才是最必要的。运行时间：15ms ,占用内存：8372k。
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/19 上午9:06
     */
    public boolean isPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        //初始化出栈顺序指针，初始值指向popA[0]
        int pointValue = 0;
        if (pushA.length == 0 ||popA.length == 0){
            return false;
        }
        //根据入栈顺序压入辅助栈
        for (int i = 0; i < popA.length; i++) {
            stack.push(pushA[i]);
            //判断与指针指向的popA是否相同，如果相同，说明出栈，弹出这个值。
            while(!stack.empty() && stack.peek() == popA[pointValue]){
                stack.pop();
                pointValue ++;
            }
        }
       if (stack.empty()){
            return true;
       }else{
           return false;
       }
    }
}
