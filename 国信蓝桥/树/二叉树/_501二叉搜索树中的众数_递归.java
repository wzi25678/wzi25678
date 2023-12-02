package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _501二叉搜索树中的众数_递归 {
    private List<Integer> resultList = new ArrayList<Integer>();
    private int baseValue;
    private int count;
    private int maxValue;
    /**
     *  给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
     *  如果树中有不止一个众数，可以按 任意顺序 返回。
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        if (root.left ==null && root.right ==null ){
            return new int[]{root.val};
        }
        inOrderTraveral(root);  //经过遍历完出结果
        int [] result = new int[resultList.size()];
        for (int i = 0; i < result.length;i++){
            result[i] = resultList.get(i);
        }
        return result;
    }

    /**
     *
     * @param root
     */
    private void inOrderTraveral(TreeNode root) {
        if (root == null){
            return;
        }
        inOrderTraveral(root.left);
        dfs(root.val);
        inOrderTraveral(root.right);
    }

    /**
     *
     * @param value
     */
    private void dfs(int value) {
        if (value == baseValue){
            count++;
        }else{
            count = 1;
            baseValue = value;
        }
        if (count == maxValue){
            resultList.add(baseValue);
        }
        if (count > maxValue){
            maxValue = count;
            resultList.clear();
            resultList.add(baseValue);
        }
    }

}
