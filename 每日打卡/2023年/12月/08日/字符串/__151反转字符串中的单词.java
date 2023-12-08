package 代码随想录.字符串;

public class __151反转字符串中的单词 {
    /**
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        //给你一个字符串 s ，请你反转字符串中 单词 的顺序。
        /*
        输入: "  hello world!  "
        输出: "world! hello"
        符号会跟随当前的单词
         */
        String[] str = s.split(" ");
        for (String str2 : str) {
            System.out.println(str2);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i]!= ""){
                sb.append(str[i]);
                sb.append(" "); //每一个空间加一个space
            }

        }
        return sb.toString().trim();    //是用于去除字符串两端的空白字符
    }
}
