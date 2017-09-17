package cn.sfturing.offer;

import java.util.ArrayList;

/**
 * Created by Shi Xiaohao on 2017/9/17 下午10:04.
 * E-mail:sfturing@gamil.com
 * version:1.0
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 */


/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */


/**
 * 1.分析发现，我们可以通过循环的每一次打印矩阵中的一个圈（从外到内）。
 2.接下来分析循环结束的条件：假设这个矩阵的行数是rows，列数是columns。打印第一圈的左上角的坐标是(0,0),第二圈的左上角的坐标是(1,1),依次类推。我们注意到，左上角的行坐标和列坐标总是相同的，于是可以在矩阵中选取左上角为(start,start)的一圈作为我们分析的目标。
 3.条件是：columns > startX × 2 并且 rows > startY × 2

 分布打印需要判断条件
 */
public class PrintMatrix {
    /**
     * @ClassName:PrintMatrix
     * @Description:运行时间：22ms 占用内存：8404k  弄明白这道题，用了挺长时间。
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/9/18 上午2:07
     */
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        //初始化输出数组列表
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        //初始化矩阵的长宽
        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;

        while (rows > start * 2 && columns > start * 2) {
            //初始化最后一行的终止行号X值，举一个上方矩阵的例子：打印第一行的最后一个值为第四个。则endX=4-1-0=3。
            int endX = columns - 1 - start;
            //初始化终止列号Y值。同理见endX；
            int endY = rows - 1 - start;
            //打印第一行
            for (int i = start; i <= endX; i++) {
                arrayList.add(matrix[start][i]);
                System.out.println(matrix[start][i]);
            }
            //如果只有一行，那么就不用第二步了。也就是需要第二步的前提条件是有两列  终止列号大于start。
            if (endY > start) {
                //打印第二行
                for (int i = start + 1; i <= endY; i++) {
                    arrayList.add(matrix[i][endX]);
                    System.out.println(matrix[i][endX]);
                }
            }
            //打印第三行的条件两行两列，就是需要满足第二行的条件，并且满足终止行号大于start
            if (endY > start && endX > start) {
                //打印第三行
                for (int i = endX - 1; i >= start; i--) {
                    arrayList.add(matrix[endY][i]);
                    System.out.println(matrix[endY][i]);
                }
            }
            //打印第四行,最低条件三行两列
            if (endY - 1 > start && endX > start) {
                for (int i = endY - 1; i >= start + 1; i--) {
                    arrayList.add(matrix[i][start]);
                    System.out.println(matrix[i][start]);
                }
            }
            start++;
        }

        return arrayList;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {5, 6, 7}, {9, 10, 11}, {13, 14, 15}};
        System.out.println(PrintMatrix.printMatrix(matrix));
    }
}
