package 西湖算法题解___简单题;

import java.util.Arrays;

public class __661图片平滑器__检查九个位置的合理性  {
	public static void main(String[] args) {
		int img[][] =  new int [][]{{100,200,100},{200,50,200},{100,200,100}};
		imageSmoother(img);
	}

	public static int[][] imageSmoother(int[][] img) {
		int helper[][] = new int[img.length][img[0].length];
		//图像平滑器 是大小为 3 x 3 的过滤器
		for (int i=0;i<img[0].length;i++){
			//先取行--------------------------------------------
			for (int j=0;j<img.length;j++){
				//再取列----------------------------------------
				System.out.println("当前取得是:"+img[i][j]);
				helper[i][j] = CountImage(img,i,j);
				System.out.println(helper[i][j]);
				System.out.println("-------------------------------------------------");
			}
		}
		for (int i=0;i<img[0].length;i++) {
			//先取行--------------------------------------------
			for (int j = 0; j < img.length; j++) {
				System.out.print(helper[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(Arrays.toString(helper));
		return helper;
	}

	private static int CountImage(int[][] img, int i, int j) {
		int res = 0;
		int count = 0;
		//左上
		if (i-1>=0 && j-1 >=0){
			System.out.println("arr[i][j]左上: "+img[i-1][j-1]);
			count++;
			res+=img[i-1][j-1];
		}
		//中上
		if (i-1>=0 ){
			res+=img[i-1][j];
			count++;
			System.out.println("arr[i][j]中上: "+img[i-1][j]);
		}
		//右上
		if (i-1>=0  && j+1 < img[0].length){
			res+=img[i-1][j+1];count++;
			System.out.println("arr[i][j]右上: "+img[i-1][j+1]);
		}
		//左
		if (j-1>=0 ){
			res+=img[i][j-1];count++;
			System.out.println("arr[i][j]左: "+img[i][j-1]);
		}
		//中
		res+=img[i][j];count++;
		System.out.println("arr[i][j]中: "+img[i][j]);
		//右
		if (j+1 < img[0].length){
			res+=img[i][j+1];count++;
			System.out.println("arr[i][j]右: "+img[i][j+1]);
		}
		//左下
		if (i+1 < img.length&&  j-1 >=0){
			res+=img[i+1][j-1];count++;
			System.out.println("arr[i][j]左下: "+img[i+1][j-1]);
		}
		//中下
		if (i+1 < img.length ){
			res+=img[i+1][j];count++;
			System.out.println("arr[i][j]中下: "+img[i+1][j]);
		}
		//右下
		if (i+1 < img.length && j+1 < img[0].length){
			res+=img[i+1][j+1];count++;
			System.out.println("arr[i][j]右下: "+img[i+1][j+1]);
		}
		res/=count++;;
		System.out.println(res);
		return res;
	}


}
