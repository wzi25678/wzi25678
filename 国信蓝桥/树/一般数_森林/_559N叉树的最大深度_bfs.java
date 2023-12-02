package 代码随想录.树.一般数_森林;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _559N叉树的最大深度_bfs {
    /**
     *
     */
    public int maxDepth(Node root) {
        // TODO 每层遍历完之后，记录一下长度，层次遍历
        if (root == null) {
            return 0;
        }
        Queue<Node> myQueue = new LinkedList<Node>();     //层次，迭代就继承LinkedList
        myQueue.offer(root);
        int depth = 0;
        while (!myQueue.isEmpty()) {
            int size = myQueue.size();
            while (size >0){
                Node curNode = myQueue.poll();
                for (Node child :  curNode.children){
                    if (child != null) {
                        myQueue.offer(child);
                    }
                }
                size--;
            }
            depth++;
        }
        return depth;
    }
}
