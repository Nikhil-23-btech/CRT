import java.util.Scanner;
public class Binarysearch {
    static int recursivebinary(int[] arr,int low,int high,int target){
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]<target) return recursivebinary(arr, mid+1, high, target);
            else return recursivebinary(arr, low, mid-1, target);
        }
        return -1;
    }
    /*public static int searching(int[] arr,int ele){
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(ele==arr[mid]){
                return mid;
            }
            else if(arr[mid]>ele){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }*/
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("Enter the elements");
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Element to search");
        int ele=sc.nextInt();
        System.out.println("The element found at "+recursivebinary(arr, 0, n-1, ele));
    }
}
