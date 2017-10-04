package cn.sfturing.offer;

/**
 * Created by Shi Xiaohao on 2017/10/4 下午12:05.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */


/**
 *
 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseSentence {

    /**
     * @ClassName:ReverseSentence
     * @Description:运行时间：16ms,占用内存：8664k
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/10/4 下午12:16
     */
    public static String ReverseSentence(String str) {
        //获取str长度。
        int length = str.length();
        //变为char类型数组
        char[] strChar = str.toCharArray();
        //新建输出stringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        //初始化临时字符串数组
        StringBuilder tmp = new StringBuilder();
        //从后向前遍历，遇到空格，将tem翻转插入stringBuilder，并插入" "。
        for (int i = length - 1; i >= 0; i--){
            if (strChar[i] == ' '){
                stringBuilder.append(tmp.reverse().toString());
                stringBuilder.append(" ");
                tmp.delete(0,tmp.length());
            }else {
                tmp.append(strChar[i]);
            }
        }
        //插入最后一个单词
        stringBuilder.append(tmp.reverse().toString());
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String a = "student. a am I";
        System.out.println(ReverseSentence.ReverseSentence(a));
    }

}
