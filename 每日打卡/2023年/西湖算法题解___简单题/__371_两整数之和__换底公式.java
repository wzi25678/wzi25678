package 西湖算法题解___简单题;

public class __371_两整数之和__换底公式 {
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		System.out.println(getSum(a,b));
	}
	public static int getSum(int a, int b){
		if(a==0){
			return b;
		}
		if(b==0){
			return a;
		}
		double m = Math.pow(10,a);
		System.out.println(m);
		double n = Math.pow(10,b);
		System.out.println(n);
		System.out.println(m*n);
		System.out.println(Math.log10(m*n));
		return (int)Math.log10(m*n);
	}
}
