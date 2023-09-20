package LeetCode中等题;

public class __686重复叠加字符串匹配__暴力解法__直接调用函数 {
    public static void main(String[] args) {
        System.out.println(  repeatedStringMatch("abcabc","abc"));
    }
    public static int repeatedStringMatch(String a, String b) {
        /*
        寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。

        字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。

         1 <= a.length <= 10^4
         1 <= b.length <= 10^4
         */
        /**
         解题思路：
            先找到那个长，那个短
            然后我们再进行测试，去进行匹配

            “”space代表0格。
            一份代表1格
            二份代表2格
            没有匹配的话，就对应-1

         题目的意思是a字符串重复多少次，可以实现包含有字符串b
         寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串

         卧槽，看到题解之后，发现这他妈不就是传说中的KMP算法
         */
        int res = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int maxLength = 2*a.length()+b.length();    //这样就可以形成一个aba形式的字符串，
        // 我们也就不必去考虑是a长，还是b长。
        /**
         * 输入：a = "abc", b = "wxyz"
         * 输出：-1
         */
        while (stringBuilder.length()  <  maxLength){  //只要还没达到长度，就说明还需要进行探测
            stringBuilder.append(a);
            res++;
            if (stringBuilder.toString().indexOf(b) != -1){         //找到了返回索引位置，没找到返回-1
                return res;
            }
        }
        return -1;
    }
}
