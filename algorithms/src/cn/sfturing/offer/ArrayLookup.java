
package cn.sfturing.offer;

/**
 * 题目1：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * 
 * @author sfturing
 *
 * @date 2017年7月20日
 */
public class ArrayLookup {
	/**
	 * 暴力搜索方法，时间复杂度为n^2
	 * @param target
	 * @param array
	 * @return
	 */
	public boolean Find(int target, int[][] array) {
		boolean isRange = false;
		for (int i = 0; i <= array.length-1; i++) {
			for (int j = 0; j <= array[0].length-1; j++) {
				if (target == array[i][j]) {
					isRange = true;
					break;
				}
			}
		}
		return isRange;
	}

	public static void main(String arr[]) {
		ArrayLookup arrayLookup = new ArrayLookup();
		int[][] array = { { 1, 2, 3, 4, 5 }, { 2, 3, 4, 5, 6 }, { 3, 4, 5, 6, 7 } };
		boolean flag = arrayLookup.Find(1, array);
		System.out.println(flag);

	}
}
