package cn.sfturing.offer;

/**
 * Created by Shi Xiaohao on 2017/10/11 下午4:16.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */


/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */
public class StrToInt {

    /**
     * @ClassName:StrToInt
     * @Description: 运行时间：14ms,占用内存：8400k，写的判断嵌套有点多。可读性很差。
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/10/11 下午4:16
     */
    public static int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        //初始化返回值和位数
        int returnValue = 0;
        int postion = 1;
        //初始化char类型数组
        char[] chars = str.toCharArray();
        //判断为0的情况
        if (chars.length == 1 && chars[0] == '0') {
            return 0;
        }
        for (int i = chars.length - 1; i > 0; i--) {
            //判断是否为数字
            if (chars[i] >= '0' && chars[i] <= '9') {
                returnValue = returnValue + (chars[i] - '0') * postion;
                //判断位数溢出,position可能会溢出，所以加条件判断溢出。
                if (postion <= Integer.MAX_VALUE / 10) {
                    postion *= 10;
                } else {
                    //如果首位是符号为，则返回0
                    if (chars[0] == '+' || chars[0] == '-') {
                    } else {
                        return 0;
                    }
                }

            } else {
                return 0;
            }
        }
        //判断符号位，符号为可能性+、-、数字
        if (chars[0] == '+') {
            returnValue *= 1;
        } else if (chars[0] == '-') {
            returnValue *= -1;
        } else {
            if (chars[0] >= '0' && chars[0] <= '9') {
                returnValue = returnValue + (chars[0] - '0') * postion;
            } else {
                return 0;
            }
        }
        return returnValue;

    }

    public static void main(String[] args) {
        System.out.println(StrToInt.StrToInt("+2147483647"));
    }
}
