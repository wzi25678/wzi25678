/*
题目描述
众所周知，小葱同学擅长计算，尤其擅长计算一个数是否是另外一个数的倍数。但小葱只擅长两个数的情况，当有很多个数之后就会比较苦恼。现在小葱给了你 
�
n 个数，希望你从这 
�
n 个数中找到三个数，使得这三个数的和是 
�
K 的倍数，且这个和最大。数据保证一定有解。

输入描述
第一行包括 2 个正整数 
�
,
 
�
n, K。

第二行 
�
n 个正整数，代表给定的 
�
n 个数。

其中，
1
≤
�
 
≤
1
0
5
,
 
1
≤
�
 
≤
1
0
3
1≤n ≤10 
5
 , 1≤K ≤10 
3
 ，给定的 
�
n 个数均不超过 
1
0
8
10 
8
 。

输出描述
输出一行一个整数代表所求的和。

输入输出样例
示例
输入

4 3
1 2 3 4
copy
输出

9
copy
运行限制
最大运行时间：1s
最大运行内存: 256M
*/

//package 蓝桥云课;

import java.util.Arrays;
import java.util.Scanner;

public class Main{
	private static int n,k;
	private static int arr[];
	/*
	 * 。现在小葱给了你 
�
		n 个数，希望你从这 
�
		n 个数中找到三个数，使得这三个数的和是 
�
		K 的倍数，
	 */
	
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		arr = new int [n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for(int i=n-1;i>=2;i--) {
			for(int j=i-1;j>=1;j--) {
				for(int m=j-1;m>=0;m--) {
					if((arr[i]+arr[j]+arr[m])%k!=0) {
						continue;
					}
					else {
						System.out.println(arr[i]+arr[j]+arr[m]);
						return;
					}
				}
			}
		}
		
	}
	
}
