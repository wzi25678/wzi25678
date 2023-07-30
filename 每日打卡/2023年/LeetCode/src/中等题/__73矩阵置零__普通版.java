package 中等题;

public class __73矩阵置零__普通版 {
    /**
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int helper[][] = matrix;
        for(int i=0;i< matrix.length;i++){
            for (int j=0;j< matrix[0].length;j++){
                if (matrix[i][j] == 0){
                    //设置的是辅助数组
                    SetZero(helper,i,j);
                    break;
                }
            }
        }
        for(int i=0;i< matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = helper[i][j];
            }
        }
    }

    /**
     *
     * @param helper
     * @param m
     * @param n
     */
    private void SetZero(int helper[][], int m, int n) {
        for (int i=0;i< helper.length;i++){
            helper[i][n] = 0;
        }
        for (int i=0;i< helper.length;i++){
            helper[m][i]=  0;
        }
    }


}
