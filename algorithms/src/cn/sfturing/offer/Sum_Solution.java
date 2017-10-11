package cn.sfturing.offer;

/**
 * Created by Shi Xiaohao on 2017/10/7 下午8:49.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */


/**
 *
 *求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sum_Solution {
    /**
     * @ClassName:Sum_Solution
     * @Description:利用递归和短路的特性。
     * 运行时间：10ms,占用内存：8276k
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/10/7 下午8:49
     */
    public int Sum_Solution(int n) {
        int sum = n;
        boolean state = n > 0 && (sum += Sum_Solution(n - 1)) > 0;
        return sum;
    }
}
