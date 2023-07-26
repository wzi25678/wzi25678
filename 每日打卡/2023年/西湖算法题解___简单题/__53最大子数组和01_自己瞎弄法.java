package 西湖算法题解___简单题;

public class __53最大子数组和01_自己瞎弄法 {
	public static void main(String[] args) {

	}

	public int maxSubArray(int[] nums) {
		int Count_max = 0;
		int start_col = 0;  //相当于一个指针的作用
		int flag = 0;   //1代表已经有头了，0代表还没有头
		int temp = 0;

		for (int i=0;i< nums.length;i++){
			if (flag == 0){     //还没有头，开始找头
				if (nums[i] >0){    //满足找头条件
					temp = nums[i];
					start_col = i;
					flag = 1;
				}else {
					//不满足开头是负数
					continue;
				}
			}
			//已经找到了头，开始确定最大数组长度,,,,即计数
			temp+=nums[i];
			if (temp < 0){
				flag = 0;   //都负数了，没有意义
				continue;
			}
			if (temp>Count_max){
				Count_max = temp;
			}
		}
		return Count_max;
	}
}
