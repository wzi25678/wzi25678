package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _99恢复二叉搜索树 {
    /**
     *给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
     *
     * @param root
     */
    public void recoverTree(TreeNode root) {
        /*
        利用二叉搜索树的特性去求解
            中序遍历一颗二叉树，他的顺序节点序列必定是单调递增的，那么我们就可以利用这一特性
            找出不满足单调递增顺序的两个节点

        题目要你找出，然后交换那两个结点的值
        并最终返回整个recoverTree
         */
        //构造一个链表，存储这棵二叉树
        if (root == null) {
            return;
        }
        List<TreeNode> lists = new ArrayList<TreeNode>();
        InorderTraversal(root,lists);
        int index [] = findTwoFalseNodes(lists);
        recoverFalseTree(root,2,index[0],index[1]);
    }

    private void recoverFalseTree(TreeNode root, int count,int x, int y) {
        if(root!=null){
            if (root.val == x || root.val == y) {
                root.val = root.val == x? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recoverFalseTree(root.right,count,x,y);
            recoverFalseTree(root.left,count,x,y);
        }
    }

    private int[] findTwoFalseNodes(List<TreeNode> lists) {
        int index1 = -1,index2 = -1;
        for (int i = 0; i < lists.size() - 1; i++) {
            if (lists.get(i).val > lists.get(i + 1).val) {
               index2 = i+1;
               if (index1 == -1) {
                   index1 = i;
               }else {
                   break;
               }
            }
        }
        int x = lists.get(index1).val,y = lists.get(index2).val;
        return new int[]{x,y};
    }

    private void InorderTraversal(TreeNode root, List<TreeNode> result) {
        if (root == null) {
            return;
        }
        InorderTraversal(root.left,result);
        result.add(root);
        InorderTraversal(root.right,result);
    }
}
