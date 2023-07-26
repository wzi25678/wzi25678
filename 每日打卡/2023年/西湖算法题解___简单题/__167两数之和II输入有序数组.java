package 西湖算法题解___简单题;

public class __167两数之和II输入有序数组 {

	public static void main(String[] args) {
		int numbers[] =  new int[] {3,24,50,79,88,150,345};
		int target = 200;
		twoSum(numbers,target);

	}

	/**
	 * 现在还是个菜鸡，主要以解出来为主，未来在尝试其他。。。。
	 * 1.暴力法
	 * 2.暴力是考虑到有序的特点，采用从右折中的方式，利用到了有序数组的特点
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static  int[] twoSum(int[] numbers, int target) {
		int res [] = new int[2];    //返回一个包含两个值结果的数组答案
		for (int i=0;i<numbers.length;i++){
			//i从小到大取，j从大到小取
			for (int j=numbers.length-1;j>i;j--){
				//分三种情况进行考虑
				System.out.printf("当前的i为：%d,其对应的值为: %d\n",i,numbers[i]);
				System.out.printf("当前的j为：%d,其对应的值为: %d\n",j,numbers[j]);
				System.out.println("------------------------------------------");
				if (numbers[i]+numbers[j] < target) {       //如果小于，则需要换个i
					/**
					 * 这段代码的一个很大的问题就在于没有固定每一次进行判断的边界
					 */
					break;
				} else if (numbers[i]+numbers[j] == target){
					System.out.println("有返回值");
					return res = new int [] {i+1,j+1};
				}else {
					int mid = i+(j-i)/2;
					j=mid+1;
				}
			}//for (int j=numbers[numbers.length-1];j>i;j--)
		}//for (int i=0;i<numbers.length;i++)
		System.out.println("没有返回值");
		return res = new int [] {-1,-1};
	}//public int[] twoSum(int[] numbers, int target)
}
