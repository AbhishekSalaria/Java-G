package org.graph.java.DFS;

import java.util.*;

public class NumberOfProvinces {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> adjL = new HashMap<>();
        adjL.put(1, Arrays.asList(2));
        adjL.put(2, Arrays.asList(1,3));
        adjL.put(3, Arrays.asList(2));
        adjL.put(4, Arrays.asList(5));
        adjL.put(5, Arrays.asList(4,6));
        adjL.put(6, Arrays.asList(5));
        adjL.put(7, Arrays.asList(8));
        adjL.put(8, Arrays.asList(7));

        boolean []visited = new boolean[adjL.size() + 1];
        int count = 0;
        for(int node: adjL.keySet()) {
            if(!visited[node]) {
                dfs(adjL, visited, node);
                count++;
            }
        }

        System.out.println("Number of Provinces (DFS): " + count);
    }

    private static void dfs(Map<Integer, List<Integer>> adjL, boolean[] visited, int node) {
        visited[node] = true;

        for(Integer elem: adjL.get(node)) {
            if(!visited[elem]) {
                dfs(adjL, visited, elem);
            }
        }
    }
}
