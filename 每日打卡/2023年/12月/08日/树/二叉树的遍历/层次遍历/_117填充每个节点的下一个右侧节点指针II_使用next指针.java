package 代码随想录.树.二叉树的遍历.层次遍历;

public class _117填充每个节点的下一个右侧节点指针II_使用next指针 {
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

    Node lastNode = null, nextStartNode = null;

    /**
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node startNode = root;
        while (startNode != null) {
            lastNode = null;
            nextStartNode = null;
            for (Node p = startNode; p != null; p = p.next){
                if (p.left!= null) {
                    handleNext(p.left);
                }
                if (p.right != null) {
                    handleNext(p.right);
                }
            }
            startNode = nextStartNode;
        }
        return root;
    }

    /**
     *
     * @param pNode
     */
    private void handleNext(Node pNode) {
        if (lastNode != null) {
            lastNode.next = pNode;
        }
        if (nextStartNode == null) {
            nextStartNode = pNode;
        }
        lastNode = pNode;
    }
}
