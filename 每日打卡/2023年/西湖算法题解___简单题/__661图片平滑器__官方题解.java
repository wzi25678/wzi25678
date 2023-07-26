package 西湖算法题解___简单题;

public class __661图片平滑器__官方题解 {
	public static void main(String[] args) {

	}

	public int[][] imageSmoother(int[][] img){
		//其中m表示行，n代表列
		int m = img.length,n = img[0].length;
		int [][]  res = new int[m][n];
		for (int i=0;i<m;i++){
			for (int j=0;j<n;j++){
				int num = 0,sum = 0;
				for (int x = i-1;x<=i+1;x++){
					for (int y=j-1;y<=j+1;y++){
						if (x>=0 && x<m && y>=0 && y<n){
							num++;
							sum +=img[x][y];
						}
					}
				}
			res[i][j] = sum/num;
			}//for (int j=0;j<n;j++)
		}
		return res;
	}


}
