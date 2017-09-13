package cn.sfturing;

import cn.sfturing.entity.TreeNode;

/**
 * Created by Shi Xiaohao on 2017/9/10 下午5:19.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */
public class Test {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        // 遍历得到结果
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);

    }

    public TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        //判断是否为合理
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (pre[startPre] == in[i]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
            }
        }

        return root;
    }
}
