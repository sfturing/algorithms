package cn.sfturing;

import cn.sfturing.entity.RandomListNode;
import cn.sfturing.entity.TreeNode;
import cn.sfturing.offer.Clone;

import java.util.Stack;

/**
 * Created by Shi Xiaohao on 2017/9/10 下午5:19.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */
public class Test {

    public static RandomListNode Clone(RandomListNode pHead) {
        cloneNode(pHead);
        return pHead;
    }

    public static void cloneNode(RandomListNode pHead) {
        while (pHead != null) {
            RandomListNode pHeadCopy = new RandomListNode(pHead.label);
            pHeadCopy.next = pHead.next;
            pHead.next = pHeadCopy;
            pHead = pHeadCopy.next;

        }

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
        System.out.println(Test.Clone(head).label);
    }

}

