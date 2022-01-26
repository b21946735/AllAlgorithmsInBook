public class LZWComp {
    static boolean isInTrie(String word){
        return trie.isWordInTrie(trie.root, word);
    }

    static void addWord(String word,int value){
        trie.addWord(trie.root, word,value);
    }

    static int getValue(String word){
        return trie.valueOfWord(trie.root, word);
    }
    
    static int findMax(String word){
        int max = word.charAt(0);
        for (char c : word.toCharArray()) {
            if (c> max) {
                max = c;
            }
        }
        return max;
    }
    
    static void LZW(String word){
        int n = word.length();
        int current = findMax(word)+1;
        char[] compressed = new char[n];
        int j = 0;
        boolean pass = false;
        for (int i = 0; i < n-1; i++) {
            if(!pass){
                compressed[j] = word.charAt(i);
            }
            if (!isInTrie(concatanate(compressed[j], word.charAt(i+1)))) {
                addWord(concatanate(compressed[j], word.charAt(i+1)),current++);
                pass =false;
                j++;
                compressed[j] = word.charAt(i+1);
            }
            else{
                compressed[j]  = (char)getValue(concatanate(compressed[j], word.charAt(i+1)));
                pass =true;
            }
        }
        for (char c : compressed) {
            System.out.print(c);
        }
    }
    
    public static void main(String[] args) {
        String word = "abcdbcdbcd";
        LZW(word);        
        
    }

    static String concatanate(char c1,char c2){return String.valueOf(c1)+String.valueOf(c2);}
    static String concatanate(String c1,char c2){return c1+String.valueOf(c2);}
    static String concatanate(String c1,String c2){return c1+c2;}
    static String concatanate(char c1,String c2){return String.valueOf(c1)+c2;}
}

