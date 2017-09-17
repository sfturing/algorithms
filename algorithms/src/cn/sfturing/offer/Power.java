package cn.sfturing.offer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * Created by Shi Xiaohao on 2017/9/13 下午11:24.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */
public class Power {
    /**
     * @ClassName:Power
     * @Description:分析底数和指数的不同情况。底数和指数的不同组合，设底数为a，指数为b(a,b为正数) （a^b、-a^b）（a^-b   -a^-b ） （ 0^b）= 0 0^-b 报错  任何数的0次方等于1
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/13 下午11:24
     */
    public static double power(double base, int exponent) {
        int ex;
        double value = base;
        if (exponent > 0) {
            ex = exponent;
        } else if (exponent < 0) {
            if (base == 0) {
                throw new RuntimeException("错误");
            } else ex = -exponent;
        } else {
            return 1;
        }

        while (--ex != 0) {
            value*=base;
        }
        return exponent >= 0 ? value : (1 / value);
    }

    public static void main(String[] args) {
        System.out.println(Power.power(2,5));
    }

}
