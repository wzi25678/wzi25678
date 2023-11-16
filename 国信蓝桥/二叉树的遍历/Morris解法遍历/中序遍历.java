package 代码随想录.树.二叉树的遍历.Morris解法遍历;

import 代码随想录.树.二叉树的遍历.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;
        while (root!= null ) {
            if (root.left != null) {
                //predecessor节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right!= null && predecessor.right!= root) {
                    predecessor = predecessor.right;
                }
                //让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }else {     // 说明左子树已经访问完了，我们需要断开链接
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
