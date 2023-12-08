package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _108将有序数组转换为二叉搜索树_递归 {
    /**
     *给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        // TODO 因为已经严格递增了，所以每次都找最中间的值做当前位置的中间节点，然后递归的左边找中间节点，右边找中间节点
        TreeNode root = inorderTraversal(nums,0,nums.length - 1);
        return root;
    }

    /**
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private TreeNode inorderTraversal(int[] nums, int left, int right) {
        //   左闭右闭区间[left, right]
        if (left > right){
            return null;
        }
        int mid = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = inorderTraversal(nums, left, mid - 1);
        root.right = inorderTraversal(nums, mid + 1, right);
        return root;
    }

}
