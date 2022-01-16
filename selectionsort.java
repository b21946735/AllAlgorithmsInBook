public class selectionsort {

    public static int[] SelectionSort(int[] nums){
        int currentIndex = 0; // last sorted index

        for (int i = 0; i < nums.length; i++) {
            int indexOfMin=currentIndex; // index of minimum element
            for (int j = currentIndex; j < nums.length; j++) { 
                if (nums[j] < nums[indexOfMin]) { // if element smaller than last minimum then set it minimum
                    indexOfMin = j;
                }
            }
            int copy = nums[currentIndex]; // copy element so no need to shift
            nums[currentIndex] = nums[indexOfMin]; // set current index to minimum
            nums[indexOfMin] = copy; 
            currentIndex++; 
        }

        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {3,2,7,1,6,2,7,13}; 

        int[] sortedNums = SelectionSort(nums);

        for (int i : sortedNums) {
            System.out.print(i + " "); // output : 1 2 2 3 6 7 7 13 
        }
    }
 }
