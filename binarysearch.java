public class binarysearch {

    public static int binarySearch(int[] arr , int value , int start , int end){
        int index = (int)((end+start)/2); // mid point

        if (  arr[index] == value) { // if found
            return index;
        }
        else if (start >= end){ // if value not in list
            System.out.println("not found");
            return -1;
        }
        
        if (arr[index] < value) { // check right side
            index = binarySearch(arr, value, index+1, end);
        }
        else{ // check left side
            index = binarySearch(arr, value, start, index-1);
        }

        return index;
    }
    public static void main(String[] args) {
        int[] nums = {1,5,6,7,8,9,10,11,12};
        System.out.println(binarySearch(nums,10,0,nums.length-1)); // return index of value
    }
}
