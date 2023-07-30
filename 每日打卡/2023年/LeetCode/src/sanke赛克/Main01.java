package sanke赛克;

import java.util.Scanner;
//java实现一颗二叉搜索树，不插入到二叉树中，只想知道它插入的深入，怎么实现
public class Main01 {
    /**
     *
     * @param args
     */

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i=0;i<n;i++){
            bst.insert(scanner.nextInt());
        }


        for (int i=0;i<n;i++){
            int yaoqiu = scanner.nextInt();
            int gaodu = bst.getMaxDepth(yaoqiu);
            System.out.println(gaodu);
        }


    }


    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }//class Node

    public static class BinarySearchTree{
        Node root;

        public BinarySearchTree() {
            root = null;
        }

        public void insert(int value) {
            root = insertNode(root, value);
        }


        /**
         *
         * @param root
         * @param value
         * @return
         */
        public  static Node insertNode(Node root,int value){
            if (root == null) {
                return new Node(value);
            }
            if (value < root.value) {
                root.left = insertNode(root.left, value);
            } else if (value > root.value) {
                root.right = insertNode(root.right, value);
            }

            return root;
        }

        public int getMaxDepth(int value){
            int depth = Getdepth(root,value,1);
            return depth;
        }


        /**
         *
         * @param value
         * @return
         */
        public int Getdepth(Node root,int value,int depth){
            if (root == null){
                return depth;
            }
            if (value == root.value){
                return depth;
            }
            if (root.left == null && root.right == null){
                return depth+1;
            }
            if (value < root.value && root != null  ){
                return Getdepth(root.left,value,depth + 1);
            }
            else{
                return Getdepth(root.right,value,depth + 1);
            }

        }

    }



}
