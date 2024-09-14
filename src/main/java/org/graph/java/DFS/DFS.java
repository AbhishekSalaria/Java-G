package org.graph.java.DFS;
import java.util.*;

public class DFS {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> adjL = new HashMap<>();
        adjL.put(1, Arrays.asList(2,4,5));
        adjL.put(2, Arrays.asList(1,3));
        adjL.put(3, Arrays.asList(2,4,6));
        adjL.put(4, Arrays.asList(1,3,5));
        adjL.put(5, Arrays.asList(1,4,6));
        adjL.put(6, Arrays.asList(3,5,7));
        adjL.put(7, Arrays.asList(6));

        List<Integer> result = new ArrayList<>();
        boolean []visited = new boolean[adjL.size() + 1];
        for(int node: adjL.keySet()) {
            if(!visited[node]) {
                dfs(result, adjL, visited, node);
            }
        }

        System.out.println(result);
    }

    private static void dfs(List<Integer> result, Map<Integer, List<Integer>> adjL, boolean[] visited, int key) {
        visited[key] = true;
        result.add(key);

        for(Integer elem: adjL.get(key)) {
            if(!visited[key]) {
                dfs(result, adjL, visited, elem);
            }
        }
    }
}
