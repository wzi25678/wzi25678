package 代码随想录.树.一般数_森林;

import 代码随想录.树.Node;

import java.util.ArrayList;
import java.util.List;

public class _590N叉树的后序遍历_递归 {
    public List<Integer> postorder(Node root) {
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
        for (Node child : root.children) {
            N_Travel(child, result);
        }
        result.add(root.val);
    }
}
