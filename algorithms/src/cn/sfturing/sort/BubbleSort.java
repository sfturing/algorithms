package cn.sfturing.sort;

import java.util.Arrays;

/**
 * Created by Shi Xiaohao on 2017/9/22 上午11:54.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */

/**
 * 简单的冒泡排序法，冒泡排序法有多种算法。也可以优化。但最终的复杂度还是 O（n^2），但
 */
public class BubbleSort {

    /**
     * @ClassName:BubbleSort
     * @Description:时间复杂度为O（n^2）。这个不算是真正的冒泡，真正的是从尾部和尾部前一个进行比较，最小值 慢慢的浮现到最上方。
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/22 下午3:30
     */
    public static String bubbleSort(int[] arry) {
        //判断非空
        if (arry.length == 0 || arry == null) {
            return null;
        }
        int tmp ;
        for (int i = 0; i < arry.length; i++) {
            //与之前所有的值进行比较，如果比前面的值小，则进行交换。
            for (int j = arry.length - 1; j > i; j--) {
                if (arry[i] > arry[j]) {
                    tmp = arry[j];
                    arry[j] = arry[i];
                    arry[i] = tmp;
                }
            }

        }

        return Arrays.toString(arry);
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 4, 5, 1};
        System.out.println(BubbleSort.bubbleSort(arr));
    }

}
