package arrays;

import java.util.Arrays;
import java.util.Random;

public class MaxMinValue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new  int[20];
		Random random = new Random();
		for(int i = 0; i < arr.length; i++){
			arr[i] = random.nextInt(1000);
		}
		int MAX = arr[0];
		for(int i = 0; i < arr.length; i++){
			if(MAX < arr[i]){
				MAX = arr[i];
			}
		}
		int MIN = arr[0];
		for(int i = 0; i < arr.length; i++){
			if(MIN > arr[i]){
				MIN = arr[i];
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("最大值为:" + MAX + "," + "最小值为:" + MIN);

	}

}
