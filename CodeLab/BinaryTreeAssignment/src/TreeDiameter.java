//https://leetcode.com/problems/diameter-of-binary-tree/

import java.util.*;


public class TreeDiameter {
        int answer = 0;
        int farthest = -1;

        public int treeDiameter(int[][] edges) {
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for(int[] edge : edges) {
                map.putIfAbsent(edge[0], new ArrayList<>());
                map.putIfAbsent(edge[1], new ArrayList<>());

                List<Integer> first = map.get(edge[0]);
                first.add(edge[1]);
                map.put(edge[0], first);

                List<Integer> second = map.get(edge[1]);
                second.add(edge[0]);
                map.put(edge[1], second);
            }

            dfs(map, edges[0][0], new HashSet<>(), 0);
            answer = 0;

            dfs(map, farthest, new HashSet<>(), 0);

            return answer;
        }

        public void dfs(Map<Integer, List<Integer>> map, int key, Set<Integer> set, int len) {

            if(len > answer) {
                answer = len;
                farthest = key;
            }
            set.add(key);
            List<Integer> child;
            child = map.get(key);
            for(int i=0; i<child.size(); i++) {
                if(!set.contains(child.get(i))) {
                    dfs(map, child.get(i), set, len + 1);
                }
            }
        }
}

