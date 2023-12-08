package 代码随想录.树.一般数_森林;

import 代码随想录.树.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;



public class N叉树的层序遍历 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        Deque<Node> queue = new ArrayDeque<Node>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.pollFirst();
                level.add(node.val);
                if (node.children!= null) {
                    for (Node child : node.children) {
                        queue.offerLast(child);
                    }
                }
            }
            result.add(level);
        }
        return result;
    }
}
