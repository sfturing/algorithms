package cn.sfturing.offer;

/**
 * 8.一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法？
 * Created by Shi Xiaohao on 2017/9/13 下午4:33.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */
public class JumpFloor {
    /**
     * @ClassName:JumpFloor
     * @Description:可以根据列举得f(1)=1,f(2)=2,f(3)=3,f(4)=5,f(5)=8.看出来是斐波那契数列。对于第n个台阶来说，只能从n-1或者n-2的台阶跳上来，所以 F(n) = F(n-1) + F(n-2)；递归方法实现
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/13 下午4:46
     */
    public static int JumpFloor(int target) {
        if (target <= 0) {

            return 0;
        } else if (target == 1) {
            return 1;
        }
        else if (target == 2){
            return 2;
        }else {
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }

    /**
     * @ClassName:JumpFloor
     * @Description:迭代方式
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/13 下午5:06
     */
    public static int JumpFloor1(int target) {
        if (target <= 0) {

            return 0;
        } else if (target == 1) {
            return 1;
        }
        else if (target == 2){
            return 2;
        } else {
            int fn1 = 1;
            int fn2 = 2;
            int currentValue = 0;
            for (int i = 3; i <= target; i++) {
                currentValue = fn1 + fn2;
                fn1 = fn2;
                fn2 = currentValue;
            }
            return currentValue;
        }

    }
    public static void main(String[] args) {
        System.out.println(JumpFloor.JumpFloor(39));
        System.out.println(JumpFloor.JumpFloor1(39));
    }

}
