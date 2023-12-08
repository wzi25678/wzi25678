package 代码随想录.栈与队列;

import java.util.ArrayDeque;
import java.util.Deque;

public class __71简化路径 {
    /**
     * 输入一个路径名，将其转化成一个合法的完整路径，使得路径中的每个部分都是有效的。
     *
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String [] names = path.split("/");
        Deque<String> myStack = new ArrayDeque<String>();
        for (String name : names) {
            if (name.equals("..")) {
                if (!myStack.isEmpty()) {
                    myStack.pop();  //pop = pollLast
                }
            } else if (name.length() > 0 && !name.equals(".")) {
                myStack.push(name); //push = pollLast
            }
        }
        // 全部对last进行poll或者offer就是栈的形式，想想一下
        StringBuilder sb = new StringBuilder();
        while (!myStack.isEmpty()) {
            sb.append("/").append(myStack.pollLast());
        }
        return sb.length() == 0? "/" : sb.toString();
    }
}
