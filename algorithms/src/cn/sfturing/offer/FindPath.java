package cn.sfturing.offer;

/**
 * Created by Shi Xiaohao on 2017/9/19 下午5:06.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */


import cn.sfturing.entity.TreeNode;


import java.util.ArrayList;

/**
 * 24.输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPath {
    /**
     * @ClassName:FindPath
     * @Description:需要递归调用。完成算法。运行时间：20ms,占用内存：8792k
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/19 下午7:47
     */
    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {

        //初始化list容器和list
        ArrayList<Integer> arrayListInt = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        int currentSum = 0;
        //用不到判断非空
        findPath(root, target, currentSum, arrayListInt, arrayLists);
        return arrayLists;

    }

    public static void findPath(TreeNode root, int target, int currenSum, ArrayList<Integer> arrayListInt, ArrayList<ArrayList<Integer>> arrayLists) {
        if (root == null) {
            return;
        }
        currenSum += root.val;
        arrayListInt.add(root.val);
        if (root.right == null && root.left == null) {
            if (target == currenSum) {
                ArrayList<Integer> arr= new ArrayList<>();
                arr=(ArrayList<Integer>) arrayListInt.clone();
                arrayLists.add(arr);
            }
        }
        if (root.left != null) {
            findPath(root.left, target, currenSum, arrayListInt, arrayLists);
        }
        if (root.right != null) {
            findPath(root.right, target, currenSum, arrayListInt, arrayLists);
        }
        arrayListInt.remove(arrayListInt.size() - 1);

    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(10);
        TreeNode root2 = new TreeNode(5);
        TreeNode root3 = new TreeNode(12);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(7);
        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        System.out.println(FindPath.findPath(root1,22));
    }


}
