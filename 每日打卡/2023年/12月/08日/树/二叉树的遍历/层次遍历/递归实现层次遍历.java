package 代码随想录.树.二叉树的遍历.层次遍历;

import 代码随想录.树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 递归实现层次遍历 {

    /**
     *
     * @param root
     * @return
     */
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        dns(root,0);
        return result;
    }

    private void dns(TreeNode root, int lever) {
        if (root == null) return;
        if (result.size() == lever) {
            result.add(new ArrayList<Integer>());
        }
        result.get(lever).add(root.val);
        dns(root.left,lever+1);
        dns(root.right,lever+1);
    }
}
