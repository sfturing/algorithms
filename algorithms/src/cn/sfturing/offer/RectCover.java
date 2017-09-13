package cn.sfturing.offer;

/**
 * 10.我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * Created by Shi Xiaohao on 2017/9/13 下午8:06.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */
public class RectCover {
    /**
     * 分析题目：f(0)=0;f(1)=1;f(2)=2
     * 分析f(n);
     * 情况一：当小一块2*1的矩形竖着放的时候。如下图@部分（代表被覆盖），则剩余的面积还有F（n-1）种情况
     *
     *               n
     * --------------------------------
     * |   @  |   |   |   |   |   |   |   1
     * |   @  |   |   |   |   |   |   |   1
     * --------------------------------
     * 情况一：当小一块2*1的矩形横着放的时候。如下图@部分（代表被覆盖），则还需要一个2*1的矩形填满下方部分面积，使用#部分（代表覆盖，则剩余的面积还有
     * F（n-2）种情况
     *             n
     * --------------------------------
     * |   @  |  @ |   |   |   |   |   |   1
     * |   #  |  # |   |   |   |   |   |   1
     * --------------------------------
     *  所以fn = f（n-1）+f（n-2）
     *
     *  由此可知，为斐波那契数列的问题。
     *Fn{
     *     0;n=0
     *     1;n=1
     *     2;n-2
     *     f（n-1）+f（n-2）;n>=2
     * }
     *
     */
    /**
     * @ClassName:RectCover
     * @Description:递归表示
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/13 下午8:14
     */
    public static int RectCover(int target) {
        if (target <= 0){
            return 0;
        }else if (target == 1 || target ==2){
            return target;
        }else {
            return RectCover(target - 1) + RectCover(target - 2);
        }

    }
    /**
     * @ClassName:RectCover
     * @Description:非递归算法
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/13 下午8:17
     */
    public static int RectCover1(int target){
        if (target <= 0){
            return 0;
        }else if (target == 1 || target ==2){
            return target;
        }else {
            int fn1 = 1;
            int fn2 = 2;
            int currentValue = 0;
            for (int i = 3;i <= target;i++){
                currentValue = fn1 + fn2;
                fn1 = fn2;
                fn2 = currentValue;
            }
            return currentValue;
        }
    }

    public static void main(String[] args) {
        System.out.println(RectCover.RectCover(39));
        System.out.println(RectCover.RectCover1(39));
    }

}
