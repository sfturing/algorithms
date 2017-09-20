package cn.sfturing.offer;

import cn.sfturing.entity.RandomListNode;

/**
 * Created by Shi Xiaohao on 2017/9/20 上午9:20.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */

/**
 * 25.输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Clone {
    /**
     * @ClassName:Clone
     * @Description:看讨论区的算法，可以分为3步算法。这也是剑指offer书上的思路.运行时间：24ms占用内存：8664k
     * 可以查看算法解析的图片：http://sfturing.cn/upload/2017/09/72900d3ne8h2tpjn7h7i42ogp9.png
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/20 上午9:59
     */
    public static RandomListNode Clone(RandomListNode pHead) {
        cloneNode(pHead);
        cloneRandomNode(pHead);
        return ReconnectNode(pHead);
    }
    /**
     * @ClassName:Clone
     * @Description:第一步：新建链表的副本  A->B->C   变为A->A`->B->B`->C->C`
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/20 上午11:02
     */
    public static void cloneNode(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode pHeadCopy = new RandomListNode(pNode.label);
            pHeadCopy.next = pNode.next;
            pNode.next = pHeadCopy;
            pNode = pHeadCopy.next;

        }

    }
    /**
     * @ClassName:Clone
     * @Description:第二步：为副本的random赋值。
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/20 上午11:12
     */
    public static void cloneRandomNode(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode pNodeCopy = pNode.next;
            if (pNode.random != null) {
                pNodeCopy.random = pNode.random.next;
            }
            pNode = pNodeCopy.next;
        }

    }
    /**
     * @ClassName:Clone
     * @Description:第三步：将整体链表拆分。分为原链表和copy链表
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/20 上午11:13
     */
    public static RandomListNode ReconnectNode(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        RandomListNode pHeadCopy = null;
        RandomListNode pNodeCopy = null;
        if (pNode != null) {
            pHeadCopy = pNodeCopy = pNode.next;
            pNode.next = pNodeCopy.next;
            pNode = pNode.next;

        }
        while (pNode != null) {
            pNodeCopy.next = pNode.next;
            pNodeCopy = pNodeCopy.next;
            pNode.next = pNodeCopy.next;
            pNode = pNode.next;

        }

        return pHeadCopy;
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);

        RandomListNode node2 = new RandomListNode(2);


        RandomListNode node3 = new RandomListNode(3);


        RandomListNode node4 = new RandomListNode(4);


        RandomListNode node5 = new RandomListNode(5);


        head.next = node2;
        head.random = node3;

        node2.next = node3;
        node2.random = node5;

        node3.next = node4;

        node4.next = node5;
        node4.random = node2;
        System.out.println(Clone.Clone(head));

    }
}
