package 代码随想录.树.一般数_森林;

import 代码随想录.树.Node;

import java.util.*;

public class _590N叉树的后序遍历_迭代 {
    /**
     *
     */
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Map<Node, Integer> map = new HashMap<Node, Integer>();
        Deque<Node> myStack = new ArrayDeque<Node>();
        Node node = root;
        while (!myStack.isEmpty() || node!= null) {
            while (node != null){
                //myStack.add(node);//add方法等于addLast
                myStack.push(node); //push方法等于addFirst
                List<Node> children = node.children;
                if (children!= null && children.size() > 0) {
                    map.put(node,0);
                    node = children.get(0);
                }else {
                    node = null;
                }
            }
            node = myStack.peek();
            int index = map.getOrDefault(node,-1) + 1;
            List<Node> children = node.children;
            if (children!= null && children.size() > index) {
                map.put(node, index);
                node = children.get(index);
            }else {
                result.add(node.val);
                myStack.pop();
                map.remove(node);
                node = null;
            }
        }
        return result;
    }
}
