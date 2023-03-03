package 第10章_234树和外部存储;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

class DataItem{
    public long dData;

    public DataItem(long dd) {
        this.dData = dd;
    }

    public void displayItem(){
        System.out.println("/"+dData);
    }

}//end -class DataItem

class Node{
    private static final int ORDER = 4;
    private int numItems;
    private Node parent;
    private Node childArray[] = new Node[ORDER];
    private DataItem itemArray[] = new DataItem[ORDER-1];

    public void connectChild(int ChildNum,Node child){
        childArray[ChildNum] = child;
        if (child != null){
            child.parent = this;
        }
    } //end -void connectChild

    public Node disconnectChild(int childNum){
        Node tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }//end -Node disconnectChild

    public Node getChild(int childNum){
        return childArray[childNum];
    }

    public Node getParent(){
        return parent;
    }

    public boolean isLeaf(){
        return (childArray[0]==null) ? true :false;
    }

    public int getNumItems(){
        return numItems;
    }

    public DataItem getItem(int index){
        return itemArray[index];
    }

    public boolean isFull(){
        return (numItems ==ORDER -1) ? true:false;
    }

    public int findItem(long key){
        for (int j=0;j<ORDER-1;j++){
            if (itemArray[j] == null){
                break;
            }else if (itemArray[j].dData == key){
                return j;
            }
        }//for (int j=0;j<ORDER-1;j++)
        return -1;
    }

    public int insertItem(DataItem newItem){
        numItems++;
        long newkey = newItem.dData;
        for (int j=ORDER-2;j>=0;j--){
            if (itemArray[j] == null){
                continue;
            }else {
                long itsKey = itemArray[j].dData;
                if (newkey < itsKey){
                    itemArray[j+1] = itemArray[j];
                }else {
                    itemArray[j+1] = newItem;
                    return j+1;
                }
            }//end -else
        }//end -for
        itemArray[0] = newItem;
        return 0;
    }//end -int insertItem

    public DataItem removeItem(){
        DataItem temp = itemArray[numItems-1];
        itemArray[numItems-1] = null;
        numItems--;
        return temp;
    }//end -DataItem removeItem
    
    public void displayNode(){
        for (int j=0;j<numItems;j++){
            itemArray[j].displayItem();
        }
        System.out.println("/");
    }//end -void display
}//end -class Node

class Tree234{
    private Node root = new Node();
    
    public int find(long key){
        Node curNode = root;
        int childNumber;
        while (true){
            if ((childNumber = curNode.findItem(key)) != -1){
                return childNumber;
            }else if (curNode.isLeaf()){
                return -1;
            } else {
                curNode = getNextChild(curNode,key);            
            }
        }//end while
    }//end -int find

    public  void insert(long dvalue){
        Node curNode = root;
        DataItem tempItem = new DataItem(dvalue);
        
        while (true){
            if (curNode.isFull()){
                split(curNode);
                curNode = curNode.getParent();
                curNode = getNextChild(curNode,dvalue);
            }else if (curNode.isLeaf()){
                break;
            }else {
                curNode = getNextChild(curNode,dvalue);
            }
        }//end -while
        curNode.insertItem(tempItem);
    }//end -void insert

    private void split(Node thisNode) {
        DataItem itemB,itemC;
        Node parent,child2,child3;
        int itemIndex;

        itemC = thisNode.removeItem();
        itemB = thisNode.removeItem();
        child2 = thisNode.disconnectChild(2);
        child3 = thisNode.disconnectChild(3);
        Node newRight = new Node();

        if (thisNode == root){
            root = new Node();
            parent = root;
            root.connectChild(0,thisNode);
        }else {
            parent = thisNode.getParent();
        }
        itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();

        for (int j=n-1;j>itemIndex;j--){
            Node temp = parent.disconnectChild(j);
            parent.connectChild(j+1,temp);
        }
        parent.connectChild(itemIndex+1,newRight);
        //deal with the newRight
        newRight.insertItem(itemC);
        newRight.connectChild(0,child2);
        newRight.connectChild(1,child3);
    }//end -void split

    private Node getNextChild(Node theNode, long theValue) {
        int j;
        int numItems = theNode.getNumItems();
        for (j = 0;j<numItems;j++){
            if (theValue < theNode.getItem(j).dData){
                return theNode.getChild(j);
            }
        }
        return theNode.getChild(j);
    }//end -Node getNextChild

    public void displayTree(){
        recDisplayTree(root,0,0);
    }

    private void recDisplayTree(Node thisNode, int level, int childNumber) {
        System.out.print("level= "+level+" child="+childNumber+" ");
        thisNode.displayNode();
        int numItems = thisNode.getNumItems();
        for (int j=0;j<numItems+1;j++){
            Node nextNode = thisNode.getChild(j);
            if (nextNode != null){
                recDisplayTree(nextNode,level+1,j);
            }else {
                return;
            }
        }//end -for (int j=0;j<numItems+1;j++)
    }//end -void recDisplayTree

} //end -class Tree234

class Tree234App{
    public static void main(String[] args) throws IOException {
        long value;
        Tree234 theTree = new Tree234();
        
        theTree.insert(50);
        theTree.insert(80);
        theTree.insert(70);
        theTree.insert(90);
        theTree.insert(40);
        
        while (true){
            System.out.print("Enter first letter of");
            System.out.print("show ,insert , or find: ");
            char choice = getChar();
            switch (choice)
            {
                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    theTree.insert(value);
                    break;
                case 'f':
                    System.out.println("Enter value to find: ");
                    value = getInt();
                    int found = theTree.find(value);
                    if (found!=-1){
                        System.out.println("Found the value: "+value);
                    }else {
                        System.out.println("Could not find the value: "+value);
                    }
                    break;
                default:
                    System.out.println("Invalid entry!");
            }//end -switch (choice)
        }//end while (true)
    }//end -main

    private static long getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s); 
    }

    private static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    private static String getString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader  = new BufferedReader(inputStreamReader);
        String str = bufferedReader.readLine();
        return str;
    }
}
