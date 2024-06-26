package 西湖算法题解___中等题;

public class __11_盛最多水的容器 {
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {

	}//public static void main(String[] args)

	/**
	 * 又想越远越好，又想越大越好？
	 *      怎么兼顾呢？
	 *
	 *
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
		//left和right表示的是下标
		int left = 0,right = height.length-1;
		int res = 0;
		while (left<right){
			int area = Math.min(height[left],height[right]) * (right-left);
			res = Math.max(area,res);
			//获取完本轮的area，并和最大区域做对比之后，开始进行移动收缩
			//   area = min(left,right)  *  (right-left)
			//          距离会随着我们每次移动而减小，所以我们要做的就是找更大的min，就是说对 min(left,right)中小的，采取移动策略
			if (height[left] <= height[right]){
				//如果左边小，则左边需要尝试去找更大的
				left++;
			}else{
				right--;
			}
		}//while (left<right)
		return res;
	}//public int maxArea(int[] height)

}
