package 代码随想录.树.二叉树的遍历.Morris解法遍历;

import 代码随想录.树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        TreeNode p1 = root,p2 = null;
        while (p1 != null){
            p2 = p1.left;
            if (p2 != null) {
                while (p2.right!= null && p2.right!= p1) {
                    p2 = p2.right;
                }
                if (p2.right == null) {
                    res.add(p1.val);
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                }
            }else {
                res.add(p1.val);
            }
            p1 = p1.right;
        }
        return res;
    }
}
