public class insertionsort {
    public static int[] insertionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int currentElement = arr[i];
            for (int j = i-1; j >=0; j--) { // start from currentindex-1 to index 0 and compare with currentelement and shift currentelement
                if (arr[j] > currentElement ) {
                    arr[j+1] = arr[j];
                    arr[j] = currentElement;
                }
                else{break;} // prevent unnecessary compares
            }
        }

        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {3,5,2,1,16,4,1,7,3,9};
        int[] sorted = insertionSort(arr);

        for (int i : sorted) {
            System.out.print(i +" "); // output 1 1 2 3 3 4 5 7 9 16 
        }
    }
}
