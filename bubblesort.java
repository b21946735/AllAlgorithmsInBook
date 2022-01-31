public class bubblesort {

    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,3,12,6,124,5,6,346,31,77};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
