package 西湖算法题解___简单题;

public class __0066加一__02 {
	public static void main(String[] args) {

	}

	public int[] plusOne(int[] digits){
		for (int i=digits.length-1;i>=0;i--){
			if (digits[i] != 9){
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}

		//如果到这一步则说明数字全部都属9
		int temp[]  = new int[digits.length+1];
		temp[0] = 1;
		return temp;
	}

}
