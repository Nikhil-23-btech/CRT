/*This program used for finding the maximum sum of the subarray 
 * this is also called as Kadane's algorithm
 */

public class MaxSumofSubarray {
    public static int maxSubArray(int[] nums) {
        int currentmax = nums[0];
        int globalmax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentmax = Math.max(nums[i], currentmax + nums[i]);
            globalmax = Math.max(globalmax, currentmax);
        }
        return globalmax;
    }
    public static void main(String[] args) {
        int arr[]={-4,-1,-3,4,6,1};
        System.out.println(maxSubArray(arr));
    }
}

