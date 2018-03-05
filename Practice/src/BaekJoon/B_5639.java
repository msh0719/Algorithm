package BaekJoon;

import java.util.Scanner;

/*
  백준 트리 문제!
 */

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
}

public class B_5639{
    static TreeNode dumy;

    public static void initTree(){
        dumy = new TreeNode();
        dumy.right = null;
    }

    public static void insertTree(int num){
        TreeNode newNode = new TreeNode();

        newNode.data = num;
        newNode.left = null;
        newNode.right = null;

        if(dumy.right == null){
            dumy.right = newNode;
        }
        else{
            TreeNode tmp;
            tmp = dumy.right;
            while(true){
                if(newNode.data > tmp.data){
                    if(tmp.right == null){
                        tmp.right = newNode;
                        return;
                    }
                    tmp = tmp.right;
                }
                else{
                    if(tmp.left == null){
                        tmp.left = newNode;
                        return;
                    }
                    tmp = tmp.left;
                }
            }
        }
    }

    public static void postOrder(TreeNode node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }

    public static void preOrder(TreeNode node){
        if(node != null){
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public static void inOrder(TreeNode node){
        if(node != null){
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }
    public static void main(String args[]) {
        Scanner sc =  new Scanner(System.in);
        initTree();
        int num;

        while(sc.hasNext()){
            num = sc.nextInt();
            insertTree(num);
        }

        postOrder(dumy.right);
    }
}

