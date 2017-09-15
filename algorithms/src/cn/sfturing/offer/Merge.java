package cn.sfturing.offer;

import cn.sfturing.entity.ListNode;

/**
 * 16. 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * Created by Shi Xiaohao on 2017/9/15 下午4:49.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */
public class Merge {

    /**
     * @ClassName:Merge
     * @Description:非递归实现，在牛客网上比较递归与非递归的运算时间和占用内存，发现差异不是很大。  这种题，应该在脑海中建立内存模型。不能搞混了。
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/15 下午10:08
     */
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode current = null;
        ListNode mergeNode = null;
        //非空判断
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        //遍历比较两个链表，比较大小并改变顺序，直至有一个链表为空。
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (mergeNode != null) {
                    current.next = list1;
                    current = current.next;
                } else {
                    mergeNode = current = list1;
                }
                list1 = list1.next;
            } else {
                if (mergeNode != null) {
                    current.next = list2;
                    current = current.next;
                } else {
                    mergeNode = current = list2;
                }
                list2 = list2.next;
            }

        }
        if (list1 == null) {
            current.next = list2;
        } else {
            current.next = list1;
        }
        return mergeNode;
    }

    /**
     * @ClassName:Merge
     * @Description:递归实现
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/15 下午10:38
     */
    public ListNode merge1(ListNode list1, ListNode list2) {
        //非空判断
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        //
        if (list1.val <= list2.val) {
            list1.next = merge(list1.next, list2);
            return list1;

        } else {
            list2.next = merge(list1, list2.next);
            return list2;
        }

    }
}
