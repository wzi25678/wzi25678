package sanke赛克;

import java.util.Scanner;
public class Tree{
    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private static class BinarySearchTree {
        Node root;

        public BinarySearchTree() {
            root = null;
        }

        public void insert(int value) {
            root = insertNode(root, value);
        }

        private static Node insertNode(Node root, int value) {
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

        public int depth(int value) {
            return getNodeDepth(root, value, 1);
        }



        private  int getNodeDepth(Node root, int value, int depth) {
            if (root == null) {
                return -1;  // Value not found
            }

            if (value == root.value) {
                return depth;
            }

            if (value < root.value) {
                return getNodeDepth(root.left, value, depth + 1);
            } else {
                return getNodeDepth(root.right, value, depth + 1);
            }
        }
    }

    public static class Main {
        public static void main(String[] args) {
            BinarySearchTree bst = new BinarySearchTree();

            // 插入节点
            bst.insert(5);
            bst.insert(3);
            bst.insert(7);
            bst.insert(2);
            bst.insert(4);
            bst.insert(6);
            bst.insert(8);

            // 计算节点深度
            int depth = bst.depth(6);
            System.out.println("节点深度：" + depth);
        }
    }



}

