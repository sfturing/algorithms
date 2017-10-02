package cn.sfturing.offer;

/**
 * Created by Shi Xiaohao on 2017/9/29 下午4:55.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */


/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class LeftRotateString {
    /**
     * @ClassName:LeftRotateString
     * @Description:运行时间：17ms,占用内存：8516k
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/29 下午4:56
     */
    public static String LeftRotateString(String str,int n) {
        if (str.length() == 0 || str == null || n < 0){
            return null;
        }
        String outValue = null;
        while (str.length() <= n){
            n-=str.length();
        }
        if (n == 0){
            return str;
        }else {
            String pre = str.substring(0,n);
            String last = str.substring(n,str.length());
            outValue = last + pre;
        }

        return outValue;
    }

    public static void main(String[] args) {
        String a = LeftRotateString.LeftRotateString("abcXYZdef",3);
        System.out.println(a);
    }
}
