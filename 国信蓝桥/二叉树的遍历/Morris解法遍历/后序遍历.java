package 代码随想录.树.二叉树的遍历.Morris解法遍历;

import 代码随想录.树.二叉树的遍历.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        TreeNode p1 = root,p2 = null;
        while (p1 != null){
            p2 = p1.left;
            if (p2!= null){
                while (p2.right!= null && p2.right != p1){
                    p2 = p2.right;
                }
                if (p2.right == null){
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                }else {
                    p2.right = null;
                    addPath(res,root);
                }
            }
            p1 = p1.right;
        }
        addPath(res,root);
        return res;
    }


    private void addPath(List<Integer> res, TreeNode node) {
        int count = 0;
        while (node!= null){
           ++count;
           res.add(node.val);
           node = node.right;
        }
        int left = res.size() - count,right = res.size() - 1;
        while (left < right){
            int temp = res.get(left);
            res.set(left,res.get(left));
            res.set(right,temp);
            ++left;
            --right;
        }
    }
}
