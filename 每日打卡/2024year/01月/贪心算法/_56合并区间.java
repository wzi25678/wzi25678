package 代码随想录.贪心算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _56合并区间 {
    /**
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        // TODO 整合所有的重叠区间
        //跟之间找重叠区间类似，这回主要是你还要确定好当前重叠区间的【最左端边界】以及【最右端边界】
        //[[1,6],[8,10],[15,18]]  返回的是多个二位数字，因为你一开始并不知道答案的长度，所以就得等后期链表转数组
        List<int []> result = new LinkedList<int[]>();
        Arrays.sort(intervals,(a, b) -> {
            return Integer.compare(a[0],b[0]);
        });
        //这道题主要还是针对每一个重叠区域，你还得记录它的最左边边界，以及最右端边界
        int leftEdge = intervals[0][0];
        int rightEdge = intervals[0][1];
        for (int i = 1;i< intervals.length;i++){
            //如果【下一个的左边界】大于了当前的【最右端边界】，那么所有需要产生出一个新的区间
            if (intervals[i][0] > rightEdge){
                //加入区间链表中，并更新leftEdge, rightEdge
                result.add(new int [] {leftEdge, rightEdge});
                leftEdge = intervals[i][0];
                rightEdge = intervals[i][1];
            }else {
                //比较更新当前左右区间
                leftEdge = Math.min(leftEdge,intervals[i][0]);
                rightEdge = Math.max(rightEdge,intervals[i][1]);
            }
        }
        //最后的单独退出来了，给他补上算一个区间
        result.add(new int[]{leftEdge,rightEdge});
        return result.toArray(new int[result.size()][2]);
    }
}
