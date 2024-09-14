package org.graph.java.DFS;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> adjL = new HashMap<>();
        adjL.put(0, Arrays.asList());
        adjL.put(1, Arrays.asList());
        adjL.put(2, Arrays.asList(3));
        adjL.put(3, Arrays.asList(1));
        adjL.put(4, Arrays.asList(0,1));
        adjL.put(5, Arrays.asList(0,2));

        boolean []visited = new boolean[adjL.size()];
        Stack<Integer> result = new Stack<>();
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                dfs(adjL, visited, result, i);
            }
        }
        List<Integer> topologicalSort = new ArrayList<>();
        while(!result.isEmpty()) {
            topologicalSort.add(result.peek());
            result.pop();
        }
        System.out.println("Topological Sort: " + topologicalSort);
    }

    private static void dfs(Map<Integer, List<Integer>> adjL, boolean[] visited, Stack<Integer> result, int key) {
        visited[key] = true;
        for (Integer currentKey : adjL.get(key)) {
            if (!visited[currentKey]) {
                dfs(adjL, visited, result, currentKey);
            }
        }
        result.push(key);
    }
}
