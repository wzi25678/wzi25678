package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.List;

public class _93复原IP地址 {
    List<String> result = new ArrayList<String>();
    /*
    输入：s = "101023"
    输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
     */
    /**
     * 模拟+回溯+判断有效
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        backTrack(s,0,0);
        return result;
    }

    /**
     *
     * @param s
     * @param startUsedIndex
     * @param pointNum
     */
    private void backTrack(String s, int startUsedIndex,int pointNum) {
        //如果是打了三个逗号，那么后面的不可变了，就固定式这个数
        if (pointNum == 3){
            if (isVaild(s,startUsedIndex,s.length()-1)){
                    result.add(s);
            }
            return;
        }
        for (int i = startUsedIndex;i<s.length();i++){
            //判断当前选取位置的子串,能否构成有效的IP地址
            if (isVaild(s,startUsedIndex,i)){
                s = s.substring(0,i+1)+"."+s.substring(i+1);    //在str的后⾯插⼊⼀个逗点
                pointNum++;
                backTrack(s,i+2,pointNum);  // 插⼊逗点之后下⼀个⼦串的起始位置为i+2
                pointNum--;
                s = s.substring(0,i+1) + s.substring(i+2);  // 回溯删掉逗点
            }else {
                break;
            }
        }
    }

    private boolean isVaild(String s, int left, int right) {
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
