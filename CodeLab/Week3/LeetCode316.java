//https://leetcode.com/problems/remove-duplicate-letters/

import java.util.*;

public class LeetCode316 {

    public String removeDuplicateLetters(String s) {
        StringBuilder result=new StringBuilder();
        HashMap<Character,Integer>map=new HashMap<>();
        Stack<Character>stack=new Stack<Character>();
        HashSet<Character>set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.get(ch)-1);
            if(set.contains(ch)){
                if(map.get(ch)==0)
                    map.remove(ch);
                continue;
            }
            set.add(ch);
            if(map.get(ch)==0)
                map.remove(ch);
            if(stack.size()==0)
                stack.push(ch);
            else{
                while(stack.size()!=0&&map.containsKey(stack.peek())&&ch<stack.peek())
                    set.remove(stack.pop());
                stack.push(ch);
            }
        }
        while(stack.size()!=0){
            result.append(stack.pop());
        }

        return result.reverse().toString();

    }
}
