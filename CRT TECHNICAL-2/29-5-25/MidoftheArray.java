/*Code for finding the mid value of the array */

public class MidoftheArray {
    public static int finding(int[] arr){
        int slow=0,fast=0;
        while(fast<arr.length && fast+1<arr.length){
            slow++;
            fast+=2;
        }
        return arr[slow];
    }
    public static void main(String args[]){
        int[] arr={1,2,3,4,5};
        System.out.println(finding(arr));
    }
}
