/*The code for fixed window size k */

class MaximumSubArray{
    static int maxSubarraysum(int arr[],int k){
        int l=arr.length;
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        int maxsum=sum;
        for(int i=k;i<arr.length;i++){
            sum=sum+(arr[i]-arr[i-k]);
            maxsum=Math.max(maxsum,sum);
        }
        return maxsum;
    }
    public static void main(String[] args) {
        int arr[]={25,13,9,16,18,35,46,41};
        int k=4;
        System.out.println(maxSubarraysum(arr,k));
    }
}