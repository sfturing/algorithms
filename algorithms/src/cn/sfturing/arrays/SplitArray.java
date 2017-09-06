package cn.sfturing.arrays;

import java.util.Arrays;
import java.util.Random;

public class SplitArray {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = new int[12];
		Random random = new Random();
		for (int i = 1; i < arr.length; i++) {
			arr[i] = random.nextInt(10);
		}
		System.out.println(Arrays.toString(arr));
		int arr1 [] = Arrays.copyOfRange(arr, 0,arr.length/2);
		int arr2 [] = Arrays.copyOfRange(arr, arr.length/2, arr.length);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}
}
