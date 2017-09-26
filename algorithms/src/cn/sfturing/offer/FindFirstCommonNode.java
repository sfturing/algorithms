package cn.sfturing.offer;

/**
 * Created by Shi Xiaohao on 2017/9/26 上午10:16.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */


import cn.sfturing.entity.ListNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 36.输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {

    /**
     * @ClassName: FindFirstCommonNode
     * @Description: 运行时间：26ms,占用内存：8916k  方法为遍历链表，将链表放入hashSet 中，遍历找到第一个重复的节点。
     * @Author: Shi Xiaohao
     * @E-mail： sfturing@gmail.com
     * @Date :2017/9/26 上午10:40
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //初始化节点
        ListNode currentNode1 = pHead1;
        ListNode currentNode2 = pHead2;
        //HashMap<ListNode,String> hashMap= new HashMap<>();
        //初始化容器
        HashSet<ListNode> hashSet = new HashSet<>();
        //将链表一所有节点放入容器
        while (currentNode1 != null){
            hashSet.add(currentNode1);
            currentNode1 = currentNode1.next;
        }
        //判断是否有公共节点，找到之后return
        while (currentNode2 != null){
            if (hashSet.contains(currentNode2)){
                return currentNode2;
            }
            currentNode2 = currentNode2.next;
        }
        return null;
    }
    /**
     * 另一个方法，可以比较两个链表的长度差，遍历到两个链表长度相等，最后齐头并进，找到相同的结点。
     */
}
