package cn.sfturing.offer;

/**
 * Created by Shi Xiaohao on 2017/9/22 上午9:34.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */

/**
 * 28.数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {
    /**
     * @ClassName:MoreThanHalfNum
     * @Description:采用士兵突击的算法，如果count为0，则该遍历元素为tempValue，如果碰到相同的count++，如果不同，则count--，
     * 碰到 count==0 ，采用新的tempValue，最后的tempValue进行一次遍历，如果超过数组的一半，输出，相反，输出0；
     *
     * 运行时间：17ms,占用内存：8168k
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/22 上午9:34
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        //判断非空
        if (array.length == 0 || array == null) {
            return 0;
        }
        //初始化计数器和缓存数
        int count = 0;
        int tempValue = 0;
        //首先第一遍遍历
        for (int i = 0; i < array.length; i++) {
            //count为0时
            if (count == 0) {
                count++;
                tempValue = array[i];
            } else {
                //count不为0时，比较是否和tempValue一致
                if (array[i] == tempValue) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        //将count置0，重新计数
        count =0;
        //再次遍历，查看是否满足超过数组的一半
        for (int i = 0; i < array.length;i++){
            if(array[i] == tempValue){
                count++;
            }
        }
        if (count >= array.length/2){
            return tempValue;
        }
        return 0;
    }
}
