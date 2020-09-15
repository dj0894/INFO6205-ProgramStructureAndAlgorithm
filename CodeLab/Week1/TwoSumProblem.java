import java.util.*;


public class TwoSumProblem {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter length of array");
        int n = sc.nextInt();

        int nums[] = new int[n];
        if (n < 2) {
            System.out.println("Please enter length of array greater than 1");
            return;
        }
        System.out.println("Enter target value");
        int target = sc.nextInt();
        System.out.println("Enter array values");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("Indices of elements whose sum is equal to target");
        for (int j = 0; j < n-1; j++) {
            for (int k = j + 1; k < n; k++) {
                if ((nums[j] + nums[k]) == target) {
                    System.out.println(j + " " + k);
                }
            }
        }


    }
}

