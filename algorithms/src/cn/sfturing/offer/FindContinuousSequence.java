package cn.sfturing.offer;

/**
 * Created by Shi Xiaohao on 2017/9/27 上午12:49.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */


import java.util.ArrayList;

/**
 * 41.输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FindContinuousSequence {

    /**
     * @ClassName:FindContinuousSequence
     * @Description:运行时间：20ms,占用内存：8792k.
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/27 上午12:50
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        // 初始化返回数组
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        //初始化两个指针，两个指针移动。  当sumValue > sum 时，p1指针++，当sumValue < sum 时，p2指针++
        int p1 = 1;
        int p2 = 2;
        //结束end的条件
        int sumValue = 0;
        while (p1 < (sum + 1) / 2) {
            sumValue = 0;
            for (int i = p1; i <= p2; i++) {
                sumValue += i;
            }
            if (sumValue == sum) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = p1; i <= p2; i++) {
                    arrayList.add(i);
                }
                arrayLists.add(arrayList);
                p2++;
            } else if (sumValue > sum) {
                p1++;
            } else if (sumValue < sum) {
                p2++;
            }
        }
        return arrayLists;
    }

    public static void main(String[] args) {
        System.out.println(FindContinuousSequence.FindContinuousSequence(9));
    }
}
