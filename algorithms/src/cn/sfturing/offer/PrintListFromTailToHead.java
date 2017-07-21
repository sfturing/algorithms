package cn.sfturing.offer;

import java.util.ArrayList;
import java.util.Stack;

import cn.sfturing.entity.ListNode;

/**
 * 3.输入一个链表，从尾到头打印链表每个节点的值。
 * @author sfturing
 *
 * @date 2017年7月21日
 */
public class PrintListFromTailToHead {
	
	/**
	 * 用栈的方法实现后先出，实现倒序输出。注意NPE的判断。
	 * @param listNode
	 * @return
	 */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	Stack<Integer> stack =new Stack<Integer>();
    	ArrayList<Integer> arrayList = new ArrayList<Integer>();
    	if(listNode != null){
    	do{
    		stack.push(listNode.val);
    		listNode = listNode.next;
    	}   
    	while(listNode != null);
    	}
    	
    	while (!stack.empty()) { 
            arrayList.add(stack.pop()); 
    } 
    	System.out.println(arrayList);
    		
		return arrayList;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintListFromTailToHead fromTailToHead = new PrintListFromTailToHead();
		ListNode listNode = null;
		fromTailToHead.printListFromTailToHead(listNode);

	}

}
 