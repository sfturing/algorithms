package arrays;

import java.util.Arrays;
/**
 * 
 * @author sfturing
 *
 */
public class ArrayFlipping {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 6, 9 };
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length / 2; i++) {
			//倒置
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
		System.out.println(Arrays.toString(arr));

	}
}
