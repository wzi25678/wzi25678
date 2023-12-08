package 代码随想录.树.一般数_森林;

import 代码随想录.树.Node;

import java.util.ArrayList;
import java.util.List;

public class _589N叉树的前序遍历_递归 {

    /**
     *返回 其节点值的 前序遍历 。
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        N_Travel(root, result);
        return result;
    }

    /**
     *
     * @param root
     * @param result
     */
    private void N_Travel(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        for (Node child : root.children) {
            N_Travel(child, result);
        }
    }
}
