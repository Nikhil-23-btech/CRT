public class AVLTree {
    static class Node{
        int key,height;
        Node left,right;
        public Node(int d){
            key=d;
            height=1;
        }
    }
    private Node root;
    int height(Node N){
        if(N==null){
            return 0;
        }
        return N.height;
    }
    int getBalance(Node N){
        if(N==null){
            return 0;
        }
        return height(N.left)-height(N.right);
    }
    Node rightRotate(Node y){
        Node x=y.left;
        Node T2=x.right;
        x.right=y;
        y.left=T2;
        y.height=Math.max(height(y.left),height(y.right))+1;
        x.height=Math.max(height(x.left),height(x.right))+1;
        return x;
    }
    Node leftRotate(Node x){
        Node y=x.right;
        Node T2=y.left;
        y.left=x;
        x.right=T2;
        x.height=Math.max(height(x.left),height(x.right))+1;
        y.height=Math.max(height(y.left),height(y.right))+1;
        return y;
    }
    Node insert(Node node,int key){
        if(node==null){
            return new Node(key);
        }
        if(key<node.key){
            node.left=insert(node.left,key);
        }
        else if(key>node.key){
            node.right=insert(node.right, key);
        }
        else{
            return node;
        }
        node.height=1+Math.max(height(node.left),height(node.right));
        int balance=getBalance(node);
        if(balance>1 && key<node.left.key){
            return rightRotate(node);
        }
        if(balance<-1 && key>node.right.key){
            return leftRotate(node);
        }
        if(balance>1 && key>node.left.key){
            node.left=leftRotate(node.left);
            return rightRotate(node);
        }
        if(balance<-1 && key<node.right.key){
            node.right=rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    public void insert(int key){
        root=insert(root, key);
    }
    public void inOrder(Node node){
        if(node!=null){
            inOrder(node.left);
            System.out.println(node.key+" ");
            inOrder(node.right);
        }
    }
    public void inOrder(){
        inOrder(root);
        System.out.println();
    }
    public static void main(String[] args) {
        AVLTree avl=new AVLTree();
        avl.insert(10);
        avl.insert(20);
        avl.insert(30);
        avl.insert(40);
        avl.insert(50);
        avl.insert(25);
        System.out.println("Inorder traversal for constructed avl tree");
        avl.inOrder();
    }
}