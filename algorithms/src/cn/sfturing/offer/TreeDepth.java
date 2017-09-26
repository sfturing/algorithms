package cn.sfturing.offer;

/**
 * Created by Shi Xiaohao on 2017/9/26 下午3:00.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */

import cn.sfturing.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 38.二叉树的深度：输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepth {

    /**
     * @ClassName:TreeDepth
     * @Description:利用遍历得到树的深度。运行时间：14m,占用内存：8404k
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/26 下午4:12
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int right = TreeDepth(root.right);
        int left = TreeDepth(root.left);
        return Math.max(right, left) + 1;

    }

    /**
     * @ClassName:TreeDepth
     * @Description:非递归算法，利用层次遍历,运行时间：13ms,占用内存：8252k
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/26 下午4:31
     */
    public int TreeDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //初始化队列容器，初始化深度数量。
        int depth = 0;
        int count = 0;
        int nextCounet = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currendNode = queue.poll();
            count++;
            if (currendNode.left != null) {
                queue.offer(currendNode.left);
            }
            if (currendNode.right != null) {
                queue.offer(currendNode.right);
            }
            if (count == nextCounet) {
                depth++;
                count = 0;
                nextCounet = queue.size();

            }

        }
        return depth;
    }


}
