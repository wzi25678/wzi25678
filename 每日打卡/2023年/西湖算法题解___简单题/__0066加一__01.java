package 西湖算法题解___简单题;

public class __0066加一__01 {
	public static void main(String[] args) {
		int digits[]={1,2,3};
		plusOne(digits);
	}

	private static int[] plusOne(int[] digits) {
		String str="" ;
		for (int i=0;i<digits.length;i++){
			str+=digits[i];
		}
		System.out.println(str);
		System.out.println("===========================================");
		int a = Integer.parseInt(str)+1;
		System.out.println("a:"+a);
		String new_str = a+"";
		int n = new_str.length();
		int ans_arr[] = new int[n];
		int mod = a;
		for (int i=n;i>0;i--){
			ans_arr[n-i]/=Math.pow(10,n-i+3);
			System.out.print(ans_arr[n-i]);
			mod%=10;
		}
//		for (int i=0;i<new_str.length();i++){
//			System.out.println(str_length[i]);
//			System.out.println("---------");
//		}

		return ans_arr;
	}

}
