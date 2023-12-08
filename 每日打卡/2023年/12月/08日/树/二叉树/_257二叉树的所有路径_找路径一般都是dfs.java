package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _257二叉树的所有路径_找路径一般都是dfs {
    /**
     *返回所有从根节点到叶子节点的路径。
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> listPaths = new ArrayList<String>();
        constructPath(root, "", listPaths);
        return listPaths;
    }

    /**
     *
     * @param root
     * @param path
     * @param listPaths
     */
    private void constructPath(TreeNode root, String path, List<String> listPaths) {
        if (root != null) {
            StringBuffer pathStringBuffer = new StringBuffer(path);
            pathStringBuffer.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {
                listPaths.add(pathStringBuffer.toString());
            }else {
                pathStringBuffer.append("->");
                constructPath(root.left, pathStringBuffer.toString(), listPaths);
                constructPath(root.right, pathStringBuffer.toString(), listPaths);
            }
        }
    }
}
