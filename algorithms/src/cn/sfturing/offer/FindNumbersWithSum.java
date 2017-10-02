package cn.sfturing.offer;

/**
 * Created by Shi Xiaohao on 2017/9/28 上午12:14.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */

import java.util.ArrayList;

/**
 * 42.输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSum {

    /**
     * @ClassName:FindNumbersWithSum
     * @Description:运行时间：9ms,占用内存：8652k.设立头尾节点。第一对就是乘积最小的。
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/28 上午12:17
     */
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length < 2) {
            return list;
        }

        for (int i= 0; i < array.length; i++) {

            for (int j = array.length - 1; j > i;j--){
                if (array[i] + array[j] == sum){
                    list.add(array[i]);
                    list.add(array[j]);
                    return list;
                }
            }

        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = {};
        System.out.println(FindNumbersWithSum.FindNumbersWithSum(array,0));
    }
}
