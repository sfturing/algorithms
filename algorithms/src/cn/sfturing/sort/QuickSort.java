package cn.sfturing.sort;

import java.util.Arrays;

/**
 * 快速排序放入实现
 */
public class QuickSort {


    public static String quickSort(int[] array) {
        //判断非空
        if (array.length == 0 || array == null) {
            return null;
        }
        quickSort(array, 0, array.length - 1);
        return Arrays.toString(array);
    }

    /**
     * @ClassName:QuickSort
     * @Description:遍历方法
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/25 上午10:48
     */
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = quickMid(array, low, high);
            quickSort(array, low, mid - 1);
            quickSort(array, mid + 1, high);
        }
    }

    /**
     * @ClassName:QuickSort
     * @Description:使array[low]左边都是小于他的，右边都是大于它的。
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/25 上午10:54
     */
    public static int quickMid(int[] array, int low, int high) {
        int temp = array[low];
        while (low < high) {
            while (low < high && array[high] >= temp) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= temp) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = temp;
        System.out.println(Arrays.toString(array));
        return low;
    }


    public static void main(String[] args) {
        int[] array = {0,1,0,5,3};
        System.out.println(QuickSort.quickSort(array));

    }

}
