package 代码随想录.树.二叉树的遍历.层次遍历;

import java.util.ArrayDeque;
import java.util.Queue;

public class _117填充每个节点的下一个右侧节点指针II_层次遍历 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        Queue <Node> queue = new ArrayDeque<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Node lastNode = null;
            for (int i = 1;i<=levelSize;i++){
                Node node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                if (i != 1){
                    lastNode.next = node;
                }
                lastNode = node;
            }
        }
        return root;
    }
}
