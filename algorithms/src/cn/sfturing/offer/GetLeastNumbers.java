package cn.sfturing.offer;



/**
 * Created by Shi Xiaohao on 2017/9/22 上午11:48.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */


import java.util.ArrayList;

/**
 * 29.输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers {

    /**
     * @ClassName:GetLeastNumbers
     * @Description:对数组进行排序，然后取出最小的4位数。可以使用快速排序。运行时间：21ms，占用内存：8788k
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/22 下午8:19
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        //判断非空或溢出
        if (input.length == 0 || input == null|| k > input.length) {
            return list;
        }
        //用快速排序把数组进行快速排序。
        quick(input, 0, input.length - 1);
        for (int i = 0;i < k;i++){
            list.add(input[i]);
        }
        System.out.println(list);
        return list;
    }

    public static void quick(int[] arry, int low, int high) {
        if (low < high) {
            int middle = quickSerach(arry, low, high);
            quick(arry, 0, middle - 1);
            quick(arry, middle + 1, high);
        }
    }

    public static int quickSerach(int[] arry, int low, int high) {
        int temp = arry[low];
        while (low < high){
            while (low < high && arry[high] >= temp){
                high--;
            }
            arry[low] = arry[high];
            while (low < high && arry[low] <= temp){
                low++;
            }
            arry[high] = arry[low];
        }
        arry[low] = temp;
        return low;
    }

    public static void main(String[] args) {
        int[] arry = {4,5,1,6,2,7,3,8};
        GetLeastNumbers.GetLeastNumbers_Solution(arry,10);
    }
}
