import java.util.Scanner;
public class Insertionsort {
    public static void printarray(int arr[]){
        for(int ele:arr){
            System.out.print(ele+" ");
        }
        System.out.println(" ");
    }
    static void insertionsort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0 && key<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
    public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int arr[]=new int[n];
    for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
    }
    System.out.println("Original array");
    printarray(arr);
    insertionsort(arr);
    System.out.println("Sorted array");
    printarray(arr);
}
}