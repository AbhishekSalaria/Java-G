package org.graph.java.BFS;

import java.util.*;

public class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {
            Map<Integer, List<Integer>> adjL = new HashMap<>();
            adjL.put(1, Arrays.asList(2,4,5));
            adjL.put(2, Arrays.asList(1,3));
            adjL.put(3, Arrays.asList(2,4,6));
            adjL.put(4, Arrays.asList(1,3,5));
            adjL.put(5, Arrays.asList(1,4,6));
            adjL.put(6, Arrays.asList(3,5,7));
            adjL.put(7, Arrays.asList(6));

//            Map<Integer, List<Integer>> adjL = new HashMap<>();
//            adjL.put(1, Arrays.asList(2, 3));
//            adjL.put(2, Arrays.asList(1, 4));
//            adjL.put(3, Arrays.asList(1, 5));
//            adjL.put(4, Arrays.asList(2));
//            adjL.put(5, Arrays.asList(3));

            boolean []visited = new boolean[adjL.size() + 1];
            for(int node: adjL.keySet()) {
                if(!visited[node]) {
                    boolean cycle = bfs(adjL, visited, node);
                    if(cycle) {
                        System.out.println("Graph contains cycle.");
                        return;
                    }
                }
            }
            System.out.println("Graph Doesn't contain Cycle.");


    }

    private static boolean bfs(Map<Integer, List<Integer>> adjL, boolean[] visited, int node) {
        visited[node] = true;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(node, -1));

        while (!queue.isEmpty()) {
            List<Integer> pair = queue.peek();
            queue.remove();

            for (Integer child : adjL.get(pair.get(0))) {
                if(!visited[child]) {
                    visited[child] = true;
                    queue.add(Arrays.asList(child,pair.get(0)));
                } else if (visited[child] && pair.get(1) != child) {
                    return true;
                }
            }
        }
        return false;
    }
}
