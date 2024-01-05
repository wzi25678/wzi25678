package 代码随想录.贪心算法;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class _406根据身高重建队列_队列排序 {
    /**
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        //TODO 先按身高h从大到小排序，然后按照后面的第二个k的要求，满足其指定前面要有几个元素的要求进插入。
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int people1 [] ,int people2 []){
                if (people1[0] == people2[0]){
                    return people1[1] - people2[1];     // a - b 是升序排列，故在a[0] == b[0]的狀況下，會根據k值升序排列
                }
                return people2[0] - people1[0];
            }
        });
        LinkedList<int []> myQueue = new LinkedList<int []>();
        for (int [] person : people){
            myQueue.add(person[1],person);
        }
        return myQueue.toArray(new int[people.length][]);
    }
}
