public class quicksort {

    public static int[] quickSort(int[] arr , int len , int i ,int j ){
        if (i == j) { // base case
            return arr;
        }
        int pivot = i++; // pivot is first element of current list
        while(i<=j){ // if i pass j then stop
            if (arr[i]>=arr[pivot]) { // if proper i found
                if (arr[j] <= arr[pivot]) { // if proper j found
                    arr = swap(arr, j, i);
                    i++;j--;
                }
                else{
                    j--;
                }
            }
            else{
                i++;
            }
        }
        arr = swap(arr, pivot, j);
        if ( pivot !=j ) { 
            quickSort(arr, len , pivot , j-1); // check left side
            if (i < len-1) { // if end of list
                quickSort(arr, len , i , len-1); // check right side
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
        int[] nums = {3,2,8,1,10,2,7,0,2,6,8,12,9,13};

        int[] sorted = quickSort(nums, nums.length , 0 , nums.length-1);

        for (int k : sorted) {
            System.out.print(k +" "); // 0 1 2 2 2 3 6 7 8 8 9 10 12 13 
        }
        
    }
}
