package 西湖算法题解___简单题;

import java.util.Arrays;

public class __88合并两个有序数组__01 {
	public static void main(String[] args) {
		int nums1 [] = {1,2,3,0,0,0};
		int m = 3;
		int nums2[] = {2,5,6};
		int n = 3;
		merge(nums1,m,nums2,n);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		for (int i=m,j=0;i<m+n&&j<n;i++,j++){
			//System.out.println("nums1[m]等于:"+nums1[i]+"\t"+"nums2[j]等于："+nums2[j]);
			nums1[i] = nums2[j];
		}
		Arrays.sort(nums1);
		System.out.println(Arrays.toString(nums1));

	}



}// class __88合并两个有序数组__01
