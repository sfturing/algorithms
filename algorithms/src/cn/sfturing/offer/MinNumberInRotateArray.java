package cn.sfturing.offer;

/**
 * 6.把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * Created by Shi Xiaohao on 2017/9/7 下午11:30.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */
public class MinNumberInRotateArray {
    /**
     * @ClassName:MinNumberInRotateArray
     * @Description:使用二分查找解决，时间复杂度为logn。
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/7 下午11:30
     */
    public static int minNumberInRotateArray(int[] array) {

        if (array.length == 0 || array == null) {
            return 0;
        }
        //初始化low和high
        int low = 0;
        int high = array.length - 1;
        //确保不会出现重复查找，越界
        while ((low <= high) && (low <= array.length - 1) && (high <= array.length - 1)) {
            //low + (high - low)/2这种写法可以防止越界。等价于（low+high）／2
            int mid = low + (high - low) / 2;
            //3中情况，arr[mid]>arr[high],arr[mid]=arr[high],arr[mid]<arr[high]
            if (array[mid] > array[high]) {
                //mid大于high，最小值在数组右边
                low = low + 1;
            } else if (array[mid] == array[high]) {
                //mid等于high，最小值在数组右边，出现这种情况的array类似 [1,0,1,1,1] 或者[1,1,1,0,1],缩小范围查找。
                high = high - 1;

            } else if (array[mid] < array[high]) {
                //mid小于high，说明，中间值在左边或者是本身。
                high = mid;
            }
        }
        return array[low];
    }

    public static void main(String[] args) {

        int[] array = {};
        int key = MinNumberInRotateArray.minNumberInRotateArray(array);
        System.out.println(key);
    }
}
