package 代码随想录.字符串;

public class __459重复的子字符串_枚举 {
    //给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
    /**
    方法一： 双重for循环，其中一个for循环，用i，j记录起始，截止位置；；另一个for循环，用于剩余的j到结尾。
     */
    public boolean repeatedSubstringPattern(String s) {
        /*
        提示：
            1 <= s.length <= 104
            s 由小写英文字母组成
        解法1：调用KMP算法/暴力for循环？，将一个部分，分成从[0,i]和[i+1,s.length-1]的两个子串。
         */
        int n = s.length();
        for (int i = 1;i*2 <= n;i++){   //要能够匹配，最多只能遍历一般即可。
            if (n % i == 0){    //把i作为匹配对象
                boolean match = true;
                for (int j = i;j < n;j++){     //j是匹配位置
                    if (s.charAt(j)!= s.charAt(j-i)){   //同步j-i位置。【i为配对对象】
                        match = false;
                        break;
                    }
                }
                if (match){
                    return true;
                }
            }
        }
        return false;
    }
}
