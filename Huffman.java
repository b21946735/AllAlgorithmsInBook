import java.util.*;
import java.util.BitSet;

public class Huffman{
    


    public static Map<Character,vert> frequency(String str){
        Map<Character,vert> sa = new HashMap<Character,vert>();
        
        for (char c : str.toCharArray()) {
            int count = sa.containsKey(c) ? sa.get(c).val : 0;
            sa.put(c,new vert(c,count+1));
        }
        return sa;
    }

    public static ArrayList<String> inOrderTraversal(HuffmanNode root,String str,ArrayList<String> arr){
        if (root != null) {
            inOrderTraversal(root.left,str+"0",arr);
            //System.out.print(root.value+" ");
            inOrderTraversal(root.right,str+"1",arr);
            if (root.left == null && root.right == null) {
                arr.add(str);
            }
        }
        return arr;
    }

    public static Map<Character,String> createHuffmanTree(vert[] verts){
        ArrayList<HuffmanNode> huffs = new ArrayList<>();
        HuffmanNode root ;
        for (vert v : verts) {
            huffs.add(new HuffmanNode(v.val));
        }
        root = huffs.get(0);
        while (huffs.size()>1) {
            HuffmanNode left = huffs.get(0);
            huffs.remove(0);
            HuffmanNode right = huffs.get(0);
            huffs.remove(0);
            HuffmanNode top = new HuffmanNode(left.value+right.value,left,right);
            huffs.add(top);
            Collections.sort(huffs);
            root = top;
        }
        ArrayList<String> arr =new ArrayList<>();
        inOrderTraversal(root,"",arr);
        Map<Character,String> bits = new HashMap<Character,String>();
        for (int i = 0; i < verts.length; i++) {
            bits.put(verts[i].c, arr.get(i));
        }
        return bits; 
    }

    public static String decode(Map<Character,String> bits , String bitstring ){
        Map<String,Character> decode   =createDecodeTable(bits);
        String str= "";
        String temp = "";
        for (char c : bitstring.toCharArray()) {
            temp +=c;
            if(decode.containsKey(temp)){
                str+= decode.get(temp);
                temp  = "";
            }
        }
        return str;
    }

    public static Map<String,Character> createDecodeTable(Map<Character,String> bits){
        Map<String,Character> decode= new HashMap<String,Character>();
        for (char c : bits.keySet()) {
            decode.put(bits.get(c), c);
        }
        return decode;
    }


    public static void main(String[] args) {
        String str = "BCCABBDDAECCBBAEDDCC";
        Map<Character,vert> freq = frequency(str);
        vert[] verts = freq.values().toArray(new vert[freq.values().size()]);
        Arrays.sort(verts);
        
        Map<Character,String> encodeTable =createHuffmanTree(verts); // encode table
        String bString="" ; // bitstring
        for (char c : str.toCharArray()) {
            bString += encodeTable.get(c);
        }
        System.out.println(bString);

        System.out.println(decode(encodeTable, bString));
    }
}

class HuffmanNode implements Comparable<HuffmanNode>{
    Integer value= 0 ;
    HuffmanNode left = null;
    HuffmanNode right =null;
    HuffmanNode(int value,HuffmanNode left,HuffmanNode right){
        this.value = value;
        this.left = left;
        this.right= right;
    }
    HuffmanNode(int value){
        this.value = value;
    }

    @Override
    public int compareTo(HuffmanNode o)
    {
        if (this.value != o.value) {
            return this.value - o.value;
        }
        return this.value.compareTo(o.value);
    }

}

class vert implements Comparable<vert>{
    
    char c;
    Integer val;
    vert(char c ,int val){
        this.c = c;
        this.val = val;
    }
    vert(int val){
        this.val = val;
    }

    @Override
    public int compareTo(vert o)
    {
        if (this.val != o.val) {
            return this.val - o.val;
        }
        return this.val.compareTo(o.val);
    }

}
