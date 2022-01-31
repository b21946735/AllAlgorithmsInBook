public class bubblesort {

    public static void bubbleSort(int[] arr){
        for (int i = 1; i < arr.length-1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,6,7,8,6,10};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
