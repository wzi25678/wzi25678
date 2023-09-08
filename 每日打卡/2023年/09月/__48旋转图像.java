package 西湖算法题解___中等题;

public class __48旋转图像 {
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		int [][] matrix ={{1,2,3},{4,5,6},{7,8,9}};
		rotate(matrix);
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix.length; ++j) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	/**
	 * @param matrix
	 * @return
	 */
	public static void rotate(int[][] matrix){
		int helper[][] = new int[matrix.length][matrix.length];
		//int helper[][] = matrix;
		for (int i=0;i< matrix.length;i++){ //针对matrix来说，i是列
			int temp=0;
			for (int j= matrix.length-1;j>=0; j--){ //则对应j是行
				//System.out.println("当前的matirx是:"+matrix[j][i]+"\t当前取得j和i分别为："+j+" "+i);
				helper[i][temp] = matrix[j][i];
				temp++;
			}
			//System.out.println();
		}
//		for (int i = 0; i < matrix.length; ++i) {
//			for (int j = 0; j < matrix.length; ++j) {
//				System.out.print(helper[i][j]+" ");
//			}
//			System.out.println();
//		}

//		for (int i = 0; i < matrix.length; ++i) {
//			for (int j = 0; j < matrix.length; ++j) {
//				matrix[i][j] = helper[i][j];
//			}
//		}
		matrix = helper;
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix.length; ++j) {
				System.out.print(helper[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("--------------------------------------------------");
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix.length; ++j) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}


	}//public void rotate(int[][] matrix)
}
