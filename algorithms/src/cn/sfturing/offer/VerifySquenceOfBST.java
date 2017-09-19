package cn.sfturing.offer;

/**
 * Created by Shi Xiaohao on 2017/9/19 上午10:41.
 * E-mail:sfturing@gamil.com
 * version:1.0
 * <p>
 */

/**
 * 二叉搜索树：或者是一棵空树，或者具有如下性质：对树中任一节点X，它的左子树中的所有关键字节点的值都不大于（小于或等于）X的关键字值，
 * 而它的右子树中的所有关键字节点的值都大于X的关键字值。
 *
 *中序遍历二叉搜索树可得到一个关键字的有序序列，由小到大排序。
 *
 *在二叉搜索树中的插入、删除、搜索的复杂度等于树高，即(log(n))。
 *
 *在二叉搜索树中找最小节点和最大节点也很方面，如要找最小节点，只需从根节点开始，一直找左子树，当某个节点没有左子树时，该节点就是最小节点，即终止节点就是最小节点。同理，如果要找最大节点，那么从根节点开始一直找右子树即可，当某个节点没有右子树时，该节点就是最大节点。
 *
 *二叉树后序遍历的特点：最后一个节点肯定是根节点。
 *
 *二叉树先序遍历的特定：第一个节点肯定是根节点。
 */

/**
 * 题目23.输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。--假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
    /**
     * @ClassName:VerifySquenceOfBST
     * @Description:递归算法。运行时间：15ms，占用内存：8280k。很烦很烦。
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/19 上午10:41
     */
    public static boolean verifySquenceOfBST(int[] sequence) {

        if (sequence == null || sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }

        return verify(sequence, 0, sequence.length - 1);
    }

    public static boolean verify(int[] sequence, int start, int end) {
        //初始化左右子数的分界限
        if ( start>=end )
            return true;
        int root = sequence[end];
        int i = start;
        while (sequence[i] < root) {
            i++;
        }

        int j = i;
        while (j < end) {
            if (sequence[j] < root) {
                return false;
            }
            j++;
        }


        boolean left = verify(sequence, start, i - 1);
        boolean right = verify(sequence, i, end - 1);
        return left && right;


    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 6, 12, 16, 14, 10};
        System.out.println(VerifySquenceOfBST.verifySquenceOfBST(arr));
    }


}
