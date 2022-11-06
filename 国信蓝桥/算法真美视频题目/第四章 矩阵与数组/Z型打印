import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int arr[][] = {
                {1,   2,  3,  4,  5},
                {6,   7,  8,  9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };
        PrintZ(arr);
    }

    private static void PrintZ(int[][] arr) {
        int r_up = 0,m_down = arr.length;       //r  m
        int c_left = 0,n_rigth=arr[0].length;   //c  n
        //先把矩阵的四个边给找出来
        boolean l2r = true;
        while (r_up<m_down && c_left<n_rigth){
            if (l2r){
                System.out.print(arr[r_up][c_left]+" ");
                if (r_up==0 && c_left<n_rigth-1){
                    l2r=!l2r;
                    c_left++;
                    continue;
                }   //end if
                else if(r_up>0 && c_left==n_rigth-1){
                    //如果走到最右边
                    l2r=!l2r;   //切换方向
                    r_up++;     //并且向下走
                    continue;
                }//end else if
                else {     //上坡路
                    r_up--;
                    c_left++;
                }
            }   //end if
            else {  //反，走下坡
                System.out.println(arr[r_up][c_left]);
                if (r_up<m_down-1 && c_left==0){    //如果走到最左边
                    l2r=!l2r;   //调整方向
                    r_up++;
                    continue;
                }
                else if (r_up==m_down-1){
                    l2r=!l2r;
                    c_left++;
                    continue;
                }//end- else if
                else {  //走下披路
                    r_up++;
                    c_left--;
                }
            }//end- else
        }

    }
}

