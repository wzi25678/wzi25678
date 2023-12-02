package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _106从中序与后序遍历序列构造二叉树_递归 {
    int postIndex;
    int [] postorder;
    int [] inorder;
    private Map<Integer,Integer> map;
    /**
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<Integer,Integer>();
        this.inorder = inorder;
        this.postorder = postorder;
        // 从后序遍历的最后一个元素开始
        postIndex = postorder.length - 1;
        // 建立（元素，下标）键值对的哈希表
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],index++);
        }
        return myBuildTree(0,inorder.length - 1);
    }

    private TreeNode myBuildTree(int inorderLeft, int inorderRight) {
        // 如果这里没有节点构造二叉树了，就结束
        if (inorderLeft > inorderRight) {
            return null;
        }
        // 选择 post_idx 位置的元素作为当前子树根节点
        int rootValue = postorder[postIndex];
        TreeNode root = new TreeNode(rootValue);
        //  根据 root 所在位置分成左右两棵子树
        int index = map.get(rootValue);
        postIndex--;
        //构造右子树
        root.right = myBuildTree(index + 1,inorderRight);
        //构造左子树
        root.left = myBuildTree(inorderLeft,index - 1);
        return root;
    }

}
