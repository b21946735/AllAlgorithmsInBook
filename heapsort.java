public class heapsort{
    
    public static int[] heapSort(int[] heap){
        int lastIndex = heap.length-1; // place to store element that is going to delete
        while (lastIndex >0) {
            heap = deleteMax(heap,lastIndex);
            lastIndex--;
        }
        return heap;
    }

    public static int[] deleteMax(int[] heap,int lastIndex){
        int root = heap[0]; // hold root
        heap[0] = heap[lastIndex]; // set root as last element
        int i = 0;
        while (i*2+1 < lastIndex) { // while there is child
            if (heap[i*2 +1] > heap[i] && heap[i*2 +1] > heap[i*2 +2]) { // percolate down to left
                heap= swap(heap, i, i*2+1);
                i = i*2+1;
            }
            else if (heap[i*2 +2] > heap[i] && heap[i*2 +2] > heap[i*2 +1] ) { // percolate down to right
                heap= swap(heap, i, i*2+2);
                i = i*2+2;
            }
            else{ // no percolate down
                break;
            }
        }
        heap[lastIndex] = root; // push root to end of array
        return heap;
    }
    
    public static int[] heapify(int[] arr){ // O(N) heap creation
        for (int i = arr.length-1; i >=0; i--) {
            if (arr[i] > arr[(int)((i-1)/2)]) {
                arr = swap(arr,i,(int)((i-1)/2));
                int k = i;
                while(k*2 + 1 <= arr.length-1){
                    if (arr[k] < arr[(int)((k*2 +1))]) {
                        arr = swap(arr,k,(int)(k*2 +1));
                    }
                    k = k*2 +1;
                }
            }
        }
        return arr;
    }

    public static int[] swap(int[] arr ,int i ,int j){ // swap places of 2 elements of list
        int copy2 = arr[i];
        arr[i] = arr[j];
        arr[j] = copy2;
        return arr;
    }
    public static void main(String[] args) {
        int[] nums = {10,20,100,200,13,60,30,70,40};

        int[] sortedMaxHeap = heapify(nums); // create heap array from array
        sortedMaxHeap = heapSort(sortedMaxHeap); // sorted array with priority queue
        for (int j : sortedMaxHeap) {
            System.out.print(j +" ");
        }
    }
}
