/*With n elements of array we can form 2^n subsets */

public class Subsetum {
    static boolean isSubsetSum(int[] arr,int n,int target){
        if(target==0) return true;
        if(n==0) return false;
        if(arr[n-1]>target){
            return isSubsetSum(arr, n-1, target);
        }
        return isSubsetSum(arr, n-1, target) || isSubsetSum(arr, n-1, target-arr[n-1]);
    }
    public static void main(String[] args) {
        int[] arr={3,54,4,12,5,2};
        int target=75;
        boolean result=isSubsetSum(arr, arr.length, target);
        System.out.println(target+(result?"exists.":"Doesnot exist"));
    }
}
