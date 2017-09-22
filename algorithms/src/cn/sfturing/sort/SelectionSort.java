package cn.sfturing.sort;

/**
 * Created by Shi Xiaohao on 2017/9/22 下午3:58.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */

import java.util.Arrays;

/**
 * 简单的选择排序
 */
public class SelectionSort {

    /**
     * @ClassName:SelectionSort
     * @Description:时间复杂度为O（n^2）
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/22 下午4:09
     */
    public static String selectionSort(int[] arry){
        //判断非空
        if (arry.length == 0 || arry == null) {
            return null;
        }
        int min;
        int tem;
        for (int i = 0;i < arry.length;i++){
            min = i;
            for (int j = i + 1;j < arry.length;j++){
                if (arry[j] < arry[min]){
                    min = j;
                }
            }
            if (i != min){
                tem = arry[min];
                arry[min] = arry[i];
                arry[i] = tem;
            }


        }

        return Arrays.toString(arry);
    }
    public static void main(String[] args) {
        int[] arr = {6, 3, 4, 5, 1};
        System.out.println(SelectionSort.selectionSort(arr));
    }

}
