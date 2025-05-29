import java.util.*;
public class Memorization {
    static int Topdown(int n,int dp[]){
        if(n<=1)
            return n;
        if(dp[n]!=-1)
            return (dp[n]);
        return dp[n]=Topdown(n-1,dp)+Topdown(n-2,dp);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(Topdown(n,dp));
    }
}
