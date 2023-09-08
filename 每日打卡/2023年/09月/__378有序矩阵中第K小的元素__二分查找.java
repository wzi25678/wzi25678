	package 西湖算法题解___中等题;
	
	public class __378有序矩阵中第K小的元素__二分查找 {
		public int kthSmallest(int[][] matrix, int k) {
			int n = matrix.length;
			int left = matrix[0][0];
			int right = matrix[n-1][n-1];
			while (left < right){
				int mid = left + ((right - left) >> 1 ) ;
				if (myCheck(matrix,mid,k,n)){
					right = mid;
				}else {
					left = mid + 1;
				}
			}
			return left;
		}
	
		private boolean myCheck(int[][] matrix, int mid, int k, int n) {
			int i = n-1;
			int j = 0;
			int num = 0;
			while (i >= 0 && j<n){
				if (matrix[i][j] <= mid){
					num += (i+1);
					j++;
				}else {
					i--;
				}
			}
			return num >= k;
		}
	}
