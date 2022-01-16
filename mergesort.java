public class mergesort {

    public static int[] mergeSort(int[] arr,int low,int upp){ 
        
        int mid = low + (int)((upp-low)/2); // set mid point
        int[] lower; // lower array
        int[] upper; // upper array
        if (low <upp ) { // if there is more than one element in array
            lower = mergeSort(arr, low, mid); 
            upper = mergeSort(arr, mid+1, upp);
            return  merge(lower,upper); // combine 2 arrays
        }
        int [] ret = new int[upp-low+1]; // copy array
        int index = 0;
        for (int i = low; i < upp+1; i++) {
            ret[index++] = arr[i]; 
        }
        
        return ret;
    }

    public static int[] merge(int[] lower , int[] upper){
        int[] newArr = new int[lower.length+upper.length];
        
        int low =0; // current index in lower array
        int upp = 0; // current index in upper array
        for (int i = 0; i < newArr.length; i++) {
            if ( low < lower.length && upp < upper.length) {
                if (lower[low] < upper[upp] ) {
                    newArr[i] = lower[low];
                    low++;
                }
                else{
                    newArr[i] = upper[upp];
                    upp++;
                }
            }
            else{
                if ( low < lower.length) {
                    newArr[i] = lower[low];
                    low++;
                }
                else if ( upp < upper.length){
                    newArr[i] = upper[upp];
                    upp++;
                }
            }
        }

        return newArr; // return merged array
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,7,13 ,6 ,3 ,1}; 

        int[] sortedNums = mergeSort(nums,0,nums.length-1);

        for (int i : sortedNums) {
            System.out.print(i + " ");
        }
    }
}
