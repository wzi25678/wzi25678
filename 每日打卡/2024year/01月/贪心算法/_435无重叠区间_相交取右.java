package 代码随想录.贪心算法;

import java.util.Arrays;

public class _435无重叠区间_相交取右 {
    /**
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a, b) -> {
            return Integer.compare(a[0],b[0]);
        });
        int removed = 0;
        int prev = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (prev > intervals[i][0]){
                removed++;
                prev = Math.min(prev, intervals[i][1]);
            }else {
                prev = intervals[i][1];
            }
        }
        return removed;
    }
}
