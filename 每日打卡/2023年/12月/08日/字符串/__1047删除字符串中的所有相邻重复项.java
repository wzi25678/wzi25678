package 代码随想录.字符串;

import java.util.ArrayDeque;
import java.util.Deque;

public class __1047删除字符串中的所有相邻重复项 {
    /**
     *重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     *
     * 题解：  可以考虑用栈的思想去解决这道题
     *
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.peek() == ch && !stack.isEmpty()) {   //当前栈顶的头部
                stack.poll();
            }else{
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb = sb.reverse();
        return sb.toString();
    }
}
