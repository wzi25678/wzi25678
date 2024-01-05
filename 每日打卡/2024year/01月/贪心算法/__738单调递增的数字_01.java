package 代码随想录.贪心算法;

import java.util.Arrays;

public class __738单调递增的数字_01 {
    /**
     *
     * @param n
     * @return
     */
    public int monotoneIncreasingDigits(int n) {
//        String s1 = n+"";
//        System.out.println(s1);
        String [] str = (n+"").split("");
        //System.out.println(str);
        //System.out.println(Arrays.toString(str));
        int start = str.length;
        for (int i = str.length - 1; i > 0; i--) {
            if (Integer.parseInt(str[i]) < Integer.parseInt(str[i-1])){
                str[i-1] = (Integer.parseInt(str[i]) - 1)+"";
                start = i;
            }
        }
        for (int i = start; i<str.length;i++){
            str[i] = "9";
        }
        return Integer.parseInt(String.join("",str));
    }
}
