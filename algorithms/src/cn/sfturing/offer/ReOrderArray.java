package cn.sfturing.offer;


import java.util.Arrays;
import java.util.Vector;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * Created by Shi Xiaohao on 2017/9/14 下午11:18.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */
public class ReOrderArray {
    /**
     * @ClassName:ReOrderArray
     * @Description:空间换时间的算法，时间复杂度为O（n）
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/14 下午11:20
     */
    public static void reOrderArray(int[] array) {
        //初始化自增长数组
        Vector<Integer> arrCopy = new Vector<Integer>();
        if (array == null) {
            return;
        }
        //遍历一遍数组，取出奇数放入
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                arrCopy.add(array[i]);
            }
        }
        //遍历一遍数组，取出偶数放入
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                arrCopy.add(array[i]);
            }
        }
        //遍历一遍数组，覆盖原有的数组
        for (int i = 0; i < array.length; i++) {
            array[i] = arrCopy.get(i);
        }
        System.out.println(Arrays.toString(array));

    }
    /**
     * @ClassName:ReOrderArray
     * @Description:另一种解题思路，遍历数组，碰到偶数，从数组中取出，后面的所有值向前移动，偶数插入到末尾。时间复杂度为O（n^2）.
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/15 上午12:02
     */
    public static void reOrderArray1(int[] array){

    }

    public static void reOrderArray2(int[] array){

    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5, 6, 9, 8};
        ReOrderArray.reOrderArray(arr);
    }
}
