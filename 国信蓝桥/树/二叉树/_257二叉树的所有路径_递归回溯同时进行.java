package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _257二叉树的所有路径_递归回溯同时进行 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> listPaths = new ArrayList<String>();
        if (root == null) {
            return listPaths;
        }
        List<Integer> paths = new ArrayList<Integer>();
        dfsTraversal(root, paths, listPaths);
        return listPaths;
    }

    /**
     *
     * @param root
     * @param paths
     * @param listPaths
     */
    private void dfsTraversal(TreeNode root, List<Integer> paths, List<String> listPaths) {
        paths.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder stringBuilder = new StringBuilder();
//            for (int path : paths) {
//                stringBuilder.append(path).append("->");
//            }
            for (int i = 0; i < paths.size() - 1; i++) {
                stringBuilder.append(paths.get(i)).append("->");
            }
            stringBuilder.append(paths.get(paths.size() - 1));
            listPaths.add(stringBuilder.toString());
            return;
        }
        if (root.left!= null) {
            dfsTraversal(root.left, paths, listPaths);
            paths.remove(paths.size() - 1);
        }
        if (root.right!= null) {
            dfsTraversal(root.right, paths, listPaths);
            paths.remove(paths.size() - 1);
        }
    }
}
