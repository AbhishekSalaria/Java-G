package org.graph.java.DFS;

import java.util.*;

public class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> adjL = new HashMap<>();
        adjL.put(1, Arrays.asList(2,4,5));
        adjL.put(2, Arrays.asList(1, 3));
        adjL.put(3, Arrays.asList(2, 4, 6));
        adjL.put(4, Arrays.asList(1, 3, 5));
        adjL.put(5, Arrays.asList(1, 4, 6));
        adjL.put(6, Arrays.asList(3, 5, 7));
        adjL.put(7, Arrays.asList(6));

//        Map<Integer, List<Integer>> adjL = new HashMap<>();
//        adjL.put(1, Arrays.asList(2, 3));
//        adjL.put(2, Arrays.asList(1, 4));
//        adjL.put(3, Arrays.asList(1, 5));
//        adjL.put(4, Arrays.asList(2));
//        adjL.put(5, Arrays.asList(3));

        boolean []visited = new boolean[adjL.size() + 1];
        for(int node: adjL.keySet()) {
            if(!visited[node]) {
                int parent = -1;
                boolean cycle = dfs(adjL, visited, node, parent);
                if(cycle) {
                    System.out.println("Graph contains cycle.");
                    return;
                }
            }
        }
        System.out.println("Graph Doesn't contain Cycle.");


    }

    private static boolean dfs(Map<Integer, List<Integer>> adjL, boolean[] visited, int node, int parent) {
        visited[node] = true;
        for (Integer child : adjL.get(node)) {
            if (!visited[child]) {
                dfs(adjL, visited,child, node);
            } else if (visited[child] && parent != child) {
                return true;
            }
        }
        return false;
    }
}
