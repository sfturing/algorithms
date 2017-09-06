package cn.sfturing.search;

/**
 * @Description:顺序查找
 * Created by Shi Xiaohao on 2017/9/6 下午5:26.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */
public class SequentialSerach {
    /**
     * @ClassName:SequentialSerach
     * @Description:顺序查找时间复杂度：O(n)
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/6 下午5:30
     */
    public static boolean sequentialSerach(int[] arr, int key) {
        boolean findState = false;
        //遍历查找
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key){
                findState = true;
                return findState;
            }
        }
        return findState;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5};
        boolean state= SequentialSerach.sequentialSerach(arr,7);
        System.out.println(state);
    }

}
