import java.util.Scanner;
public class Mergesort {
    public static void mergesort(int[] arr,int left,int right){
        if(left<right){
            int mid=left+(right-left)/2;
            mergesort(arr,left,mid);
            mergesort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }
    private static void merge(int[] arr,int left,int mid,int right){
        int n1=mid-left+1;
        int n2=right-mid;
        int[] l=new int[n1];
        int[] r=new int[n2];
        for(int i=0;i<n1;i++){
            l[i]=arr[left+i];
        }
        for(int j=0;j<n2;j++){
            r[j]=arr[mid+1+j];
        }
        int i=0,j=0;
        int k=left;
        while(i<n1 && j<n2){
            if(l[i]<=r[j]){
                arr[k]=l[i];
                i++;
            }
            else{
                arr[k]=r[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k]=l[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=r[j];
            j++;
            k++;
        }
    }
    public static void printarray(int[] arr){
        for(int value:arr){
            System.out.print(value+" ");
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("The original array:");
        printarray(arr);
        System.out.println("The sorted array:");
        mergesort(arr,0 , n-1);
        printarray(arr);
    }
}
