
public class Movingzeros {
    public static int[] zeros(int[] arr){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                arr[count]=arr[i];
                count=count+1;
            }
        }
        while(count<arr.length){
            arr[count]=0;
            count=count+1;
        }
        return arr;
    }
    public static void main(String args[]){
        int[] arr={1,0,13,0,2};
        int[] updated=zeros(arr);
        for(int ele:updated){
            System.out.print(ele+" ");
        }
    }
}
