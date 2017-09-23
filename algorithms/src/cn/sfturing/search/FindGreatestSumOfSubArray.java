package cn.sfturing.search;

/**
 * Created by Shi Xiaohao on 2017/9/22 下午9:02.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */
public class FindGreatestSumOfSubArray {
    /**
     * @ClassName:FindGreatestSumOfSubArray
     * @Description:HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和, 当向量全为正数的时候, 问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
     * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)运行时间：12ms，占用内存：8656k
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/22 下午9:02
     */
    public static int FindGreatestSumOfSubArray(int[] array) {
        //非空判断
        if (array.length == 0 || array == null) {
            return 0;
        }
        //初始化累加sum和最大和returnNum
        int sum = 0;
        int returnNum =Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            //为sum赋值
            if (sum <= 0){
                sum = array[i];
            }else {
                sum += array[i];
            }
            //如果sum累加和超过returnNum，重新赋予给returnNum。
            if (sum > returnNum){
                returnNum = sum;
            }

        }
        return returnNum;
    }

    public static void main(String[] args) {
        int[] arr = {6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(FindGreatestSumOfSubArray.FindGreatestSumOfSubArray(arr));
    }
}
