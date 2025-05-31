import java.util.*;
public class Coinchange {
    static int coinChange(int[] arr,int amount){
        int n=arr.length;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int coin:arr){
                if(coin<=i){
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
    public static void main(String[] args) {
        int coins[]={1};
        int amount=0;
        System.out.println(coinChange(coins, amount));
    }
}
