package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class _108将有序数组转换为二叉搜索树_迭代 {
    /**
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        //根节点初始化
        TreeNode root = new TreeNode(-1);
        Deque<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Deque<Integer> leftQueue = new LinkedList<Integer>();
        Deque<Integer> rightQueue = new LinkedList<Integer>();

        //根节点入队列
        nodeQueue.offerLast(root);
        // 0为左区间下标初始位置
        leftQueue.offerLast(0);
        // nums.size() - 1为右区间下标初始位置
        rightQueue.offerLast(nums.length - 1);

        while (!nodeQueue.isEmpty()){
            TreeNode curNode = nodeQueue.poll();
            int left = leftQueue.poll();
            int right = rightQueue.poll();
            int mid = left + ((right - left) >> 1);

            // 将mid对应的元素给中间节点
            curNode.val = nums[mid];

            //处理左区间
            if (left <= mid - 1){
                curNode.left = new TreeNode(-1);
                nodeQueue.offerLast(curNode.left);
                leftQueue.offerLast(left);
                rightQueue.offerLast(mid - 1);
            }
            //处理右区间
            if (right >= mid + 1){
                curNode.right = new TreeNode(-1);
                nodeQueue.offerLast(curNode.right);
                leftQueue.offerLast(mid + 1);
                rightQueue.offerLast(right);
            }
        }
        return root;
    }
}
