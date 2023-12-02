package 代码随想录.树.二叉树的遍历.迭代遍历;

import 代码随想录.树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Deque<TreeNode> myStack = new ArrayDeque<TreeNode>();
        TreeNode prev = null;
        while (root!= null ||!myStack.isEmpty()){
            while (root!= null){
                myStack.push(root);
                root = root.left;
            }
            //为空，则当前节点出栈
            root = myStack.pop();
            //然后去判断，先右后左
            //当前节点做没有的话，就去判断右或者node，并且判断一下就应该立刻回到左
            //而且顺序是左右根
            if (root.right == null || root.right == prev){
                res.add(root.val);
                prev = root;
                root = null;
            }else {
                myStack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
