public class RearrangeEvenOdd{
static void rearrange(int[] arr){
int low=0,mid=0;
while(mid<arr.length){
if(arr[mid]%2==1){
int temp=arr[low];
arr[low]=arr[mid];
arr[mid]=temp;
low++;
}
mid++;
}
}
public static void main(String args[]){
int arr[]={1,2,3,4,5,6};
rearrange(arr);
for(int ele:arr){
    System.out.print(ele+" ");
}
}
}


