package 西湖算法题解___中等题;

public class __334递增的三元子序列 {
	public boolean increasingTriplet(int[] nums) {
		//子序列的三个元素在原数组中可以不是连续的。
		int  n =nums.length;
		if (n<=2){
			return false;
		}
		/*
		想要在O（n）的条件下，完成，那么必然就是一次遍历搞定。
		那么最好的办法就是去一直维护住一个【A<B】的情况：此时出现的下一个作为c
			-如果c>B,则true
			-如果c>A，则B=c
			-如果C<A,则重新构建一个【   】。
				-这时会产生一种特殊情况：   举个例子：   [9,10,1,11]
									会造成，firstBig = 1，secondBig=10
				-此时如果下一个大于> secondBig，则会构成，9,10,11连续递增，即之前的firstBig还在起作用
				-此时如果下一个不大于secondBig，则会替换掉secondBig，或者重新再找一个firstBig，逻辑正确
		 */
		int firstBig=nums[0],secondBig= Integer.MAX_VALUE;      //题目有限制数的大小
		for (int i =1;i<n;i++){
			int temp = nums[i];
			if (temp > secondBig){      //更大
				return true;
			} else if (temp > firstBig) {       //大
				secondBig = temp;
			}else {
				//最小
				firstBig = temp;
			}
		}
		return false;
	}
}
