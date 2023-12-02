package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _654最大二叉树_递归 {
    /**
     *  就是先找出最大值rootMax作为根节点
     *  然后最大值左边的，采用先序遍历，
     *      最大值右边的，采用后序遍历
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // TODO 结构模拟题
        return myConstruction(nums,0,nums.length - 1);
    }

    /**
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private TreeNode myConstruction(int[] nums, int left, int right) {
        if (left > right){
            return null;
        }
        int maxNodeIndex = left;
        for (int i = left + 1; i<=right;i++){
            if (nums[i] > nums[maxNodeIndex]){
                maxNodeIndex = i;
            }
        }
        TreeNode node = new TreeNode(nums[maxNodeIndex]);
        node.left = myConstruction(nums,left,maxNodeIndex - 1);
        node.right = myConstruction(nums,maxNodeIndex + 1 ,right);
        return node;
    }
}
