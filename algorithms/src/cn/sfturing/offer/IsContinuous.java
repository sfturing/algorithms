package cn.sfturing.offer;

/**
 * Created by Shi Xiaohao on 2017/10/4 下午2:28.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */


/**
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,
 * 看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,
 * 决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。
 */
public class IsContinuous {
    /**
     * @ClassName:IsContinuous
     * @Description:先排序。进行快排.5个数字感觉可以直接排序。练习一下快速排序。
     * 运行时间：12ms,占用内存：8276k,这个代码的可读性感觉为0。
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/10/4 下午2:29
     */
    public static boolean isContinuous(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return false;
        }
        boolean flag = false;
        int[] num = quickSort(numbers, 0, numbers.length - 1);
        //判断是有几个0;
        int zero = num[3] == 0 ? 4 : num[2] == 0 ? 3 : num[1] == 0 ? 2 : num[0] == 0 ? 1 : 0;
        int temp = zero;
        //设置两个相邻的指针，相减得到差，如果是相同的数目，得到-1，不是顺子，返回false.0代表大王，可以当作任意数，如果没有大王，则最大的数减去最小的数为4，
        //加入大小王之后，大小数之差可以小于 4+zero的数目。 感觉代码写的和狗屎一样啊啊啊啊啊啊啊啊。懒得改了。
        int gap = 0;
        int low = zero;
        int high = low + 1;
        switch (zero) {
            case 0:
                if (num[0] + 1 == num[1] && num[1] + 1 == num[2] && num[2] + 1 == num[3] && num[3] + 1 == num[4]) {
                    flag = true;
                }
                break;
            case 1:
            case 2:
            case 3:
                while (high <= 4) {
                    gap = num[high] - num[low] - 1;
                    if (gap < 0) {
                        flag = false;
                        return false;
                    }
                    temp -= gap;
                    if (temp < 0) {
                        flag = false;
                        return false;
                    }
                    low++;
                    high++;
                }
                flag = true;
                break;
            case 4:
                flag = true;
                break;
        }
        return flag;
    }


    /**
     * @ClassName:IsContinuous
     * @Description:快速排序
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/10/4 下午3:03
     */
    public static int[] quickSort(int[] numbers, int low, int high) {

        if (low < high) {
            int mid = quick(numbers, low, high);
            quickSort(numbers, low, mid - 1);
            quickSort(numbers, mid + 1, high);
        }
        return numbers;
    }

    public static int quick(int[] numbers, int low, int high) {
        int temp = numbers[low];
        while (low < high) {
            while (low < high && numbers[high] >= temp) {
                high--;
            }
            numbers[low] = numbers[high];
            while (low < high && numbers[low] <= temp) {
                low++;
            }
            numbers[high] = numbers[low];
        }

        numbers[low] = temp;
        return low;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 4, 5};
        System.out.println(IsContinuous.isContinuous(array));
    }


}
