package 代码随想录.树.二叉树的遍历.统一风格的迭代遍历;

import 代码随想录.树.TreeNode;

import java.util.*;

public class 前序迭代 {
    public List<Integer> preorderTraversal(TreeNode root)   {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();   //pop()不能检测诶null值的情况
            if (node!= null){
                stack.pop();    // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                if (node.right != null){
                    stack.push(node.right);
                }
                if (node.left!= null){
                    stack.push(node.left);
                }
                stack.push(node);
                stack.push(null);
            }else {
                stack.pop();
                node = stack.peek();
                stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
