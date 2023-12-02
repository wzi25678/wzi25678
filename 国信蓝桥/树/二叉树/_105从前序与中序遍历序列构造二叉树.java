package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _105从前序与中序遍历序列构造二叉树 {
    private Map<Integer,Integer> indexMap;
    /**
     * 已知中序遍历，先序遍历情况，返回整颗二叉树的情况
     *
     * //你要想通过遍历循序知道树的形状，就一定得知道中序遍历情况
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //每次通过中序遍历+其他遍历，，，确定当前根所在的位置。
        //构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer,Integer>();;
        for (int i = 0;i<preorder.length;i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder,inorder,0, preorder.length-1, 0,inorder.length-1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder,int preorderLeft,int preorderRight,int inorderLeft,int inorderRight){
        if (preorderLeft > preorderRight) {
            return null;
        }
        //前序遍历中的第一个节点即为根节点，通过根节点，来确定左右子树
        //再通过左右子树，划分区域，再不同的区域中，第一个节点又是其所在子树的根节点，
        //依次上式迭代,我们就可以通过不断找根以及划分左右子树的方式来确定各个节点的位置以及左右子树的关系。
        int preorderCurRoot = preorderLeft;
        int inorderCurRoot = indexMap.get(preorder[preorderCurRoot]);

        //先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorderCurRoot]);
        //得到左子树中的节点数目
        int sizeLeftSubTree = inorderCurRoot - inorderLeft;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder,inorder,preorderLeft + 1,preorderLeft+sizeLeftSubTree,inorderLeft,inorderCurRoot - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder,inorder,preorderLeft + sizeLeftSubTree + 1,preorderRight,inorderCurRoot + 1,inorderRight);
        return root;
    }
}
