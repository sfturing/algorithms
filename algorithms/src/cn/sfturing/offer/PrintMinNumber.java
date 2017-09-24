package cn.sfturing.offer;

/**
 * Created by Shi Xiaohao on 2017/9/24 下午4:39.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 32.
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    /**
     * @ClassName:PrintMinNumber
     * @Description:
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/24 下午4:39
     */
    public String PrintMinNumber(int[] numbers) {
        //初始化list
        ArrayList<Integer> arrayList = new ArrayList<>();
        String minValue="";
        for (int i = 0; i < numbers.length; i++) {
            arrayList.add(numbers[i]);
        }
        //将list内元素进行彻底比较。比较方法自定义。
        Collections.sort(arrayList, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                String s1 = i1 + "" + i2;
                String s2 = i2 + "" + i1;
                return s1.compareTo(s2);
            }
        });
        for (int i = 0; i < arrayList.size(); i++) {
            minValue += arrayList.get(i);
        }

        return minValue;

    }

}
