package 西湖算法题解___简单题;

public class __263丑数 {
	public static void main(String[] args) {

	}

	public boolean isUgly(int n) {
		if (n==1){
			return true;
		}
		if(n<=0){
			return false;
		}
		while (n%2==0 || n%3==0 || n%5 ==0){
				if (n%2==0){
					n/=2;
				} else if (n%3==0 ) {
					n/=3;
				}else{
					n/=5;
				}
				//--------------------------剩下的余数
			}
		//最后出来要不是0，要不是1
		//如果是1，则是我们想要的true，是0，则是因为除不尽
		//当然还有可能是其他乱七八糟的数
		return n==1;
	}//public boolean isUgly(int n)


}
