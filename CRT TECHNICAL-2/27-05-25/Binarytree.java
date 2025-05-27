import java.util.LinkedList;
import java.util.Queue;
class Binarytree{
    static class Node{
        int value;
        Node left,right;
        public Node(int item){
            value=item;
            left=right=null;
        }
    }
    Node root;
    public Binarytree(){
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
    public static void main(String args[]){
        Binarytree tree=new Binarytree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        System.out.println("In order traversal");
        tree.inOrderTraversal(tree.root);
        System.out.println("");
        System.out.println("Preorder Traversal");
        tree.preOrderTraversal(tree.root);
        System.out.println( );
        System.out.println("Post order Traversal");
        tree.postOrderTraversal(tree.root);
        System.out.println();
        System.out.println("Inorder traversal");
        tree.levelOrderTraversal(tree.root);
        System.out.println();
    }
}