package cn.sfturing.offer;

import cn.sfturing.entity.TreeNode;

import java.util.Stack;

/**
 * Created by Shi Xiaohao on 2017/9/20 上午11:25.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Convert {
    /**
     * @ClassName:Convert
     * @Description: 树的左节点指向小于自己的节点，右节点指向大于自己的节点。非递归解决。运行时间：13ms,占用内存：8276k
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/20 上午11:25
     */
    public static TreeNode Convert(TreeNode pRootOfTree) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = pRootOfTree;
        //初始化前节点
        TreeNode pre = null;
        //初始化是否是第一个节点
        boolean isFirst = true;
        //判断非空
        if (pRootOfTree == null) {
            return null;
        }
        //中序遍历线索树
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                // 将当前结点入栈
                stack.push(currentNode);
                // 设置当前结点为当前结点的左孩子
                currentNode = currentNode.left;
            }
            if (!stack.empty()) {
                currentNode = stack.pop();
                if (!isFirst) {
                    //设置前置节点的右孩子为当前节点
                    pre.right = currentNode;
                    //当前节点的左孩子为前置节点
                    currentNode.left = pre;
                    //设置前置节点为当前节点
                    pre = currentNode;

                } else {
                    //初始化root节点
                    pRootOfTree = currentNode;
                    //设置前置节点
                    pre = pRootOfTree;
                    //关闭是否是第一个节点的判断
                    isFirst = false;
                }
                currentNode = currentNode.right;
            }
        }
        return pRootOfTree;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(5);
        TreeNode root3 = new TreeNode(1);
        TreeNode root4 = new TreeNode(2);
        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        Convert.Convert(root);

    }
}
