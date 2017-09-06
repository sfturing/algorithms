package cn.sfturing.arrays;

import java.util.Arrays;

/**
 * 
 * @author sfturing
 * 
 */
public class MergingArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {1,2,3,4,5};
		int arr2[] = {9,8,7,6};
		int arr[] = new int [arr1.length + arr2.length];
		System.arraycopy(arr1, 0, arr, 0, arr1.length);
		System.arraycopy(arr2, 0, arr, arr1.length, arr2.length);
		System.out.println(Arrays.toString(arr));
	}
}
