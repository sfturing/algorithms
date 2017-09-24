package cn.sfturing.offer;

/**
 * Created by Shi Xiaohao on 2017/9/24 下午8:34.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */

/**
 * 35.在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class InversePairs {

    /**
     * @ClassName:InversePairs
     * @Description:这个题相当于归并排序的变种。可以利用归并排序进行解决，时间复杂度比暴力遍历要低。
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/24 下午11:10
     */
    public static int InversePairs(int [] array) {
        //判断arr非空
        if (array.length == 0 || array == null){
            return 0;
        }
        int inversionNum = 0;
        inversionNum = mergeSort(array,0,array.length - 1);
        return inversionNum%1000000007;
    }

    public static int mergeSort(int[] array,int low,int high){
        int mid = low + (high - low) / 2;
        int inversionNum = 0;
        if (low < high){
            //递归
            inversionNum += mergeSort(array,low,mid)%1000000007;
            inversionNum += mergeSort(array,mid + 1,high)%1000000007;
            inversionNum += mergeSort(array,low,mid,high)%1000000007;
        }

        return inversionNum;
    }
    public static  int mergeSort(int[] array,int low,int mid,int high){
        //初始化参数，两段数组的指针位置，初始化临时数组的内存空间
        int[] tem = new int[high - low + 1];
        int inversionNum = 0;
        int i = mid;
        int j = high;
        int k = 0;
        while (i >= low && j >= mid + 1){
            if (array[i] > array[j]){
                tem[k++] = array[i--];
                inversionNum += j - mid;
                if(inversionNum >= 1000000007)
                    inversionNum %= 1000000007;
            }else {
                tem[k++] = array[j--];
            }

        }
        //将剩余的放入临时数组
        while (i >= low){
            tem[k++] = array[i--];
        }
        while (j >= mid + 1){
            tem[k++] = array[j--];
        }
        for (int l = 0;l < tem.length;l++){
            array[high - l] = tem[l];
        }
        return inversionNum;
    }

    public static void main(String[] args) {
        int[] array = {8,7,6,5};
        System.out.println(InversePairs.InversePairs(array));
    }

}
