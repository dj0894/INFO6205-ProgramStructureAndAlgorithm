//https://leetcode.com/problems/next-greater-element-i/

import java.util.*;

public class LeetCode496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map= new HashMap<Integer, Integer>();
        for(int i=0;i<nums2.length;i++)
            map.put(nums2[i],i);
        int result[]= new int[nums1.length];

        for(int i=0;i<nums1.length;i++){
            result[i]=search(map.get(nums1[i]),nums1[i],nums2);
        }
        return result;

    }
    private int search(int index, int element,int[] nums2){
        int result=-1;
        for(int i=index+1;i<nums2.length;i++){
            if(nums2[i]>element){
                result=nums2[i];
                break;
            }
        }return result;
    }
}
