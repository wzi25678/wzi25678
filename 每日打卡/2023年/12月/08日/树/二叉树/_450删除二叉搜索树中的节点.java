package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _450删除二叉搜索树中的节点 {
    /**
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }
        if (root.val == key){   //删除这个节点，那么就在这个节点的位置上，直接跳到下一个接替他的节点即可。
            if (root.left == null){
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }else {
                TreeNode curNode = root.right;
                while (curNode.left != null){
                    curNode = curNode.left;
                }
                //当前节点，需要被删除，但是左右节点都不为null的情况下：
                //需要让右子树的最左边元素来接替这个位置
                curNode.left = root.left;
                root = root.right;
                return root;
            }
        }
        if (root.val > key){
            root.left = deleteNode(root.left,key);
        }else{
            root.right = deleteNode(root.right,key);
        }
        return root;
    }
}
