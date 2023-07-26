package 西湖算法题解___简单题;

public class __371_两整数之和__换底公式__以2为底 {
	public static int getSum(int a, int b){
		if(a==0){
			return b;
		}
		if(b==0){
			return a;
		}
		double m = Math.pow(2,a);
		double n = Math.pow(2,b);
		return (int)(Math.log(m*n)/Math.log(2));

	}
}
