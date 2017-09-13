package cn.sfturing.offer;

/**
 *9. 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * Created by Shi Xiaohao on 2017/9/13 下午7:17.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */
public class JumpFloorII {
    /**
     * 公式推算：
     * 根据f(1)=1;f(2)=f(2-1)+f(2-2)=f(1)+f(0);f(n-1)=f((n-1)-1)+f((n-1)-2)+f((n-1)-(n-1))=f(n-2)+f(n-3)+...f(1)+f(0);
     * f(n)=f(n-1)+f(n-2)+f(n-(n-1))-f(n-n)=f(n-1)+f(n-2)+f(n-3)+...f(1)+f(0)=2*f(n-1);
     *
     * Fn{
     *     0;n=0
     *     1;n=1
     *     2*f(n-1);n>=2
     * }
     */
    /**
     * @ClassName:JumpFloorII
     * @Description:递归方法
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/13 下午7:19
     */
    public static int JumpFloorII(int target) {
        if (target <= 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII(target - 1);
        }
    }
    /**
     * @ClassName:JumpFloorII
     * @Description:非递归方法解决问题。
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/13 下午7:46
     */
    public static int JumpFloorII1(int target) {
        if (target <= 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else {
            int currentValue = 1;
            while (--target != 0) {
                currentValue = 2 * currentValue;
            }
            return currentValue;
            /* int a =0;
             int b= 1;
            for(int i=2;i<=target;i++ ){
                a = b*2;
                b=a;
            }
            return b;*/

        }

    }

    public static void main(String[] args) {
        System.out.println(JumpFloorII.JumpFloorII(30));
        System.out.println(JumpFloorII.JumpFloorII1(30));
    }

}
