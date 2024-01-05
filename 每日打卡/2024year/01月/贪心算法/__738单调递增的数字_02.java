package 代码随想录.贪心算法;

public class __738单调递增的数字_02 {
    public int monotoneIncreasingDigits(int n){
        String str = String.valueOf(n);
        char ch [] = str.toCharArray();
        int start = str.length();   //记录字符串长度，如果超过了9，则后面得字符，均调整为9，因为题目要求小于等于即可，<= 即可。
        for (int i = str.length() - 2;i>=0;i--) {
            if (ch[i] > ch[i+1]) {
                ch[i]--;
                start = i + 1;
            }
        }
        for (int i = start;i<str.length();i++) {
            ch[i] = '9';
        }
        return Integer.parseInt(String.valueOf(ch));
    }
}
