package cn.sfturing.offer;

/**
 * Created by Shi Xiaohao on 2017/9/24 下午7:38.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */

import java.util.ArrayList;

/**
 * 33.把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber {
    /**
     * @ClassName:GetUglyNumber
     * @Description:运行时间：15ms,占用内存：8332k
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/24 下午7:51
     */
    public int GetUglyNumber_Solution(int index) {
        if (index == 0){
            return 0;
        }
        if (index == 1){
            return 1;
        }
        //vector<int>k(index);k[0]=1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0,1);
        int i2=0,i3=0,i5=0;
        for (int i = 1; i <index;i++){
            int m2=list.get(i2)*2;
            int m3=list.get(i3)*3;
            int m5=list.get(i5)*5;
            int min = Math.min(m2,Math.min(m3,m5));
            list.add(min);
            if(min==m2)i2++;
            if(min==m3)i3++;
            if(min==m5)i5++;

        }
        return list.get(list.size()-1);
    }
}
