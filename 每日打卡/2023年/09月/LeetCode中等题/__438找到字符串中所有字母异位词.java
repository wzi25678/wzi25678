package LeetCode中等题;

import java.util.ArrayList;
import java.util.List;

public class __438找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        findAnagrams("abab","ab");
        for (int num : res){
            System.out.print(num + " ");
        }
    }
    static List<Integer> res = new ArrayList<>();  //最终答案记录的是索引下标
    static List<String> ans = new ArrayList<>();   //所以再构造一个ans去记录所有字符串全排列结果

    public static List<Integer> findAnagrams(String s, String p) {
        /*
        解题思路：
            其中s是需要去接受检验的字符串
            p是需要去全排列的字符串List

        for循环遍历一圈，从第一个需要遍历到第s-p个（小于）
        然后每次去获取对应p个数量级，构成一个List，去与p构成的List全排列集合去进行对比，看是否满足题意。

        需要的东西：
        List<Integer> res  答案
        List<List<Character>>   p的全排列集合
         */
        char charsArray [] = p.toCharArray();
        int pLength = charsArray.length;
        int sLength = s.length();
//        int PermuteNum = 1;
//        for (int i=1;i<=pLength;i++){
//            PermuteNum*=i;
//        }
//        boolean isVisited[] = new boolean[PermuteNum];
        if (sLength < pLength){
            return res;
        }
        //先算出p的全排列情况，再进入for循环去操作
        permute(charsArray,0,ans);
        for (String anss :ans){
            System.out.print(anss+" ");
        }
        System.out.println();
        //接下来进行指定范围内的for循环判断
        for (int i=0;i<=sLength-pLength;i++){
            String compChars = "";
            for (int j=i, a = 0;a<pLength;j++,a++){
                compChars+=s.charAt(j);
            }
            //对比的时候害得考虑去重
            int index = 0;
            for (String compare:ans){
                if (compChars.equals(compare)){
                    res.add(i);
                    break;
                }
            }
//            for (String compare:ans){
//                if (compChars.equals(compare)){     //相等，则说明它满足全排列的情况之一
//                    if (isVisited[index] == false){
//                        isVisited[index] = true;
//                        res.add(i);
//                    }
//                    break;
//                }
//                index++;
//            }
        }
        return res;

    }

    /**
     *
     * @param charsArray        //需要全排列的数组
     * @param index     //当前轮次排序位置
     * @param ans       //记录排序结果
     */
    private static void permute (char[] charsArray, int index, List<String> ans) {
        if (index == charsArray.length-1){
            ans.add(new String(charsArray));
        }
        //没达到规定长度，则说明还需要进行全排列
        for (int i = index;i<charsArray.length;i++){    //每一次接收到的index都是不同的，它代表当前已经达到的长度
            Myswap(charsArray,index,i); //当前的i与每一个index交换一下位置
            permute(charsArray,index+1,ans);
            Myswap(charsArray,index,i); //再把位置交换回来
        }
    }

    /**
     *
     * @param chars
     * @param i
     * @param i
     */
    private static void Myswap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
