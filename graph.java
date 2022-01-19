import java.util.ArrayList;
import java.util.Map;
import java.util.*;
public class graph {
    public static Map<String,ArrayList<String>> vertices = new HashMap<>();;
    public static ArrayList<String> marked = new ArrayList<>();

    public static void addVertice(String key){
        vertices.put(key, new ArrayList<String>());
    }

    public static void addEdge(String key1 , String key2){
        vertices.get(key1).add(key2);
        vertices.get(key2).add(key1);
    }

    public static void BFS(String key){ // breath first search
        System.out.print(key+" ");
        marked.add(key);
        BFSrec(key,1);
        marked.clear();
        System.out.println();
    }

    private static void BFSrec(String key,int start){
        for (String vert : vertices.get(key)) {
            if (!marked.contains(vert)) {
                System.out.print(vert+" ");
                marked.add(vert);
            }
        }
        
        for (int i = start; i < marked.size(); i++) {
            BFSrec(marked.get(i), marked.size());
        }
    }

    public static void DFS(String key){ // depth first search
        System.out.print(key+" ");
        marked.add(key);
        DFSrec(key);
        marked.clear();
        System.out.println();
    }

    private static void DFSrec(String key){
        for (String vert :  vertices.get(key)) {
            if (!marked.contains(vert)) {
                System.out.print(vert+" ");
                marked.add(vert);
                DFSrec(vert);
            }
        }
    }

    public static void print(){ // print as adj list
        for (String i : vertices.keySet()) {
            System.out.print(i + ":");
            for (String sa : vertices.get(i)) {
                System.out.print(sa +  " ");
            } 
            System.out.println();
        }
    }

    public static void main(String[] args) {
        addVertice("a");
        addVertice("b");
        addVertice("c");
        addVertice("e");
        addVertice("d");
        addVertice("g");
        addVertice("h");

        addEdge("a", "b");
        addEdge("a", "c");
        addEdge("b", "e");
        addEdge("b", "d");
        addEdge("e", "g");
        addEdge("g", "h");
        BFS("a"); // output a b c e d g h 
        DFS("a"); // output a b e g h d c
        print(); /* output 
        a:b c
        b:a e d
        c:a
        d:b
        e:b g
        g:e h
        h:g
        */
    }
}

