package 代码随想录.贪心算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _763划分字母区间 {
    /**
     * 要求：
     *    1.片数尽可能多
     *    2.返回每一片的数量
     *    3.按照原来的顺序，且每种单词只能出现在某一个片中
     *
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
       /*可以分为如下两步：
       （1）当前位置      （2）当前元素出现的最远位置
        1.统计每一个字符最后出现的位置
        2.从头遍历字符，并更新字符的最远出现下标，如果找到字符最远出现位置下标和当前下标相等了，则找到了分割点
       */
        List<Integer> lists = new LinkedList<Integer>();
        int edges [] = new int[26];
        char [] chars = s.toCharArray();
        for (int i = 0;i< chars.length;i++){
            //先记录下每个元素的最后出现位置
            edges[chars[i] - 'a'] = i;
        }
        int index = 0;
        int last = -1;
        for (int i = 0;i<chars.length;i++){
            index = Math.max(index,edges[chars[i] - 'a']);
            if (i == index){
                lists.add(i - last);
                last = i;
            }
        }
        return lists;
    }
}
