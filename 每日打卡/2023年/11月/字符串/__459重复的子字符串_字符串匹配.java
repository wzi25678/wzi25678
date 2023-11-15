package 代码随想录.字符串;

public class __459重复的子字符串_字符串匹配 {
    /**
     * 调用方法进行配对
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s){
       return (s+s).indexOf(s,1) != s.length(); //判断是否能在s.length()长度之前，且从第二个元素开始，索引到我们需要判断的重复子串s
    }
}
