import java.util.*;
public class weightedgraph {
    static class vertice{
        String value;
        int weight;
        vertice(String value, int weight){
            this.value= value;
            this.weight= weight;
        }
    }

    public static Map<String,ArrayList<vertice>> vertices = new HashMap<>();;
    public static ArrayList<String> marked = new ArrayList<>();
    public static Map<String,Integer> distances = new HashMap<>();
    public static int verticeCount=0;

    public static void dijkstraShortPath(String key){
        ArrayList<String> unMarked = new ArrayList<>();
        marked.add(key);
        distances.clear();
        fillDistances();
        distances.put(key,0);
        dijkstraShortPathRec(key,unMarked);
        marked.clear();
    }

    public static void dijkstraShortPathRec(String key,ArrayList<String> unMarked){
        int shortestDistance= 10000;
        String shortestDistanceKey = "";

        if (marked.size() == vertices.size()) {
            return;
        }
        for (vertice vert : vertices.get(key)) {
            if (distances.get(key) + vert.weight < distances.get(vert.value)) {
                distances.put(vert.value, distances.get(key) + vert.weight);
            }
            if(!marked.contains(vert.value) &&shortestDistance > distances.get(key) + vert.weight){
                shortestDistance = distances.get(key) + vert.weight;
                shortestDistanceKey = vert.value;
            }
        }
        if (shortestDistanceKey == "") {
            dijkstraShortPathRec(marked.get(marked.size()-2), unMarked);
        }
        else{
            marked.add(shortestDistanceKey);
            dijkstraShortPathRec(shortestDistanceKey, unMarked);
        }
    }

    public static void printDistances(){ // print as adj list
        for (String i : distances.keySet()) {           
            System.out.print(i +  ":" + distances.get(i) + " ");
            
            System.out.println();
        }
    }

    public static void fillDistances(){
        for (String str : vertices.keySet()) {
            distances.put(str,10000) ;
        }
    }


    public static void minSpanTreeRec(String key){
        if (verticeCount == marked.size()) { // found every vertice
            return;
        }

        int min = 100000;
        String minKey = "";

        for (String mark : marked) {
            for (vertice vert : vertices.get(mark)) {
                if (vert.weight <= min && !marked.contains(vert.value)) { // no cycles and find min weight
                    min = vert.weight;
                    minKey = vert.value;
                }
            }
        }

        marked.add(minKey);
        System.out.print( key + "->"+ minKey + ":" + min + " ");
        minSpanTreeRec(minKey); // recurse
    }

    public static void minSpanTree(String key){
        marked.add(key);
        minSpanTreeRec(key);
        marked.clear();
    }
    
    public static void main(String[] args) {
        //Minimum spanning tree

        addVertice("a");
        addVertice("b");
        addVertice("c");
        addVertice("d");
        addVertice("e");
        addVertice("f");
        addVertice("g");
        addVertice("h");
        addVertice("i");

        addEdge("a", "b",4);
        addEdge("a", "h",8);
        addEdge("b", "c",8);
        addEdge("b", "h",11);
        addEdge("c", "i",2);
        addEdge("c", "d",7);
        addEdge("c", "f",4);
        addEdge("d", "e",9);
        addEdge("d", "f",14);
        addEdge("e", "f",10);
        addEdge("f", "g",2);
        addEdge("g", "h",1);
        addEdge("g", "i",6);
        addEdge("h", "i",7);

        print();
        
        System.out.println("-------------");
        //minSpanTree("a"); // output a->b:4 b->c:8 c->i:2 i->f:4 f->g:2 g->h:1 h->d:7 d->e:9
        //System.out.println("-------------");
        dijkstraShortPath("a");
        printDistances();
    }


    public static void addVertice(String key){
        vertices.put(key, new ArrayList<vertice>());
        verticeCount++;
    }

    public static void addEdge(String key1 , String key2 , int weight){
        vertices.get(key1).add(new vertice(key2, weight));
        vertices.get(key2).add(new vertice(key1, weight));
    }

    public static void print(){ // print as adj list
        for (String i : vertices.keySet()) {
            System.out.print(i + ":  ");
            for (vertice sa : vertices.get(i)) {
                System.out.print(sa.value +  ":" + sa.weight + " ");
            } 
            System.out.println();
        }
    }

    
public static void BFS(String key){ // breath first search
    System.out.print(key+" ");
    marked.add(key);
    BFSrec(key,1);
    marked.clear();
    System.out.println();
}

private static void BFSrec(String key,int start){
    for (vertice vert : vertices.get(key)) {
        if (!marked.contains(vert.value)) {
            System.out.print(vert.value+" ");
            marked.add(vert.value);
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
    for (vertice vert :  vertices.get(key)) {
        if (!marked.contains(vert.value)) {
            System.out.print(vert.value+" ");
            marked.add(vert.value);
            DFSrec(vert.value);
        }
    }
}

}

