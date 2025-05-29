public class MinumumSubArraySum {
    public static int minsumarraylength(int[] nums,int target){
        int left=0;
        int sum=0;
        int minlen=Integer.MAX_VALUE;
        for(int right=0;right<nums.length;right++){
            sum=sum+nums[right];
            while(sum>=target){
                minlen=Math.min(minlen,right-left+1);
                sum=sum-nums[left++];
            }
        }
        return minlen==Integer.MAX_VALUE? 0:minlen;
    }
    public static void main(String[] args) {
        int[] arr={2,3,1,2,4,3};
        int target=7;
        System.out.println(minsumarraylength(arr, target));
    }
}
