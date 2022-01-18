public class hashtable {
    public static int hashcode = 11;
    public static int size = hashcode;
    
    public static int[] insert(int[] table, int value){
        int hash = (value  % hashcode)*size/ hashcode;
        int repeat = 0;
        while (table[hash] != 0) {
            if (table[hash] == value) { // no repetition
                return table;
            }
            hash = (hash +1 )%hashcode;
            if (repeat++ > size) { // full array
                table =resize(table);
                insert(table, value);
                return table;
            }
        }
        table[hash] = value;
        return table;
    }

    public static void delete(int[] table,int value){
        int hash = (value  % hashcode)*size/ hashcode;
        int repeat = 0;
        while (table[hash] != value) {
            hash = (hash +1 )%hashcode;
            if (repeat++ > size) { // full array
                System.out.println("not found");
                return;
            }
        }
        table[hash] = 0;
    }

    public static int findIndex(int[] table,int value){
        int hash = (value  % hashcode)*size/ hashcode;
        int repeat = 0;
        while (table[hash] != value) {
            hash = (hash +1 )%hashcode;
            if (repeat++ > size) { // full array
                return -1;
            }
        }
        return hash;
    }

    public static int[] resize(int[] table){
        size = size*2;
        int[] hashTable = new int[size];
        for (int i : table) {
            if (i !=0) {
                insert(hashTable,i);
            }
        }
        return hashTable;
    }

    public static void main(String[] args) {
        int[] hashTable = new int[size];

        insert(hashTable, 3);
        insert(hashTable, 14);
        insert(hashTable, 15);
        insert(hashTable, 2);
        insert(hashTable, 1);
        insert(hashTable, 6);
        insert(hashTable, 5);
        insert(hashTable, 7);
        insert(hashTable, 8);
        insert(hashTable, 9);
        insert(hashTable, 10);
        for (int i : hashTable) { // output 10 1 2 3 14 15 6 5 7 8 9 
            System.out.print(i + " ");
        }
        System.out.println();

        hashTable= insert(hashTable, 11);


        for (int i : hashTable) { // output 11 0 1 0 2 0 3 14 15 0 5 0 6 0 7 0 8 0 9 0 10 0
            System.out.print(i + " ");
        }
    }
}