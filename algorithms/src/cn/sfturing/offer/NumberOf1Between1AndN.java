package cn.sfturing.offer;

/**
 * Created by Shi Xiaohao on 2017/9/23 下午10:24.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */


/**
 * 31.求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 */
public class NumberOf1Between1AndN {
    /**
     * @ClassName:NumberOf1Between1AndN
     * @Description:时间复杂度为（logN）,运行时间：11m,占用内存：8536k
     * 解题思路：http://sfturing.cn/article/20
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/23 下午10:24
     */
    public static int NumberOf1Between1AndN_Solution(int n) {
        //初始化count返回值、初始化round循环、初始化base倍数。
        int count = 0;
        int base = 1;
        int round = n;
        //判断输入整数值的合法性
        if (n < 1) {
            return 0;
        }
        //进行遍历到的到出现1的次数
        while (round > 0) {
            //初始化权重
            int weight = round % 10;
            round /= 10;
            count += round * base;
            if (weight > 1) {
                count += base;
            } else if (weight == 1) {
                count += (n % base) + 1;
            }
            base *= 10;

        }
        return count;
    }
    /*public static int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;//1的个数
        int i = 1;//当前位
        int current = 0, after = 0, before = 0;
        while ((n / i) != 0) {
            current = (n / i) % 10; //高位数字
            before = n / (i * 10); //当前位数字
            after = n - (n / i) * i; //低位数字
            //如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
            if (current == 0)
                count += before * i;
                //如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
            else if (current == 1)
                count += before * i + after + 1;
                //如果大于1,出现1的次数由高位决定,//（高位数字+1）* 当前位数
            else {
                count += (before + 1) * i;
            }
            //前移一位
            i = i * 10;
        }
        return count;
    }*/

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN.NumberOf1Between1AndN_Solution(13));
    }
}
