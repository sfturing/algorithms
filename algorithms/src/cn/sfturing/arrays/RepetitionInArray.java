package cn.sfturing.arrays;

import java.util.Random;

public class RepetitionInArray {
	public static void main(String[] args) {
		int arr[] = new int[20];
		Random random = new Random();
		int element = 5;
		int count = 0;
		for(int i = 0;i < arr.length;i++){
			arr[i] = random.nextInt(10);
			if(arr[i] ==  element){
				count++;
			}
		}
		System.out.println(element + "重复了" + count + "次");
		
	}
}
