package 代码随想录.树.一般数_森林;

import 代码随想录.树.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _572另一棵树的子树_dfs串匹配 {
    List<Integer> rootOrder = new ArrayList<Integer>();
    List<Integer> subRootOrder = new ArrayList<Integer>();
    int maxElement,leftNull,rightNull;
    /**
     *
     *
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        /*
        一棵子树上的点在深度优先搜索序列（即先序遍历）中是连续的。
        我们可以确定解决这个问题的方向就是：把 s 和 t先转换成深度优先搜索序列，然后看 t的深度优先搜索序列是否是 s 的深度优先搜索序列的「子串」。
        同时为解决不是满二叉树的情况，我们还必须将所有结点补全null值。

        在判断「s 的深度优先搜索序列包含 t 的深度优先搜索序列」的时候，可以暴力匹配，
        也可以使用 KMP或者 Rabin-Karp算法，在使用 Rabin-Karp 算法的时候，要注意串中可能有负值。
         */
        maxElement = Integer.MIN_VALUE;
        getMaxElement(root);
        getMaxElement(subRoot);
        leftNull = maxElement + 1;
        rightNull = maxElement + 2;
        getDfsOrder(root,rootOrder);
        getDfsOrder(subRoot,subRootOrder);
        return myKMP();
    }

    private boolean myKMP() {
        int rootLength = rootOrder.size();
        int subRootLength = subRootOrder.size();
        int fail [] = new int[subRootLength];
        Arrays.fill(fail,-1);
        for (int i = 1,j=-1; i < subRootLength; i++) {
            while (j!= -1 && !(subRootOrder.get(i).equals(subRootOrder.get(j + 1)))){
                j = fail[j];
            }
            if (subRootOrder.get(i).equals(subRootOrder.get(j+1))){
                ++j;
            }
            fail[i] = j;
        }
        for (int i = 0,j=-1; i < rootLength; i++) {
            while ( j != -1 && !(rootOrder.get(i).equals(subRootOrder.get(j+1)))){
                j = fail[j];
            }
            if (rootOrder.get(i).equals(subRootOrder.get(j + 1))){
                j++;
            }
            if (j == subRootLength - 1){
                return true;
            }
        }
        return false;
    }

    private void getDfsOrder(TreeNode treeNode, List<Integer> treeNodeList) {
        if (treeNode == null){
            return;
        }
        treeNodeList.add(treeNode.val);
        if (treeNode.left!= null){
            getDfsOrder(treeNode.left,treeNodeList);
        }else {
            treeNodeList.add(leftNull);
        }
        if (treeNode.right!=null){
            getDfsOrder(treeNode.right,treeNodeList);
        }else {
            treeNodeList.add(rightNull);
        }
    }

    /**
     *
     * @param treeNode
     */
    private void getMaxElement(TreeNode treeNode) {
        if (treeNode == null){
            return;
        }
        if (treeNode.val > maxElement){
            maxElement = treeNode.val;
        }
        getMaxElement(treeNode.left);
        getMaxElement(treeNode.right);
    }
}
