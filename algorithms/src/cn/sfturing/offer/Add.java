package cn.sfturing.offer;

/**
 * Created by Shi Xiaohao on 2017/10/7 下午9:02.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */


/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Add {
    /**
     * @ClassName:Add
     * @Description:运行时间：11ms,占用内存：8408k
     * 两个数相加分为不进位和进位的情况，分别对应的是异或和与运算。进行迭代得到结果。
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/10/7 下午9:03
     */
    public static int Add(int num1,int num2) {

        //初始化不进位sum和进位carry
        int sum = 0;
        int carry = 0;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }while (num2 != 0);

        return num1;
    }

    public static void main(String[] args) {
        System.out.println(Add.Add(5,7));
    }


}
