package 西湖算法题解___中等题;

import java.util.ArrayList;

public class __60排列序列__0703 {
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param n
	 * @param k
	 * @return
	 */
	public String getPermutation(int n, int k) {
		int nums[] = new int[n];    //生成nums数组
		//生成[1,n]的数组
		for (int i=0;i<n;i++){
			nums[i] = i+1;
		}
		boolean used[] = new boolean[n];    //记录当前的索引的数是否被使用过
		return dfs(nums,new ArrayList<String>(),used,0,n,k).replace(" ","").toString();
	}//public String getPermutation(int n, int k)

	/**
	 *
	 * @param nums
	 * @param levelList
	 * @param used
	 * @param depth
	 * @param n
	 * @param k
	 * @return
	 */
	private String dfs(int[] nums, ArrayList<String> levelList, boolean[] used, int depth, int n, int k) {
		if (depth == n){    //触发出口条件，开始收集结果集
			StringBuilder result = new StringBuilder();
			for (String str:levelList){
				result.append(str);
			}
			return result.toString();
		}

		int cur = factorial(n-depth-1); //当前的depth也就是索引，有多少排列数
		for (int i=0;i<n;i++ ){
			if (used[i]){   //如果使用过，那就跳过
				continue;
			}
			if (cur < k){
				k-=cur;
				continue;
			}
			levelList.add(nums[i]+" " );    //list收的是String类型
			used[i] = true;     //当前元素被使用过标记
			return dfs(nums,levelList,used,depth+1,n,k);
		}
		return null;
	}

	/**
	 *
	 * @param n
	 * @return
	 */
	private int factorial(int n) {
		int res = 1;
		while (n > 0){
			res*=n;
			n--;
		}
		return res;
	}
}
