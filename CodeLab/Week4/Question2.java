import java.util.*;
//I have following coins 1,1,1,1,1,5,5,5,10,10,10,10, 25,25 Can I make a total of 73 cents.
// if yes how many combinations can I make print them out. Hint This is baqsically generate all sub sets (Binary sequence)

public class Question2 {


    static int count = 0;

    public static void main(String args[]) {

        int arr[] = {1,1,1,1,1,5,5,5,10,10,10,10, 25,25};
        int target = 73;
        combinationSum(arr, target);
        System.out.println("Total no of unique subset whose sum is equal to " + target + " = " + count);
    }

    private static void combinationSum(int[] arr, int target) {

        if (arr.length <= 0) {
            return;
        }
        int[] result = new int[arr.length];
        combinationSum(arr, result, 0, target);

    }

    static Set<Map<Integer, Integer>> set = new HashSet<Map<Integer,Integer>>();
    private static void  combinationSum(int[] arr, int[] result, int current, int target) {

        if (current == arr.length) {

            Map<Boolean, Map<Integer, Integer>> map2 = checkSum(result, arr, target);

            for (Map.Entry<Boolean, Map<Integer, Integer>> entry : map2.entrySet()) {
                if (entry.getKey() == true) {
                    boolean status=set.add(entry.getValue());
                    if(status==true){
                        printSubsets(result, arr);
                        count++;
                    }
                }
            }
            return ;
        }


        for (int i = 0; i < 2; i++) {
            result[current] = i;
            combinationSum(arr, result, current + 1, target);
        }


    }

    private static void printSubsets(int[] result, int[] arr) {

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 1) {
                sb.append(arr[i]);
                sb.append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        System.out.println(sb.toString());
    }


    private static Map<Boolean, Map<Integer, Integer>> checkSum(int[] result, int[] arr, int target) {
        Map<Boolean, Map<Integer, Integer>> map = new HashMap<Boolean, Map<Integer, Integer>>();
        Map<Integer, Integer> map1 = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 1) {
                sum = sum + arr[i];
            }
        }
        if (sum != target) {
            map.put(false, map1);
        } else {

            for (int i = 0; i < result.length; i++) {
                if (result[i] == 1) {
                    if (map1.containsKey(arr[i])) {
                        map1.put(arr[i], map1.get(arr[i]) + 1);
                    } else {
                        map1.put(arr[i], 1);
                    }
                }
            }

                map.put(true, map1);

        }
        return map;
    }
}
