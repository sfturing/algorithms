package cn.sfturing.offer;

/**
 * Created by Shi Xiaohao on 2017/9/24 下午8:01.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */


import java.util.LinkedHashMap;

/**
 * 34.在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class FirstNotRepeatingChar {
    /**
     * @ClassName:FirstNotRepeatingChar
     * @Description:运行时间：50ms,占用内存：8536k
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/24 下午8:01
     */
    public static int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character,Integer> linkedHashMap = new LinkedHashMap<>();
        //初始化返回值
        int firstPost = -1;
        for (int i = 0; i < str.length();i++){
            if (linkedHashMap.containsKey(str.charAt(i))){
                int time = linkedHashMap.get(str.charAt(i));
                time++;
                linkedHashMap.put(str.charAt(i), time);
            }else {
                linkedHashMap.put(str.charAt(i), 1);
            }
        }
        for (int i = 0;i < str.length();i++){
            if (linkedHashMap.get(str.charAt(i))==1){
                firstPost = i;
                break;
            }
        }
        return firstPost;
    }

    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar.FirstNotRepeatingChar("google"));
    }
}
