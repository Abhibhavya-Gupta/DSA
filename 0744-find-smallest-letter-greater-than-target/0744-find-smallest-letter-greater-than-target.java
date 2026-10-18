class Solution {
    public char nextGreatestLetter(char[] arr, char target) {
         if (target >= arr[arr.length - 1]) {
            return arr[0];
        }
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                start=mid+1;
            }
        }
        return arr[start];
    }
}

