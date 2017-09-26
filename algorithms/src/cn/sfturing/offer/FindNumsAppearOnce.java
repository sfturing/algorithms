package cn.sfturing.offer;

/**
 * Created by Shi Xiaohao on 2017/9/26 下午9:36.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */

import java.util.HashMap;

/**
 * 40.一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */


/**
 * 链接：https://www.nowcoder.com/questionTerminal/e02fdb54d7524710a7d664d082bb7811
 来源：牛客网   这个算法看的是牛客网的网友的思路。

 首先：位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。

 当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，最后剩下的就是落单的数，因为成对儿出现的都抵消了。

 依照这个思路，我们来看两个数（我们假设是AB）出现一次的数组。我们首先还是先异或，剩下的数字肯定是A、B异或的结果，这个结果的二进制中的1，表现的是A和B的不同的位。我们就取第一个1所在的位数，假设是第3位，接着把原数组分成两组，
 分组标准是第3位是否为1。
 如此，相同的数肯定在一个组，因为相同数字所有位都相同，而不同的数，肯定不在一组。然后把这两个组按照最开始的思路，依次异或，剩余的两个结果就是这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {
    /**
     * @ClassName:FindNumsAppearOnce
     * @Description:运行时间：18ms,占用内存：8656k
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/26 下午9:37
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length <= 2) {
            return;
        }
        int bit = 0;
        for (int i = 0; i < array.length; i++) {
            bit ^= array[i];
        }
        int indexOf1 = findFirstbit(bit);
        for (int i = 0;i < array.length;i++){
            if (isBit(array[i],indexOf1)){
                num1[0] ^= array[i];
            }else {
                num2[0] ^= array[i];
            }
        }

    }

    public static int findFirstbit(int bit) {
        int indexBit = 0;
        while (((bit & 1) == 0) && indexBit < 32) {
            indexBit++;
            bit = bit >> 1;
        }
        return indexBit;

    }

    public static boolean isBit(int array, int indexBit) {

        return ((array >> indexBit) & 1) == 1;
    }
}
