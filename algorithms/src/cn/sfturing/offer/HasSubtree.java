package cn.sfturing.offer;

import cn.sfturing.entity.TreeNode;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * Created by Shi Xiaohao on 2017/9/16 下午11:21.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */
public class HasSubtree {
    /**
     * @ClassName:HasSubtree
     * @Description:要查找树A中是否存在和树B结构一样的子树，可以分成两步： 第一步在树A中找到和B的根节点的值一样的结点R；
     * 第二步再判断树A中以R为根结点的子树是不是包含和树B一样的结构。
     * 第一步在树A中查找与根结点的值一样的结点，这实际上就是树的遍历。递归调用HasSubTree遍历二叉树A。
     * 如果发现某一结点的值和树B的头结点的值相同，则调用DoesTreeHavaTree2，做第二步判断。
     * 第二步是判断树A中以R为根结点的子树是不是和树B具有相同的结构。
     * <p>
     * 利用递归的想法，去解决这个问题，清晰明白。
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/16 下午11:21
     */
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //判断跟节点是否为空
        if (root1 != null && root2 != null) {
            //第一步，遍历寻找树A与树B根节点相同的节点
            if (root1.val == root2.val) {
                result = doesTree1HaveTree2(root1, root2);
            }
            //判断左子数是否有相同的节点
            if (!result) {
                result = hasSubtree(root1.left, root2);
            }
            //判断右子数是否有相同的节点
            if (!result) {
                result = hasSubtree(root1.right, root2);
            }

        }

        return result;
    }

    public boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        //如果B树遍历结束，证明是A树的子结构
        if (node2 == null) {
            return true;
        }
        //如果A树先结束，返回false
        if (node1 == null) {
            return false;
        }
        //如果两个值不相同，证明不是子结构，返回false
        if (node1.val != node2.val) {
            return false;
        }
        return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
    }
}


