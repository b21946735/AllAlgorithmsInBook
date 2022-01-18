public class binarytree {

    public static void addNode(Node root,int value){
        if (searchValue(root, value)) {
            return;
        }
        Node temp = null;
        boolean right = false;
        while(root != null){
            if (value >= root.value) {
                right = true;
                temp = root;
                root = root.right;
                
            }
            else{
                right = false;
                temp = root;
                root = root.left;
            }
        }
        Node newNode = new Node(value);
        if (right) 
            temp.right = newNode;
        else
            temp.left = newNode;
    }

    public static void inOrderTraversal(Node root){
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.value+" ");
            inOrderTraversal(root.right);
        }
    }

    public static boolean searchValue(Node root, int value){
        if (root != null) {
            if (root.value == value) {
                return true;
            }
            boolean found1 =searchValue(root.left,value);
            boolean found2=false;
            if(!found1){
                found2 = searchValue(root.right,value);
            }
            return found1||found2;
        }
        return false;
    }

    public static int findMax(Node root){
        Node temp = null;
        while(root != null) {
            temp = root;
            root = root.right;
        }
        return temp.value;
    }

    public static int findMin(Node root){
        Node temp = null;
        while(root != null) {
            temp = root;
            root = root.left;
        }
        return temp.value;
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        addNode(root,30);
        addNode(root,20);
        addNode(root,40);
        addNode(root,70);
        addNode(root,60);
        addNode(root,150);
        addNode(root,150); // dont add duplicate value
        addNode(root,100);
        addNode(root,90);
        addNode(root,110);
        addNode(root,170);
        addNode(root,160);
        inOrderTraversal(root); // output 20 30 40 50 60 70 90 100 110 150 160 170 
        System.out.println();
        System.out.println(findMin(root)); // output 20
        System.out.println(findMax(root)); // output 170;
        System.out.println(searchValue(root,7)); // output false
    }
}

class Node{
    int value;
    Node  left,right;
    Node(){
        left =null;
        right = null;
        value = -1;
    }
    Node(int value){
        left =null;
        right = null;
        this.value = value;
    }
}
