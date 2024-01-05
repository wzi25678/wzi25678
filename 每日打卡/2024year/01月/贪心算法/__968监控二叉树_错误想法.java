package 代码随想录.贪心算法;

import 代码随想录.树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class __968监控二叉树_错误想法 {
    //TODO: 参考样例：[0,null,0,0,0,null,null,null,0]
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }

    /**
     *
     * @param root
     * @return
     */
    public int minCameraCover(TreeNode root) {
        int isOddNumber = -1;    //正，表示奇数；；；负，表示偶数
        if (root == null) return 0;
        if (root.left == null && root.right == null) return   1;
        int OddNumber = 1;
        int EvenNumber = 0;
        int ceng = 1;
        Deque<TreeNode> myQueue = new ArrayDeque<TreeNode>();
        myQueue.add(root);
        while (!myQueue.isEmpty()){
            ceng++;
            if (isOddNumber < 0){
                int curSize = myQueue.size();
                for (int i = 1;i<=curSize;i++){
                    TreeNode node = myQueue.remove();
                    if (node.left!= null) {
                        myQueue.add(node.left);
                        EvenNumber++;
                    }
                    if (node.right!= null) {
                        myQueue.add(node.right);
                        EvenNumber++;
                    }
                }
            }else {
                int curSize = myQueue.size();
                for (int i = 1;i<=curSize;i++){
                    TreeNode node = myQueue.remove();
                    if (node.left!= null) {
                        myQueue.add(node.left);
                        OddNumber++;
                    }
                    if (node.right!= null) {
                        myQueue.add(node.right);
                        OddNumber++;
                    }
                }
            }
            isOddNumber = -isOddNumber;
        }
        if (ceng%2 ==0){
            return EvenNumber;
        }else{
            return OddNumber;
        }
    }
}
