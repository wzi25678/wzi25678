package 代码随想录.贪心算法;

import java.util.Arrays;
import java.util.Comparator;

public class _406根据身高重建队列_从低到高 {
    /**
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        // TODO 有多个维度需要考虑的题目，那必然只能先考虑一个维度，再依次选择其他的维度逐个考虑
        Arrays.sort(people,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //先比较身高，身高从低到高排序;然后在身高相同的情况下，按序号从高到低排序
                if (o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }else {
                    return o2[1] - o1[1];
                }
            }
        });
        int res [][] = new int[people.length][];
        for (int [] person : people){
            int spaces = person[1] + 1;
            for (int i=0;i< people.length;i++){
                if (res[i] == null){
                    spaces--;
                    if (spaces == 0){
                        res[i] = person;
                        break;
                    }
                }
            }
        }
        return res;
    }
//    public int[][] reconstructQueue(int[][] people) {
//        Arrays.sort(people, new Comparator<int[]>() {
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] != o2[0]) {
//                    return o1[0] - o2[0];
//                } else {
//                    return o2[1] - o1[1];
//                }
//            }
//        });
//        int[][] res = new int[people.length][];
//        for (int[] person : people) {
//            int spaces = person[1] + 1;
//            for (int i = 0; i < people.length; ++i) {
//                if (res[i] == null) {
//                    --spaces;
//                    if (spaces == 0) {
//                        res[i] = person;
//                        break;
//                    }
//                }
//            }
//        }
//        return res;
//    }
}
