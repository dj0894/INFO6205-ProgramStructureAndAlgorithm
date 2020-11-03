import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String args[]){

       // binarySequence(3);
       // ternarySequence(3);
       // combination("ABC");
        //combinationOfnSize("ABC", 2);
        int[] coins={5,10,15};
        //combinationCoins(coins, 5);
        generateAllSubsets("ABC");

    }


    private static void binarySequence(int n){
     if(n<=0){
         return;
     }

     int[] result=new int[n];
     binarySquence(result,0);


    }

    private static void binarySquence(int[] result, int current){
        if(current==result.length){
            System.out.println(Arrays.toString(result));
            return;
        }

        for(int i=0;i<3;i++){
            result[current]=i;
            binarySquence(result, current+1);
        }
    }

    private static void ternarySequence(int n){
        if(n<=0){
            return ;

        }

        int[] result=new int[n];
        ternarySequence(result,0);

    }

    private static void ternarySequence(int[] result, int current){

        if(current==result.length){
            System.out.println(Arrays.toString(result));
            return;
        }


        for(int i=0;i<3;i++){
            result[current]=i;
            binarySquence(result, current+1);
        }
    }


    //Finding all the combination of String like of ABC

    private static void combination(String str){
        if(str.length()==0){
            return;
        }

        char[] arr=new char[str.length()];
        combination(arr,str,0);
    }

    private static void combination(char[] arr, String str, int current){
        if(current==str.length()){
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i=0;i<str.length();i++) {
            arr[current]=str.charAt(i);
            combination(arr, str,current + 1);
        }

    }

    //End of Finding all the combination of String like of ABC


    //Finding all the combinations of ABC of size 2
    //ex: AA,AB,AC,BA,BB,BC etc

    private static void combinationOfnSize(String str,int size){
        if(str.length()<=0){
            return;
        }

        char[] arr=new char[str.length()-1];
        combinationOfnSize(arr, str, size,0);
    }

    private static void combinationOfnSize(char[] arr, String str,int size, int current) {

        if(current==size){
            System.out.println(arr);
            return;
        }

        for(int i=0;i<str.length();i++){
            arr[current]=str.charAt(i);
            combinationOfnSize(arr,str,size,current+1);
        }
    }

    //End of Finding all the combinations of ABC of size 2
    // ex: AA,AB,AC,BA,BB,BC etc


    //Finding no of combination of coins
    //Assume there is bucket of unlimited coins of 5 cents, 10 cents, 25 cents. You have to find all the combination of size 2
    // i.e at any given point of time you can pick only two coins

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

    //End

    //Generate all the subsets of a given string

    private static void generateAllSubsets(String str){
        if(str.length()<=0){
            return;
        }
        int[] result=new int[str.length()];
        generateAllSubsets(str,result, 0);
    }

    private static void generateAllSubsets(String str,int[] result,int current){

        if(current==str.length()){
           // System.out.println(Arrays.toString(result));
            printSubsets(str,result);
            return;
        }

        for(int i=0;i<2;i++){
            result[current]=i;
            generateAllSubsets(str,result,current+1);
        }
    }

    private static void printSubsets(String str, int[] result){
        StringBuilder sb=new StringBuilder();
        sb.append("{");
        for(int i=0;i<result.length;i++){
            if(result[i]==1){
                sb.append(str.charAt(i)+",");
            }

        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        System.out.println(sb.toString());
    }




    }
