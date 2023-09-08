package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class __56合并区间__01 {
	public int[][] merge(int[][] intervals) {
		if (intervals.length == 0){
			return new int[0][2];
		}
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		List<int []> merged = new ArrayList<int[]>();
		for (int i=0;i<intervals.length;i++){
			int left = intervals[i][0],right = intervals[i][1];
			if (merged.size()==0 || merged.get(merged.size() -1)[1] <left){
				merged.add(new int[]{left,right});
			}else {
				merged.get(merged.size() - 1)[1] = Math.max((merged.get(merged.size()-1)[1]),right);
			}
		}
		return merged.toArray(new int[merged.size()][]);
	}
}
