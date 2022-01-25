public class string {
    
  

    public static int[] max(char[] nums){
        int max = (int)nums[0];
        int min = (int)nums[0];

        for (int i : nums) {
            if ((int)i> max) {
                max = (int)i;
            }
            if ((int)i <min) {
                min = (int)i;
            }
        }
        return  new int[]{max,min};
    }

    public static int[] keyIndexCount(char[] nums){
        int[] maxmin = max(nums);
        int[] aux = new int[maxmin[0]+3]; // store max at 0 min at 1
        aux[0] = maxmin[0];
        aux[1] = maxmin[1];
        for (int i = 0; i < nums.length; i++) {
            aux[nums[i]] ++;
        }
        return aux;
    }

    public static char[] keyIndexSort( char[] str){
        int[] aux = keyIndexCount(str);
        int index= 0;
        for (int i = aux[1]; i < aux.length; i++) { // start from min so no unnecessary 
            for (int j = 0; j < aux[i]; j++) { // if 0 then pass
                str[index++] = (char)i; 
                System.out.print((char)i+" ");  
            }
        }
        return str;
    }

    public static int subStrSearchKnuthMorris(char[] word,char[] subWord){
        int[][] sa = createAuxArray(toIntArray(subWord));
        int index = 0;
        int i =0 ;
        int j = -1;
        for (i =0 ; i<word.length ; i++) {
            if (j== sa[0].length-1) {
                    return index;
            }

            if (word[i] == sa[0][j+1]) {
                j++;
                if (j == 0) {
                    index = i;
                }
            }
            else{
                if (j != -1) {
                    j = sa[1][j]-1;
                    i--;
                }
            }
        }

        if (j== sa[0].length-1) {
            return index;
        }

        return -1;
    }

    public static int[][] createAuxArray(int[] arr){
        int[][] aux = {arr,new int[arr.length]};
        int x = 1;
        int i = 0;
        int j = 1;
        for ( j = 1; j < arr.length; j++) {
            if (arr[i] == arr[j]) {
                aux[1][j] = x;
                i++;
                x++;
            }
            else{
                x=1;
                i = 0;
            }
        }
        return aux;
    }

    public static int[] toIntArray(char[] arr){
        int[] sa = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sa[i] = arr[i];
        }
        return sa;
    }

    public static boolean subStrSearchBrutForce(char[] word , char[] subWord){
        for (int i = 0; i < word.length; i++) {
            for (int j = 0; j < subWord.length; j++) {
                if (word[i+j] == subWord[j]) {
                    if (j== subWord.length-1) {
                        return true;
                    }
                }
                else{break;}
            }
        }
        return false;
    }

    public static int maxS(String[] a){
        int max = a[0].length();
        for (String string : a) {
            if (string.length()>max) {
                max = string.length();
            }
        }
        return max;
    }

    public static void fillWithEmptyChar(String[] a,int max){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < max-a[i].length(); j++) {
                a[i] = " "+a[i];
            }
        }
    }
 
    public static void LSDsort(String[] a ){ // O(W(R+3N)) problem strings must be same length
        int W = a[0].length()-1; // longest string in array
        int N = a.length; // count of string
        int R = 256; // alphabet size
        String[] aux = new String[N];
        for (int d = W; d >= 0; d--) // apply key index count to every char.
        { 
            int[] count = new int[R+1]; 
            for (int i = 0; i < N; i++) // increase indexes
                count[a[i].charAt(d) + 1]++;
            for (int r = 0; r < R; r++) 
                count[r+1] += count[r];
            for (int i = 0; i < N; i++) 
                aux[count[a[i].charAt(d)]++] = a[i];
            for (int i = 0; i < N; i++) 
                a[i] = aux[i];
        }
    }

    public static void main(String[] args) {
        String word = " ababcabcabababd ababcabcabababd ababcabcabababd ababcabcabababd ababcabcabababd ababcabcabababd ababcabcabababd ababcabcabababd ababcabcabababd ababcabcabababd ababcabcabababd ababcabcabababd ababcabcabababd";
        String subWord = "ababd";

        //keyIndexSort(word.toCharArray());
        String[] sa = {"cd","fg","fd","td"};
        LSDsort(sa);
        for (String string : sa) {
            System.out.print(string+ " ");
        }
        

        /*
        int subStartIndex= subStrSearchKnuthMorris(word.toCharArray(),subWord.toCharArray());
        if ( subStartIndex != -1) {
            System.out.println("Substring "+subWord + " start at " +subStartIndex +" in "+ word);
        }else{System.out.println("There is no substr");}
        */

        //System.out.println( subStrSearchBrutForce(word.toCharArray(), subWord.toCharArray()));


    }


}
