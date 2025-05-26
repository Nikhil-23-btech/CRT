import java.util.Scanner;
class Bubblesort {
    public static void printarray(int arr[]){
        for(int ele:arr){
            System.out.println(ele+" ");
        }
        System.out.print(" ");
    }
    public static void bubblesort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        printarray(arr);
        bubblesort(arr);
        printarray(arr);
    }
}
