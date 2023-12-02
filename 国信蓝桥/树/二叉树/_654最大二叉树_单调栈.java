package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _654最大二叉树_单调栈 {
    /**
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        Deque<Integer> myStack = new ArrayDeque<Integer>();
        int left[] = new int[n];
        int right[] = new int[n];
        Arrays.fill(left,-1);
        Arrays.fill(right,-1);
        TreeNode [] treeNodesArray = new TreeNode [n];
        for (int i = 0; i < n;i++){
            treeNodesArray[i] = new TreeNode(nums[i]);
            while (!myStack.isEmpty() && nums[i] > nums[myStack.peek()]){
                right[myStack.pop()] = i;
            }
            if (!myStack.isEmpty()){
                left[i] = myStack.peek();
            }
            myStack.push(i);
        }
        TreeNode root = null;
        for (int i = 0;i<n;i++){
            if (left[i] == -1 && right[i] == -1){
                root = treeNodesArray[i];
            } else if (right[i] == -1 || (left[i] != -1 && nums[left[i]] < nums[right[i]])) {
                treeNodesArray[left[i]].right = treeNodesArray[i];

            }else{
                treeNodesArray[right[i]].left = treeNodesArray[i];
            }
        }
        return root;
    }
}
