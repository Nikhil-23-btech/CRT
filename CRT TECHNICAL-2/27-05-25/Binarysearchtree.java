import java.util.*;

public class Binarysearchtree {
    static class Node{
        int value;
        Node left,right;
        public Node(int item){
            value=item;
            left=right=null;
        }
    }
    Node root;
    public Binarysearchtree(){
        root=null;
    }
    public void insert(int value){
        root=insertRec(root,value);
    }
    private Node insertRec(Node root,int value){
        if(root==null){
            root=new Node(value);
            return root;
        }
        if(value<root.value){
            root.left=insertRec(root.left, value);
        }
        else{
            root.right=insertRec(root.right, value);
        }
        return root;
    }
    public void delete(int value){
        root=deleteRec(root,value);
    }
    private Node deleteRec(Node root,int value){
        if(root==null) return root;
        if(value<root.value){
            root.left=deleteRec(root.left, value);
        }
        else if(value>root.value){
            root.right=deleteRec(root.right, value);
        }
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            root.value=minValue(root.right);
            root.right=deleteRec(root.right, root.value);
        }
        return root;
    }
    private int minValue(Node root){
        int minval=root.value;
        while(root.left!=null){
            root=root.left;
            minval=root.value;
        }
        return minval;
    }
    public void inOrderTraversal(Node node){
        if(node!=null){
            inOrderTraversal(node.left);
            System.out.println(node.value + " ");
            inOrderTraversal(node.right);
        }
    }
    public void  preOrderTraversal(Node node){
        if(node!=null){
            System.out.println(node.value + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
    public void postOrderTraversal(Node node){
        if(node!=null){
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.value + " ");
        }
    }
    public void levelOrderTraversal(Node root){
    if(root == null){
        return;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    
    while(!queue.isEmpty()){
        Node current = queue.poll();
        System.out.println(current.value + " ");  // Print node value
        
        if(current.left != null){
            queue.add(current.left);
        }
        if(current.right != null){  // Ensure right node gets added too
            queue.add(current.right);
        }
    }
}

    public static void main(String args[]) {
        Binarysearchtree tree=new Binarysearchtree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        System.out.println("The inorder traversal");
        tree.inOrderTraversal(tree.root);
        System.out.println();
        System.out.println("The pre order traversal");
        tree.preOrderTraversal(tree.root);
        System.out.println();
        System.out.println("The post order traversal");
        tree.postOrderTraversal(tree.root);
        System.out.println();
        System.out.println("The minimum value="+tree.minValue(tree.root));
        System.out.println("\n\n DEleting 2");
        tree.delete(2);
        System.out.println("Inorder traversal after deleting element 2");
        tree.inOrderTraversal(tree.root);
        System.out.println();
    }
}