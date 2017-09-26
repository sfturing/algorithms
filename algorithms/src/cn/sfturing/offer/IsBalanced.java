package cn.sfturing.offer;

/**
 * Created by Shi Xiaohao on 2017/9/26 下午8:06.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */


import cn.sfturing.entity.TreeNode;

/**
 * 39.输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalanced {

    boolean isBanlanced = true;
    /**
     * @ClassName:IsBalanced
     * @Description:运行时间：14ms 占用内存：8392km  递归算法。
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/26 下午8:21
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null){
            return true;
        }
        depthTree(root);
        return isBanlanced;


    }
    /**
     * @ClassName:IsBalanced
     * @Description:判断二叉树深度
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/26 下午8:07
     */
    public int depthTree(TreeNode node){
        if (node == null){
            return 0;
        }
        //左右子数的深度
        int left = depthTree(node.left);
        int right = depthTree(node.right);
        if (Math.abs(left - right) > 1) {
            isBanlanced = false;
        }
        return Math.max(left,right) + 1;
    }
}
