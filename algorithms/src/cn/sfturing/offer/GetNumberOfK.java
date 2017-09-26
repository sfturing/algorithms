package cn.sfturing.offer;

/**
 * Created by Shi Xiaohao on 2017/9/26 上午11:14.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */


/**
 * 37.统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
    /**
     * @ClassName:GetNumberOfK
     * @Description: 因为是有序数组，所以利用二分查找的方法。来查找。因为有多个k值，所以改变一下二分查找。利用二分查找查找.运行时间：16ms 占用内存：8408k
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/26 上午11:15
     */
    public static int GetNumberOfK(int[] array, int k) {
        int num = 0;
        //判断非空
        if (array == null || array.length == 0) {
            return num;
        }
        //得到起始K值和结束K值
        int firstK = getFirstK(array, 0, array.length - 1,k);
        int lastK = getLstaK(array, 0, array.length - 1,k);
        if (firstK != -1 && lastK!= -1){
            num = lastK - firstK + 1;
        }
        return num;
    }


    public static int getFirstK(int[] array, int start, int end,int k) {

        while ((start <= end) && (start <= array.length - 1) && (end <=array.length - 1)) {
            //定义中间值，防止溢出。
            int mid = start + ((end - start) >>> 1);
            if (array[mid] == k){
                //判断k的前一个节点是否存在，并且前一个结点是否为k，如果满足，则说明第一个结点在前半段，继续二分查找。
                if (mid - 1 >=0 && array[mid - 1] == k){
                    end = mid - 1;
                }else {
                    return mid;
                }
            }else if (array[mid] > k){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }


    public static int getLstaK(int[] array, int start, int end,int k) {
        while ((start <= end) && (start <= array.length - 1) && (end <=array.length - 1)) {
            //定义中间值，防止溢出。
            int mid = start + ((end - start) >>> 1);
            if (array[mid] == k){
                //判断k的后一个节点是否存在，并且后一个结点是否为k，如果满足，则说明最后结点在后半段，继续二分查找。
                if (mid + 1 <= array.length - 1 && array[mid + 1] == k){
                    start = mid + 1;
                }else {
                    return mid;
                }
            }else if (array[mid] > k){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array={3,3,3,3,4,5};
        System.out.println(GetNumberOfK.GetNumberOfK(array,3));
    }
}
