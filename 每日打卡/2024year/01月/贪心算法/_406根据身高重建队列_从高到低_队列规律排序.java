package 代码随想录.贪心算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _406根据身高重建队列_从高到低_队列规律排序 {
    public int[][] reconstructQueue(int[][] people) {
        // TODO 有多个维度需要考虑的题目，那必然只能先考虑一个维度，再依次选择其他的维度逐个考虑
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //先比较身高，身高从高到低排序;然后在身高相同的情况下，按序号从低到高排序
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        List<int []> result = new ArrayList<int[]>();
        for (int person [] : people) {
            result.add(person[1],person);
        }
        return result.toArray(new int [result.size()][2]);
    }
}
