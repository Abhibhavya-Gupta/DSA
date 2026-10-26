class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int s=0;
        int e=arr.length-1;
        int m=s + (e-s)/2;
        while((m+1 <arr.length && arr[m]<arr[m+1]) || (m-1>=0 && arr[m]<arr[m-1]))
        {
            m=s + (e-s)/2;
            if(arr[m]<arr[m+1])
            {
                s=m+1;
            }
            else if(arr[m]<arr[m-1])
            {
                e=m-1;
            }
        }
        return m;
    }
}