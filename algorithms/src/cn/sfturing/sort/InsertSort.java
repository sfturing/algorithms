package cn.sfturing.sort;

import java.util.Arrays;

/**
 * Created by Shi Xiaohao on 2017/9/22 下午5:54.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */

/**
 *
 * 简单的直接插入排序
 */
public class InsertSort {

    /**
     * @ClassName:InsertSort
     * @Description:直接插入排序，时间复杂度为O（n）
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/22 下午6:26
     */
    public static String insertSort(int[] arry) {
        //判断非空
        if (arry.length == 0 || arry == null) {
            return null;
        }
        for (int i = 1; i < arry.length; i++) {

            if (arry[i] < arry[i - 1]) {
                //保存第i位的值
                int temp = arry[i];
                //初始化比较的起始点
                int k = i - 1;
                //如果没找到比arr[i] 小的值，后移一位。
                for (int j = k; j >= 0 && temp < arry[j]; j--) {
                    arry[j + 1] = arry[j];
                    k--;
                }
                arry[k + 1] = temp;
            }

        }

        return Arrays.toString(arry);
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 4, 5, 1};
        System.out.println(InsertSort.insertSort(arr));
    }
}
