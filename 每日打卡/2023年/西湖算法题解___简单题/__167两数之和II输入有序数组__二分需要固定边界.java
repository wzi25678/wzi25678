package 西湖算法题解___简单题;

public class __167两数之和II输入有序数组__二分需要固定边界 {
	public static void main(String[] args) {
		int numbers[] =  new int[] {2,3,4};
		int target = 6;
		twoSum(numbers,target);

	}
	public static  int[] twoSum(int[] numbers, int target){
		int res [] = new int[2];    //返回一个包含两个值结果的数组答案
		for (int i=0;i<numbers.length;i++){
			int lower = i+1,higher = numbers.length-1;
			while (lower<=higher){
				int mid = lower +(higher-lower)/2;
				System.out.printf("当前的lower为：%d,其对应的值为: %d\n",lower,numbers[lower]);
				System.out.printf("当前的higher为：%d,其对应的值为: %d\n",higher,numbers[higher]);
				System.out.printf("当前的mid为：%d,其对应的值为: %d\n",mid,numbers[mid]);
				System.out.println("------------------------------------------------------------");
				if (numbers[mid] + numbers[i] == target ){
					System.out.printf("输出了：%d 和 %d",i+1,mid+1);
					return res = new int [] {i+1,mid+1};
				} else if (numbers[mid] + numbers[i] > target) {
					//如果low+mid大于target，则说明mid大了

					higher = mid-1;
				}else{
					//相反则说明low小了
					lower = mid+1;
				}
			}//while (lower<=higher)
		}//for (int i=0;i<numbers.length;i++){
		System.out.println("失败了");
		return res = new int [] {-1,-1};

	}

}
