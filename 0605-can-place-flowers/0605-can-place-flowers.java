class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        if((arr.length==1 && arr[0]==0) || n==0) return true;
        for(int i=0;i<arr.length;i++)
        {
            if(i==0 && arr[0]==0 && arr[1]==0 || i==arr.length-1 && arr[i]==0 && arr[arr.length-2]==0)
            {
                arr[i]=1;
                n--;
            }
            else if(i>0 && i<arr.length-1 && arr[i]==0 && arr[i-1]==0 && arr[i+1]==0){
               arr[i]=1;
                n--;
            }
            if(n==0) return true;
        }
        return false;
    }
}