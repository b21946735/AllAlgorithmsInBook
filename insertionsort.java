public class insertionsort {
    public static int[] insertionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int currentElement = arr[i];
            for (int j = i-1; j >=0; j--) {
                if (arr[j] > currentElement ) {
                    arr[j+1] = arr[j];
                    arr[j] = currentElement;
                }
            }
        }

        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {3,5,2,1,16,4,1,7,3,9};
        int[] sorted = insertionSort(arr);

        for (int i : sorted) {
            System.out.println(i);
        }
    }
}
