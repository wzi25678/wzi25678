package 第08章__二叉树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Title：XXXX OCR
 * Description:XXXX OCR 3.0
 * Copyright:Copyright(c) 2021
 * Company:XXXX 有限公司
 *
 * @author Wzi
 * @version jdk1.8
 * <p>
 * 带参数构造函数，初始化模式名、变量名称和数据源类型
 * @create_date 2019/10/4 15:09
 */
class Case01__tree {
    public int iDate;       //item -key
    public double dDate;    //item

    public Case01__tree leftChild;
    public Case01__tree rightChild;

    public void displayNode(){
        System.out.println('{');
        System.out.println(iDate);
        System.out.println(",");
        System.out.println(dDate);
        System.out.println('}');
    }
}//end -class -Case01__tree

class Tree{
    private Case01__tree root;

    public Tree() {     //默认创建空参构造器
        this.root = null;
    }


    public void insert(int id, double dd) {
        Case01__tree newNode = new Case01__tree();
        newNode.iDate = id;
        newNode.dDate = dd;

        if (root == null){
            root = newNode;
        }else {    //find where to insert
            Case01__tree current = root;    //以root开始，作为current
            Case01__tree parent;   //定义一个结点名叫parent,其结构为Case01__tree类型这个样子。
            while (true){
                parent = current;
                if (id < current.iDate){    //尝试向左遍历询问
                    current = current.leftChild;    //向左寻找
                    if (current == null){   //如果当前结点的左孩子为空，则刚好插在这个位置。
                        current.leftChild = newNode;
                        return;
                    }
                }//end if <
                else {
                    current = current.rightChild;
                    if (current == null){
                        current.rightChild = newNode;
                        return;
                    }
                }//end if >=
            }//end -while
        }
    }//end -void insert

    public void displayTree() {     //采用压栈的形式遍历展示整棵树
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("=========================================");
        while (isRowEmpty == false){
            Stack localStack = new Stack();
            isRowEmpty = true;  //现在认为是空的
            for (int j=0;j<nBlanks;j++){
                System.out.println(' ');
            }
            while (globalStack.isEmpty() == false){   //检查“根”结点存不存在值。
                //如果存在，则可以进行展示。
                Case01__tree temp = (Case01__tree) globalStack.pop();   //temp作为pop出来的值。
                if (temp!=null){    //“根”结点存储的值虽然不为空，但还需要检查是否为null
                    //如果不等于null
                    System.out.println(temp.iDate);
                    //这里有涉及到存储结构的问题,
                    //按下不表，遵循访问顺序，先左后右
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    //如果该语句没有被执行，那么 isRowEmpty = true;
                    //就会导致该循环结束。
                    if (temp.leftChild != null || temp.rightChild != null){
                        //只要有一个不为空，那么都认为可以进行再次的循环
                        isRowEmpty = false;   
                    }
                //退出咯，这里，给了个gg    
                else {  //如果当前temp为空
                        System.out.println(" = =~ terrible!");
                        localStack.push(null);
                        localStack.push(null);
                    }
                }//有一个等于null，不要紧，还有另一个孩子结点可以进行二次遍历，所以这里不会退出循环
                }//end -while globalStack.isEmpty()
            for (int j=0;j<nBlanks*2 - 2;j++){
                System.out.println(' ');    //char类型的32号占位符 (space)
            }//end -while globalStack
            System.out.println();
            nBlanks/=2;
            while (localStack.isEmpty() == false){
                globalStack.push(localStack.pop());
            }//end -while localStack.isEmpty
        }//end -while isRowEmpty
        System.out.println("--------------------------------------");
    }   //end -void displayTree

    public Case01__tree find(int key) {
        Case01__tree current = root;
        while (current.iDate != key){
            if (key < current.iDate){
                current = current.leftChild;
            }else {   //key > current.iDate
                current = current.rightChild;
            }
            if (current == null){
                return null;
            }
        }
        return current;
    } //end -Case01__tree find

    public boolean delete(int key) {
        Case01__tree current = root;
        Case01__tree parent = root;
        boolean isLeftChild = true;
        while (current.iDate != key){
            parent = current;
            if (key<current.iDate){
                isLeftChild = true;
                current = current.leftChild;
            }else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null){
                return false;
            }
        }//end -while
        if (current.leftChild == null && current.rightChild == null){
            if (current==root){
                root = null;
            }else if (isLeftChild){
                parent.leftChild = null;
            }else {
                parent.rightChild = null;
            }
        }else if (current.rightChild == null){
            if (current == root){
                root = current.leftChild;
            }else if (isLeftChild){
                parent.leftChild = current.rightChild;
            }else {
                parent.rightChild = current.rightChild;
            }
        }else if (current.leftChild ==null){
            if (current == root){
                root = current.rightChild;
            }else if (isLeftChild){
                parent.leftChild = current.rightChild;
            }else {
                parent.rightChild = current.rightChild;
            }
        }else {
            Case01__tree successor = getSuccessor(current);
            if (current == root){
                root  = successor;
            }else if (isLeftChild){
                parent.leftChild = successor;
            }else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }//end -boolean delete

    public void traverse(int value) {
    }
} //end -class Tree

class TreeApp{
    public static void main(String[] args) throws IOException {
        int value;
        Tree theTree = new Tree();

        theTree.insert(50,1.5);
        theTree.insert(25,1.2);
        theTree.insert(75,1.7);
        theTree.insert(12,1.5);
        theTree.insert(37,1.2);
        theTree.insert(43,1.7);
        theTree.insert(30,1.5);
        theTree.insert(33,1.2);
        theTree.insert(87,1.7);
        theTree.insert(93,1.5);
        theTree.insert(97,1.5);
        while (true){
            System.out.println("Enter first letter of show :");
            System.out.println("insert ,find ,delete ,or traverse:");
            int choice = getChar();         //识别做什么操作
            switch (choice){
                case 's':
                    theTree.displayTree();
                    break;
                case  'i':
                    System.out.println("Enter value to insert:");
                    value = getInt();
                    theTree.insert(value,value+0.9);
                    break;
                case 'f':
                    System.out.println("Enter value to find:");
                    value = getInt();
                    Case01__tree found = theTree.find(value);
                    if (found != null){
                        System.out.println("Found: ");
                        found.displayNode();
                        System.out.println("\n");
                    }else {
                        System.out.println("Could not find ");
                        System.out.println(value + '\n');
                    }
                    break;
                case 'd':
                    System.out.println("Enter value to delete:");
                    value = getInt();
                    boolean didDelete = theTree.delete(value);
                    if (didDelete){
                        System.out.println("Deleted "+value + '\n');
                    }else {
                        System.out.println("Could not delete.");
                        System.out.println(value+ "\n");
                    }
                    break;
                case 't':
                    System.out.println("Enter type 1 , 2 or 3 : ");
                    value = getInt();
                    theTree.traverse(value);
                    break;
                default:
                    System.out.println("Invalid entry\n");
            } //end switch
        }//end while
    }//end -void main

    private static int getInt() throws IOException{
        String s = getSting();
        return Integer.parseInt(s);
    }

    private static int getChar() throws IOException {
        String s = getSting();
        return s.charAt(0);
    }

    private static String getSting() throws IOException{
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = bufferedReader.readLine();
        return str;
    }
}

