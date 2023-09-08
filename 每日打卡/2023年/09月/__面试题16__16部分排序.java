package 西湖算法题解___中等题;

import java.util.Arrays;

public class __面试题16__16部分排序 {
	public static void main(String[] args) {
		int [] array = new int[]{1,3,9,7,5};
		System.out.println(Arrays.toString(subSort(array)));
	}

	public  static  int[] subSort(int[] array) {
		if (array.length ==0){
			return new int[]{-1,-1};
		}
		int ans [] = new int[2];
		int firstOne = ans[0];
		int secondTwo = ans[1];
//		int helper[] = array;
		int helper[] = new int[array.length];
		for (int i=0;i< array.length;i++){
			helper[i] = array[i];
		}
		//System.out.println(Arrays.toString(array));
		//System.out.println(Arrays.toString(helper));
		//System.out.println("---------------------------------------------");
		Arrays.sort(helper);
		//System.out.println(Arrays.toString(array));
		//System.out.println(Arrays.toString(helper));
		for (int i=0;i< array.length;i++){
			if (helper[i]!=array[i]){
				firstOne = i;
				break;
			}
		}
		System.out.println(firstOne);
		for (int i= array.length-1;i>0;i--){
			if (helper[i]!=array[i]){
				secondTwo = i;
				break;
			}
		}
		System.out.println(secondTwo);

		if (firstOne==0 && secondTwo ==0){
			return new int[]{-1,-1};
		}else {
			return new int[]{firstOne,secondTwo};
		}
	}
}
