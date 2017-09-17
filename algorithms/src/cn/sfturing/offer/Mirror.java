package cn.sfturing.offer;


import cn.sfturing.entity.TreeNode;

import java.util.Stack;

/**
 * Created by Shi Xiaohao on 2017/9/17 下午9:15.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * 镜像二叉树
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 */
public class Mirror {
    /**
     * @ClassName:Mirror
     * @Description:利用递归的思路，解决问题。 运行时间：18ms，占用内存：8792k
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/17 下午9:19
     */
    public void mirror(TreeNode root) {
        TreeNode tem = null;
        //判断是否为空
        if (root == null) {
            return;
        }
        if (root.left != null || root.right != null) {
            mirror(root.left);
            mirror(root.right);
            //交换左右孩子
            tem = root.left;
            root.left = root.right;
            root.right = tem;

        }
    }


    /**
     * @ClassName:Mirror
     * @Description:非递归，使用栈解决。运行时间：20ms，占用内存：8792k 相对于来说递归用的时间少点
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/17 下午9:47
     */
    public void mirror1(TreeNode root) {
        //初始化交换节点和栈
        TreeNode tem = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return;
        }
        //pop根节点
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            //如果根节点左右孩子非空，交换左右孩子。
            if (node.left != null || node.right != null) {
                tem = node.left;
                node.left = node.right;
                node.right = tem;
            }
            //将左右节点压入栈中
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }

        }

    }

}
