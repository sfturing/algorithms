package cn.sfturing.sort;

import java.util.Arrays;

/**
 * Created by Shi Xiaohao on 2017/9/24 下午6:09.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */
public class MergeSort {
    public static void merge(int[] a, int low, int mid, int high) {
        //初始化数组大小，初始化前半部分指针，后半部分指针。
        int[] array = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        //比较前半部分和后半部分，从头开始，小的放入数组
        while (i <= mid && j <= high){
            if (a[i] <= a[j]){
                array[k] = a[i];
                k++;
                i++;
            }else {
                array[k] = a[j];
                k++;
                j++;

            }
        }
        //两部分比较完成之后，将剩余的部分放入数组
        while (i <= mid){
            array[k] = a[i];
            k++;
            i++;
        }
        while (j <= high){
            array[k] = a[j];
            k++;
            j++;
        }
        for (int l = 0;l <array.length;l++){
            a[l + low] = array[l];
        }

    }

    public static void mergeSort(int[] a, int low, int high) {
        //归并分解数组。
        //int mid = (low + high) / 2;等于下面的效果，目的是为了防止溢出。
        int mid = low+((high-low)>>1);
        if (low < high) {
            mergeSort(a,low,mid);
            mergeSort(a,mid + 1, high);
            merge(a,low,mid,high);

        }


    }

    public static void main(String[] args) {
        int a[] = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        mergeSort(a, 0, a.length - 1);
        System.out.println("排序结果：" + Arrays.toString(a));
    }
}
