package 代码随想录.贪心算法;

import java.util.Arrays;

public class _435无重叠区间_相交取左 {
    /**
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
       // 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
        //跟前面那个扎气球很类似，452，
        //，Arrays.sort去对第一号位排序，
        //超过了交集，则++
        //没超过交集，则选取交集右端点中的最小值，作为当前整体交集的最右端
        Arrays.sort(intervals,(a,b) -> {
            return Integer.compare(a[0],b[0]);
        });
        int count = 1;
        for (int i = 1;i < intervals.length;i++){
            if (intervals[i][0] < intervals[i-1][1]){
                intervals[i][1] = Math.min(intervals[i-1][1],intervals[i][1]);
                continue;
            }else {
                //只需要知道有几个位置即可，连基本的插入到哪里都不需要告知。
                count++;
            }
        }
        return intervals.length - count;
    }
}
