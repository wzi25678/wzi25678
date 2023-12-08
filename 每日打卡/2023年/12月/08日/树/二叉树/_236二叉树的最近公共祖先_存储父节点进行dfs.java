package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _236二叉树的最近公共祖先_存储父节点进行dfs {
    Map<Integer, TreeNode> parents = new HashMap<Integer,TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null){
            visited.add(p.val);
            p = parents.get(p.val);
        }
        while (q != null){
            if (visited.contains(q.val)){
                return q;
            }
            q = parents.get(q.val);
        }
        return null;
    }

    //用Map去进行存储，key存储节点的值，v存储该节点对应的树中的父节点是哪一个？
    private void dfs(TreeNode root) {
        if (root.left != null){
            parents.put(root.left.val,root);
            dfs(root.left);
        }
        if (root.right != null){
            parents.put(root.right.val,root);
            dfs(root.right);
        }
    }

}
