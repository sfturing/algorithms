package cn.sfturing.essenceofcomputing;

import cn.sfturing.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 计算之魂思考题2.3.Q2
 * 回旋打印二叉树的节点。
 * <p>
 * 修改二叉树的广度遍历算法，使得偶数行的节点从左向右遍历，奇数行的节点从右向左遍历。比如图1所示的二叉树，遍历的的顺序为1->2->3->6->5->4->7。
 */
public class CyclicBinaryTree {


    /**
     * 递归先序遍历
     *
     * @param node
     */
    public void preorderTraversal(TreeNode node) {
        if (node == null) return;
        System.out.println(node.val);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }


    /**
     * 根据层级的奇偶性，将每层的节点放入栈中。进行遍历。
     *
     * @param node
     */
    public void cyclicBinaryTree(TreeNode node) {
        if (node == null) return;
        int level = 0;
        // 存放树节点的栈
        Stack<TreeNode> storey = new Stack<>();
        storey.add(node);
        //  存放每层栈的队列
        Queue<Stack<TreeNode>> queue = new LinkedList<>();
        queue.add(storey);
        while (queue.size() > 0) {
            Stack<TreeNode> newstorey = new Stack<>();
            Stack<TreeNode> stack = queue.poll();
            while (stack != null && !stack.isEmpty()) {
                TreeNode treeNode = stack.pop();
                System.out.println(treeNode.val);
                if (level % 2 == 0) {
                    if (treeNode.right != null) newstorey.push(treeNode.right);
                    if (treeNode.left != null) newstorey.push(treeNode.left);
                } else {
                    if (treeNode.left != null) newstorey.push(treeNode.left);
                    if (treeNode.right != null) newstorey.push(treeNode.right);
                }
            }
            if (!newstorey.isEmpty()) {
                queue.add(newstorey);
            }
            level++;
        }


    }


    /**
     * test
     *
     * @param args
     */
    public static void main(String[] args) {
        CyclicBinaryTree cyclicBinaryTree = new CyclicBinaryTree();
        /**
         * 构建二叉树
         */
        TreeNode root7 = new TreeNode(7);
        TreeNode root6 = new TreeNode(6, null, root7);
        TreeNode root5 = new TreeNode(5);
        TreeNode root4 = new TreeNode(4);
        TreeNode root3 = new TreeNode(3, root6, null);
        TreeNode root2 = new TreeNode(2, root4, root5);
        TreeNode root = new TreeNode(1, root2, root3);
        cyclicBinaryTree.cyclicBinaryTree(root);
        //cyclicBinaryTree.preorderTraversal(root);
    }
}
