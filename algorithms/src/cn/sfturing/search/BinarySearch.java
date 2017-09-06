package cn.sfturing.search;

/**
 * Created by Shi Xiaohao on 2017/9/6 下午6:33.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */
public class BinarySearch {
    /**
     * @ClassName:BinarySearchy
     * @Description:有序表查找  二分查找，可以想像为二叉树，根据二叉树定义，时间复杂对为logn，适用于静态查找表，不适合动态的插入。
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/6 下午10:14
     */
    public static int binarySearch(int arr[], int key) {
        //初始化low和high
        int low = 0;
        int high = arr.length - 1;
        //确保不会出现重复查找，越界
        while ((low <= high) && (low <= arr.length - 1) && (high <= arr.length - 1)) {
            //初始化中间值
            int middle = (low + high) / 2;
            if (middle == key){
                return middle;
            }else if (key < middle){
                high = middle - 1;
            }else {
                low = middle + 1;
            }
        }
        //未找到返回-1
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {};
        int key = BinarySearch.binarySearch(arr,6);
        System.out.println(key);
    }
}
