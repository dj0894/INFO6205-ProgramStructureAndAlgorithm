//1. There are 3 buckets of unlimited 5, 10 and 25 cents.
// If we can pick 5 coins, print all the combinations of  the coins that can be made.

import java.util.Arrays;

public class Question1 {

    public static void main(String args[]){
        int[] coins={5,10,25};
        combinationCoins(coins, 5);
    }

    private static void combinationCoins(int[] coins, int size){
        if(coins.length==0){
            return;
        }

        int[] result=new int[size];
        combinationCoins(result,coins,size,0);
    }

    private static void combinationCoins(int[] result,int[] coins,int size,int current){

        if(current==size){
            System.out.println(Arrays.toString(result));
            return;
        }

        for(int i=0;i<coins.length;i++){
            result[current]=coins[i];
            combinationCoins(result, coins,size, current+1);
        }
    }
}
