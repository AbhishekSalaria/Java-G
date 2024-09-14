package org.graph.java.BFS;

import java.util.*;

public class BFS {

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
                bfs(result, adjL, visited, node);
            }
        }

        System.out.println(result);
    }

    private static void bfs(List<Integer> result, Map<Integer, List<Integer>> adjL, boolean[] visited, int key) {
        visited[key] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(key);

        while (!queue.isEmpty()) {
            Integer element = queue.peek();
            result.add(element);
            queue.remove();

            for (Integer elem: adjL.get(element)) {
                if(!visited[elem]) {
                    visited[elem] = true;
                    queue.add(elem);
                }
            }
        }
    }
}
