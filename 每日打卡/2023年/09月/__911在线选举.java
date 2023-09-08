package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class __911在线选举 {
	//给你两个整数数组 persons 和 times 。在选举中，第 i 张票是在时刻为 times[i] 时投给候选人 persons[i] 的。

	/*
	实现 TopVotedCandidate 类：
	TopVotedCandidate(int[] persons, int[] times) 使用 persons 和 times 数组初始化对象。
	int queue(int t) 根据前面描述的规则，返回在时刻 t 在选举中领先的候选人的编号。
	 */
	class TopVotedCandidate {
		List<Integer> tops;
		Map<Integer,Integer> voteCounts;
		int times [];
		/**
		 题目解释：
		    前两个长的数组，第一个代表投给谁，第二个代表在什么时间投
		    后面一堆一个一个数组时间，代表要你返回在哪个时间，哪个人会赢？

		 * Your TopVotedCandidate object will be instantiated and called as such:
		 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
		 * int param_1 = obj.q(t);

		 * @param persons
		 *
		 *
		 * @param times
		 */
		//TopVotedCandidate(int[] persons, int[] times) 使用 persons 和 times 数组初始化对象。
		public TopVotedCandidate(int[] persons, int[] times) {
			tops = new ArrayList<Integer>();
			voteCounts = new HashMap<Integer,Integer>();
			voteCounts.put(-1,-1);
			int top = -1;
			for (int i=0;i< persons.length;i++){
				int p = persons[i];
				voteCounts.put(p,voteCounts.getOrDefault(p,0)+1);
				if (voteCounts.get(p) >= voteCounts.get(top)){
					top = p;
				}
				tops.add(top);
			}
			this.times = times;
		}

		//int queue(int t) 根据前面描述的规则，返回在时刻 t 在选举中领先的候选人的编号。
		public int q(int t) {
			int left = 0,right = times.length - 1;
			//找到满足times[left] <= t的最大的left
			while (left<right){
				int mid = left + (right - left +1)/2;
				if (times[mid] <= t){
					left = mid;
				}else {
					right = mid - 1;
				}
			}
			return tops.get(left);
		}
	}

}
