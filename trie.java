public class trie {
    public static int maxChar = 256;
    public static Node root  = new Node();;


    private static void addNode(Node root,char c,boolean isEnd,int value){
        if (root.next[c] == null) {
            root.next[c] = new Node(c,isEnd,value);
        }
    }

    public static void addWord(Node root,String str,int value){
        int len = str.length();
        int i = 0;
        for ( i = 0; i < len-1; i++) {
            addNode(root,str.charAt(i),false,0);
            root = root.next[str.charAt(i)];
        }
        addNode(root,str.charAt(i),true,value);
    }

    public static void traversal(Node root){
        for (Node nod : root.next) {
            if (nod != null) {
                System.out.print(nod.c);
                if (nod.isEnd) {
                    System.out.println();
                }
                traversal(nod);
            }
        }
    }

    public static boolean isWordInTrie(Node root,String word){
        for (char c : word.toCharArray()) {
            if (root.next[c] == null) {
                return false;
            }
            root = root.next[c];
        }
        return true;
    }

    public static int valueOfWord(Node root,String word){
        for (char c : word.toCharArray()) {
            root = root.next[c];
        }
        return root.value;
    }

    public static void main(String[] args) {
        addWord(root, "as",0);
        addWord(root, "ab",0);
        addWord(root, "cb",0);
        
    }

    public static class Node{
        boolean isEnd =false;
        int value = 0;
        Character c ;
        Node[] next ;
        Node() {
            this.next = new Node[trie.maxChar];
            c = null;
        }
        Node(Character c ,boolean x,int value) {
            this.next = new Node[trie.maxChar];
            this.isEnd = x;
            this.c = c;
            this.value= value;
        }
    }
}




