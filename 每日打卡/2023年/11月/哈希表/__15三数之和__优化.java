package 日常Java程序测试.代码随想录.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class __15三数之和__优化 {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<>();
		int n = nums.length;
		for (int i = 0; i < n - 2; ++i) {
			int x = nums[i];
			if (i > 0 && x == nums[i - 1]) {
				continue; // 跳过重复数字
			}
			if (x + nums[i + 1] + nums[i + 2] > 0) {
				break; // 优化一
			}
			if (x + nums[n - 2] + nums[n - 1] < 0) {
				continue; // 优化二
			}
			int j = i + 1, k = n - 1;
			while (j < k) {
				int s = x + nums[j] + nums[k];
				if (s > 0) {
					--k;
				}
				else if (s < 0) {
					++j;
				}
				else {
					//List.of（） 生成不可变数组（字符串也行）
					// 是在jdk1.8以后才出现的，在jdk1.9版本及以后才能运行。 所以用1.8的盆友是不会代码补全的
					//ans.add(List.of(x, nums[j], nums[k]));
					for (++j; j < k && nums[j] == nums[j - 1]; ++j){}; // 跳过重复数字
					for (--k; k > j && nums[k] == nums[k + 1]; --k){}; // 跳过重复数字
				}
			}
		}
		return ans;
	}
}
