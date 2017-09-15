package cn.sfturing.offer;

import cn.sfturing.entity.ListNode;

/**
 * 14.输入一个链表，输出该链表中倒数第k个结点。
 * Created by Shi Xiaohao on 2017/9/15 上午11:49.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */
public class FindKthToTail {

    /**
     * @ClassName:FindKthToTail 在牛客网看到的解题思路  链接：https://www.nowcoder.com/questionTerminal/529d3ae5a407492994ad2a246518148a
     * @Description: 代码思路如下：两个指针，先让第一个指针和第二个指针都指向头结点，然后再让第一个指正走(k-1)步，
     * 到达第k个节点。然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了。
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/15 下午2:24
     */
    public ListNode findKthToTail(ListNode head, int k) {
        //初始化两个指针
        ListNode pre = head;
        ListNode last = head;
        //判断是否为空链表或者k值小于0
        if (head == null || k <= 0) {
            return null;
        }
        //找到第k个点。移动k-1步,得到k的距离
        for (int i = 0; i < k - 1; i++) {
            if (pre.next != null) {
                pre = pre.next;
            } else {
                return null;
            }
        }
        //两个指针同时移动，当pre指针到达尾部时，last节点为倒数k个节点。
        while (pre.next != null) {
            pre = pre.next;
            last = last.next;
        }

        return last;
    }
}
