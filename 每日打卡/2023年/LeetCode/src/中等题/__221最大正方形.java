package 中等题;

public class __221最大正方形 {
    public int maximalSquare(char[][] matrix) {
        /**
         * 结题思路：
         *  1.感觉和之前找最大面积类似，一个dfs去走方向，然后判断？
         *  但是这次是正方形，那么首要的就是找边，先确定边，然后对边的条件去进行判断即可。
         *
         *  2.所有和之前一样，for循环遍历，然后以每个点（1）作为左上角的边，确认边长，再对边长进行相应范围的判断，
         *      成   -> 则返回【边长*边长】
         *
         *
         */
        int maxSide = 0;
        int matrix_row = matrix.length;
        int matrix_col = matrix[0].length;
        if (matrix == null || matrix_col == 0 || matrix_row == 0){
            return maxSide;
        }
        for (int i=0;i<matrix_row;i++){
            for (int j=0;j<matrix_col;j++){
                if (matrix[i][j] == '1'){   //如果当前位置为‘1’则开始判断
                    maxSide = Math.max(maxSide,1);  //直接以maxSide为起步范围进行判断
                    //计算可能的最大正方形边长
                    int currentMaxSide = Math.min(matrix_row -i,matrix_col - j);    //防止越界，这是最大的可能探测到的正方形边长
                    maxSide = dfs(matrix,i,j,currentMaxSide,maxSide);     //dfs只需要五样东西：数组、行列坐标、最大长度、需要返回的计算出来的最大边长
                }
            }
        }
        //--------------------------------------------------------------------------------------------------------
        int res = maxSide*maxSide;
        return res;
    }

    /**
     *
     *@param matrix    数组
     *@param i  行坐标
     *@param j  列坐标
     *@param currentMaxSide    最大长度
     *@param maxSide   需要返回的计算出来的最大边长
     */
    private int dfs(char[][] matrix, int i, int j, int currentMaxSide, int maxSide) {
        for (int k=1;k<currentMaxSide;k++){
            //就是去遍历每一趟的指定范围内所有的元素是不是都是'1'，只要有第一次不等于1，则可以直接return 当前结果
            boolean flag = true;
            if (matrix[i+k][j+k] == '0'){
                break;
            }
            //说明当前元素不等于1
            for (int m=0;m<k;m++){
                if (matrix[i+k][j+m] == '0' || matrix[i+m][j+k] == '0'){
                    flag = false;
                    //这里是一个当前的小范围。
                    break;
                }
            }
            if (flag){
                maxSide = Math.max(maxSide,k+1);
            }else {
                break;
            }
        }
        return maxSide;
    }

}
