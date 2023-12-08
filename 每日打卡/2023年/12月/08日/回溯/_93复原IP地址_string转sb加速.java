package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.List;

public class _93复原IP地址_string转sb加速 {
    List<String> result = new ArrayList<String>();

    /**
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder(s);
        backTrack(sb,0,0);
        return result;
    }
    /**
     *
     * @param sb
     * @param startUsedIndex
     * @param pointNum
     */
    private void backTrack(StringBuilder sb, int startUsedIndex,int pointNum) {
        //如果是打了三个逗号，那么后面的不可变了，就固定式这个数
        if (pointNum == 3){
            if (isVaild(sb,startUsedIndex,sb.length()-1)){
                result.add(sb.toString());
            }
            return;
        }
        for (int i = startUsedIndex;i<sb.length();i++){
            //判断当前选取位置的子串,能否构成有效的IP地址
            if (isVaild(sb,startUsedIndex,i)){
                sb = new StringBuilder(sb.substring(0, i + 1) + "." + sb.substring(i + 1));    //在str的后⾯插⼊⼀个逗点
                pointNum++;
                backTrack(sb,i+2,pointNum);  // 插⼊逗点之后下⼀个⼦串的起始位置为i+2
                pointNum--;
                sb = new StringBuilder(sb.substring(0, i + 1) + sb.substring(i + 2));  // 回溯删掉逗点
            }else {
                break;
            }
        }
    }

    /**
     *
     * @param s
     * @param left
     * @param right
     * @return
     */
    private boolean isVaild(StringBuilder s, int left, int right) {
        if (left > right){
            return false;
        }
        if (s.charAt(left) == '0' && left != right){
            return false;
        }
        int num = 0;
        for (int i = left;i<=right;i++){
            if (s.charAt(i) > '9' || s.charAt(i) <'0'){
                return false;
            }
            num = num*10 + (s.charAt(i) - '0');
            if (num > 255){
                return false;
            }
        }
        return true;
    }
}
