package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _98验证二叉搜索树_统一迭代法 {
    /**
     * 二叉搜索树中:
     * 1.左子树都小于中间节点，右子树都大于中间节点
     * 2.中序遍历二叉搜索树形成的序列，会得到一个有序递增数列
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> myStack = new ArrayDeque<TreeNode>();
        TreeNode prevNode = null;
        if(root == null) {
            return true;
        }
        myStack.push(root);
        while (!myStack.isEmpty()){
            TreeNode curNode = myStack.peek();
            if (curNode != null){
                myStack.pop();
                if(curNode.right != null){
                    myStack.push(curNode.right);
                }
                myStack.push(curNode);
                myStack.push(null);
                if (curNode.left != null){
                    myStack.add(curNode.left);
                }
            }else{
                myStack.pop();
                TreeNode tempNode = myStack.pop();
                if (prevNode != null && prevNode.val >= tempNode.val){
                    return false;
                }
                prevNode = tempNode;
            }
        }
        return true;
    }
}
