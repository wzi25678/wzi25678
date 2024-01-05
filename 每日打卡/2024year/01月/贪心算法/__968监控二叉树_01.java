package 代码随想录.贪心算法;

public class __968监控二叉树_01 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private int res = 0;
    /**
     *
     * @param root
     * @return
     */
    public int minCameraCover(TreeNode root) {
        /*
        TODO: 优先给所有叶子节点的父节点加上摄像头，然后再向上跳一层逐步加上摄像头
        如果跳层的过程中，发现遇到了null，则说明已经遇到头了，可以结束了。
         */
        // 对根节点的状态做检验,防止根节点是无覆盖状态 .
        if (CameraCover(root) == 0){
            res++;
        }
        return res;
    }

    /**
     节点的状态值：
     0 表示无覆盖
     1 表示 有摄像头
     2 表示有覆盖
     后序遍历，根据左右节点的情况,来判读 自己的状态
     * @param root
     * @return
     */
    private int CameraCover(TreeNode root) {
        if (root == null){
            // 空节点默认为 有覆盖状态，避免在叶子节点上放摄像头
            return 2;
        }
        int leftNode = CameraCover(root.left);
        int rightNode = CameraCover(root.right);
        // 如果左右节点都覆盖了的话, 那么本节点的状态就应该是无覆盖,没有摄像头
        if (leftNode == 2 && rightNode==2){
            //(2,2)
            return 0;
        } else if (leftNode == 0 || rightNode == 0) {
            // 左右节点都是无覆盖状态,那 根节点此时应该放一个摄像头
            // (0,0) (0,1) (0,2) (1,0) (2,0)
            // 状态值为 1 摄像头数 ++;
            res++;
            return 1;
        }else {
            // 左右节点的 状态为 (1,1) (1,2) (2,1) 也就是左右节点至少存在 1个摄像头，
            // 那么本节点就是处于被覆盖状态
            return 2;
        }
    }
}
