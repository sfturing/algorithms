package cn.sfturing.sort;

import java.util.Arrays;

/**
 * Created by Shi Xiaohao on 2017/9/22 下午5:38.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */
public class ShellSort {
    /**
     * @ClassName:ShellSort
     * @Description:希尔排序。时间复杂度为小于O（n^2）
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/22 下午7:06
     */
    public static String shellSort(int[] data) {
        int j = 0;
        int temp = 0;
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < data.length; i++) {
                temp = data[i];
                for (j = i - increment; j >= 0; j -= increment) {
                    if (temp < data[j]) {
                        data[j + increment] = data[j];
                    } else {
                        break;
                    }
                }
                data[j + increment] = temp;
            }
        }
        return Arrays.toString(data);
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 4, 5, 1};
        System.out.println(ShellSort.shellSort(arr));
    }
}
