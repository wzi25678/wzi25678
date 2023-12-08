package 代码随想录.树.一般数_森林;

import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class _559N叉树的最大深度_dfs {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        for (Node child : root.children) {
            int depth = maxDepth(child);
            maxDepth = Math.max(maxDepth, depth);
        }
        return maxDepth+1;
    }
}
