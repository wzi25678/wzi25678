import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
/*
也并不要求你给出数的全部结果，而只是要求结果的前10位（注意不是后10位）
0<=n<=10000000
2的n次幂的前10位。
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        BigInteger bi = new BigInteger("2");
//        BigInteger sum = bi.pow(n);
        //通常解法是可以解出完全正确的结果的，但是毕竟竞赛题，有运行时限
//        if (sum.toString().length()>10)
//            System.out.println(sum.toString().substring(0,10));
//        else {
//            System.out.println(sum);
//        }
        //因此，通过借鉴别人的思路，明确要用位运算
        /*
        题意：0<=n<=10000000
        你主要盯住前10位的数字，但毕竟是乘法，所以要考虑的是如何减小误差
        根据网络大神给的idea，去考虑前61位   //long :（2^63-1）/2
        卡一个long的最大精度范围
         */
        long o = 1;
        long EstimateValue = o<<61; //EstimateValue:10000000000000000000000000000000000000000000
        while(n-- !=0){
            o<<=1;//每次进行二进位左移一次，也就是2的一次 次方 运算
            if ((EstimateValue & o) == EstimateValue){
                //检测O是否已经到达62位
                o=o/10; //如果到达，则去掉其最后一位保持精度
            }
        }
        //这是一种比较常见的类型题了，具体思路就是方法确定范围，同时减小精度误差。
        //后面这一段就不必讲解
        String str = o+"";
        if (str.length()>10) {//判断数据长度是否大于10，比如2^5=32，它就要原量输出，不能一下标10截取，提交会显示答案错误
            System.out.print(str.substring(0,10));//截取下标
        }
        else {
            System.out.print(str);//原量输出
        }

    }


}
