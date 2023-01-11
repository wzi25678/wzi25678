public class Test34 {
	public static void main(String[] args) {
		List<List<Integer>> resultList = permute(new int[] { 1, 2, 3 });
		System.out.println(resultList);
	}

	/**
	 * 全排列
	 * 
	 * @param nums 源数组
	 * @return
	 */
	public static List<List<Integer>> permute(int[] nums) {
		int len = nums.length;// 数组长度
		List<List<Integer>> res = new ArrayList<>();// 结果集
		if (len == 0) {
			return res;
		}

		// 栈：已经被选择的数存入栈中
		Stack<Integer> path = new Stack<Integer>();
		// 布尔数组：表示那些数是被选择过了
		boolean[] used = new boolean[len];
		// 回溯 + 深度优先
		dfs(nums, len, 0, path, used, res);
		
		return res;
	}

	/**
	 * 回溯 + 深度优先
	 * 
	 * @param nums  源数组
	 * @param len   源数组长度
	 * @param depth 深度：递归到了第几层
	 * @param path  栈：已经被选择的数存入栈中
	 * @param used  布尔数组：表示那些数是被选择过了
	 * @param res   结果集
	 */
	private static void dfs(int[] nums, int len, int depth, Stack<Integer> path, boolean[] used,
			List<List<Integer>> res) {
		// 达到最大深度
		if (depth == len) {
			res.add(new ArrayList<Integer>(path));// 添加栈中已选择的数到结果集
			return;
		}

		for (int i = 0; i < len; i++) {
			if (used[i]) {// 如果该数已经选择过了，则跳过本次循环，继续执行下次循环
				continue;
			}
			// 将nums[i]存入path栈中
			path.push(nums[i]);
			// 将下标i对应的数设置为已经被选择
			used[i] = true;
			// 回溯：深度+1
			dfs(nums, len, depth + 1, path, used, res);
			// 状态重置
			path.pop();
			used[i] = false;
		}
	}
}
