package cn.sfturing.offer;

/**
 * 7.大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 * Created by Shi Xiaohao on 2017/9/8 下午10:36.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */
public class Fibonacci {
    /**
     * @ClassName:Fibonacci
     * @Description:斐波那契数列定义：F(n):{0,n=0;1,n=1;F(n-1)+f(n-2),n>1}，递归写法。这样的缺点是耗时间，占用内存多。如果数值较大，容易出现问题。
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/8 下午10:39
     */
    public static int fibonacci(int n) {
        if (n == 1) {
            return 1;
        } else if (n > 1) {
            return fibonacci(n - 1) + fibonacci(n - 2);
        } else {
            return 0;
        }

    }

    /**
     * @ClassName:Fibonacci
     * @Description:迭代写法，缺点不好看。占用内存以及消耗时间少，建议使用。
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/8 下午11:08
     */
    public static int fibonacci1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int fn1 = 0;
        int fn2 = 1;
        int currentValue = 0;
        //迭代写法
        for (int i = 2; i <= n; i++) {
            currentValue = fn1 + fn2;
            fn1 = fn2;
            fn2 = currentValue;
        }
        return currentValue;

    }

    public static void main(String[] args) {
        System.out.println(Fibonacci.fibonacci(39));
        System.out.println(Fibonacci.fibonacci1(39));
    }


}
