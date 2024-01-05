package 代码随想录.贪心算法;

import java.util.Arrays;

public class _452用最少数量的箭引爆气球 {
    public int findMinArrowShots(int[][] points) {
        // TODO 按起始位置排序，来确定是否存在交叉区间，然后就是和406类似，Arrays.sort去对第一号位排序
        Arrays.sort(points, (a,b) ->  Integer.compare(a[0], b[0]));
        int result = 1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] > points[i-1][1]){ //超过了交集，则++
                result++;
            }else {
                //没超过交集，则选取交集右端点中的最小值，作为当前整体交集的最右端
                points[i][1] = Math.min(points[i][1],points[i-1][1]);
            }
        }
        return result;
    }
}
