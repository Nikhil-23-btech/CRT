import java.util.Scanner;
public class Linearsearch {
    public static int linear(int[] arr,int ele){
        for(int i:arr){
            if(ele==i){
                return i;
            }
        }
        return -1;
        }
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
        System.out.println("The element found at "+linear(arr, ele));
    }

    }

