package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.List;

public class __673最长递增子序列的个数__贪心_前缀和_二分查找 {

	public int findNumberOfLIS(int[] nums){
		List<List<Integer>> d = new ArrayList<List<Integer>>();
		List<List<Integer>> cnt = new ArrayList<List<Integer>>();
		for (int v : nums){
			int i = myBinarySearch1(d.size(),d,v);
			int c = 1;
			if (i > 0){
				int k = myBinarySearch2(d.get(i-1).size(),d.get(i-1),v);
				c = cnt.get(i-1).get(cnt.get(i-1).size()-1) - cnt.get(i-1).get(k);
			}
			if (i == d.size()){
				List<Integer> dList = new ArrayList<Integer>();
				dList.add(v);
				d.add(dList);
				List<Integer> cntList = new ArrayList<Integer>();
				cntList.add(0);
				cntList.add(c);
				cnt.add(cntList);
			}else {
				d.get(i).add(v);
				int cntSize = cnt.get(i).size();
				cnt.get(i).add(cnt.get(i).get(cntSize-1)+c);
			}
		}
		int size1 = cnt.size(),size2 = cnt.get(size1-1).size();
		return cnt.get(size1 - 1).get(size2-1);
	}

	/**
	 *
	 * @param n
	 * @param list
	 * @param target
	 * @return
	 */
	private int myBinarySearch2(int n, List<Integer> list, int target) {
		int left = 0,right = n;
		while (left < right){
			int mid = (left + right) /2;
			if (list.get(mid) < target){
				right = mid;
			}else {
				left = mid + 1;
			}
		}
		return left;
	}

	/**
	 * 
	 * @param n
	 * @param d
	 * @param target
	 * @return
	 */
	private int myBinarySearch1(int n, List<List<Integer>> d, int target) {
		int left = 0,right = n;
		while (left < right){
			int mid = (left + right) /2;
			List<Integer> list = d.get(mid);
			if (list.get(list.size() - 1) >= target){
				right = mid;
			}else {
				left = mid + 1;
			}
		}
		return left;
	}
}
