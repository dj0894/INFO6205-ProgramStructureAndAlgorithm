import java.util.*;


public class RotateArrayElement {

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter length of array");
        int len=sc.nextInt();
        System.out.println("Enter the K");

        int k=sc.nextInt();

        k = k % len; //finding the number of rotations.
        int nums[]=new int[len];

        System.out.println("Enter array elements");

        for(int i=0;i<len;i++) {
            nums[i]=sc.nextInt();
        }

        int temp[]=new int[k];
        int tempLen=0;
        for(int j=len-k;j<len;j++) {
            temp[tempLen]=nums[j];
            tempLen++;
        }
        for(int l=len-k-1;l>=0;l--) {
            nums[l+k]=nums[l];
        }
        for(int p=0;p<tempLen;p++) {
            nums[p]=temp[p];
        }
        System.out.println("Arrays after rotating to k steps "+ Arrays.toString(nums));
    }
}
