import java.util.Scanner;
class Selectionsort {
    public static void selectionsort(int arr[]){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int minindex=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[minindex]){
                    minindex=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[minindex];
            arr[minindex]=temp;
        }
    }
    public static void printarray(int[] arr){
        for(int ele:arr){
            System.out.print(ele);
        }
        System.out.println();
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
        System.out.println("Sorted array");
        selectionsort(arr);
    }
} 