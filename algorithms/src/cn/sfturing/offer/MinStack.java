package cn.sfturing.offer;

import java.util.Stack;
/**
 * Created by Shi Xiaohao on 2017/9/18 上午9:46.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */

/**
 * 实现一个栈，能够得到栈最小元素的min函数，要求复杂度为O（1）,相当于用了一个辅助栈。
 */
public class MinStack {
    Stack<Integer> data = new Stack<Integer>();
    //初始化最小值栈。data值入栈时，比较是否为minData栈的最小值，如果是入栈。
    Stack<Integer> minData = new Stack<Integer>();
    //minData的最小值缓存
    Integer tem = null;

    //入栈函数
    public void push(int node) {
        if (tem != null) {
            if (node <= tem) {
                tem = node;
                minData.push(node);
            }
            data.push(node);
        } else {
            //第一次入栈，为tem赋值
            tem = node;
            data.push(node);
            minData.push(node);
        }

    }

    public void pop() {
        if (data.peek() != minData.peek()){
           data.pop();
        }else {
            data.pop();
            minData.pop();
        }


    }

    public int top() {
        if (!data.empty()) {
            return data.peek();
        }
        return Integer.MIN_VALUE;
    }

    public int min() {
        if (!minData.empty()) {
            return minData.peek();
        }
        return Integer.MIN_VALUE;
    }

}

