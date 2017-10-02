package cn.sfturing;



import java.util.Scanner;


/**
 * Created by Shi Xiaohao on 2017/9/10 下午5:19.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */
public class Test {



    public static void main(String[] args) {
        String a = "abcXYZdef";
        String b=a.substring(0,3);
        String c=a.substring(3,a.length());
        String d = c + b;
        System.out.println(d);



    }


}

