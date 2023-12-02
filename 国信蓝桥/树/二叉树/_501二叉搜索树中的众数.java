//package 代码随想录.树.二叉树;
//
//import 代码随想录.树.TreeNode;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class _501二叉搜索树中的众数_Map记录 {
//    private List<Integer> resultList = new ArrayList<Integer>();
//    private Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
//
//    public int[] findMode(TreeNode root) {
//        if (root.left == null && root.right == null) {
//            return new int[] {root.val};
//        }
//        inOrderTraversal(root);
//        int result [] = new int[resultList.size()];
//
//
//    }
//
//    /**
//     *
//     * @param root
//     */
//    private void inOrderTraversal(TreeNode root) {
//        if (root== null){
//            return;
//        }
//        inOrderTraversal(root.left);
//        if (map.containsKey(root)){
//
//        }
//        inOrderTraversal(root.right);
//
//    }
//}
