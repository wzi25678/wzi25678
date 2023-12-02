package 代码随想录.树.二叉树的遍历.层次遍历;

import java.util.Deque;
import java.util.LinkedList;

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

public class _116填充每个节点的下一个右侧节点指针 {
    /**
     * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
                                                             struct Node {
                                                                 int val;
                                                                 Node *left;
                                                                 Node *right;
                                                                 Node *next;
                                                             }
     填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     * @param root
     * @return
     */
    public Node connect(Node root) {
        //完成的时候，每一排最后一个输出一个#        ？？？
        if (root == null) return null;
        Deque<Node> queue = new LinkedList<Node>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++){
                Node node = queue.pollFirst();
                if (i<levelSize - 1){
                    node.next = queue.peekFirst();
                }
                //拓展下一层节点
                if (node.left!= null) queue.offerLast(node.left);
                if (node.right!= null) queue.offerLast(node.right);
            }
        }
        return root;
    }
}
