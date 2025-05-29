import java.util.*;
public class LongestIncreasingSubsequence {
     public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); 
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int arr[]={10,9,2,5,3,7,10,18};
        System.out.println(lengthOfLIS(arr));
    }
}
