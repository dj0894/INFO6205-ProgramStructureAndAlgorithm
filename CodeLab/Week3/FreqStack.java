//https://leetcode.com/problems/maximum-frequency-stack/

import java.util.*;

public class FreqStack {


    HashMap<Integer,Node> map;
    ArrayList<Stack<Node>> al;

    public FreqStack() {
        this.map=new HashMap<>();
        this.al=new ArrayList<>();
        al.add(new Stack<>());
    }

    public void push(int element) {
        if(map.containsKey(element)){
            Node node=map.get(element);
            node.frequency++;
            if(al.size()<node.frequency){
                al.add(new Stack<>());
            }
            al.get(node.frequency-1).push(node);

        }else{
            Node node=new Node(element);
            map.put(element,node);
            al.get(0).push(node);
        }
    }

    public int pop() {
        int index=al.size()-1;
        Node node=al.get(index).pop();
        int result=node.val;
        node.frequency--;
        if(al.get(index).size()==0){

            al.remove(index);
        }
        return result;
    }

    class Node{
        int val;
        int frequency;
        public Node(int val){
            this.val=val;
            this.frequency=1;
        }
        public String toString(){
            return this.val+"   "+this.frequency+"  \n";
        }
    }


}
