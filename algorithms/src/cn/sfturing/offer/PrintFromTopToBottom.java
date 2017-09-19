package cn.sfturing.offer;

import cn.sfturing.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shi Xiaohao on 2017/9/19 上午9:22.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */


/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom {
    /**
     * @ClassName:PrintFromTopToBottom
     * @Description:通过队列来实现层次遍历。运行时间：15ms 占用内存：8404k
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/19 上午9:23
     */
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //初始化队列和list
        Queue<TreeNode> queue =new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        //判断非空
        if (root == null){
            return arrayList;
        }
        //将跟节点添加到队列中
        queue.offer(root);
        while (!queue.isEmpty()){
            //取出队列的一个元素
            TreeNode node = queue.poll();
            //判断该节点的左右节点，如果存在，offer给队列
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
            arrayList.add(node.val);
        }

        return arrayList;
    }


}
