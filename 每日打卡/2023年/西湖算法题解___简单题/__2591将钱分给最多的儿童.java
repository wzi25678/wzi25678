package 西湖算法题解___简单题;

public class __2591将钱分给最多的儿童 {
	public static void main(String[] args) {

	}

	public int distMoney(int money, int children) {
		if (money < children){
			return -1;
		}

		//刚好的情况
		if (money == 8*children){
			return children;
			//钱有多的情况
		} else if (money > 8*children) {
			return children-1;
		}

		//钱不够的情况
				//先确保每个人都得有基本的一块钱
		money  -= children;
		int max_maybe = money/7;
		if (money % 7 == 3){
			//mod==3,还要去考虑是不是刚好又只剩最后一个空
			return max_maybe == children - 1 ? max_maybe -1 : max_maybe;
		}
		return max_maybe;



	}//public int distMoney(int money, int children)
}
