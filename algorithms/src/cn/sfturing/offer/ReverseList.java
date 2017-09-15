package cn.sfturing.offer;

import cn.sfturing.entity.ListNode;

/**
 * 15.输入一个链表，反转链表后，输出链表的所有元素。
 * Created by Shi Xiaohao on 2017/9/15 下午2:41.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */
public class ReverseList {
    /**
     * @ClassName:ReverseList
     * @Description:反转链表思路：  建立next和pre指针。循环遍历链表（1.将当前节点next赋予「next指针」，更改当前节点next的为「pre指针」，重新定义pre为当前节点，
     * 当前节点变为「next节点」），重复操作。）
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/15 下午4:33
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        //判断非空
        if (head == null) {
            return null;
        }
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
