package org.graph.java.BFS;

import java.util.*;

public class BipartiteGraph {
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
//        adjL.put(3, Arrays.asList(1, 4));
//        adjL.put(4, Arrays.asList(2, 3));

        int []colors = new int[adjL.size() + 1];
        for(int node: adjL.keySet()) {
            if(colors[node] == 0) {
                boolean isBipartite = bfs(adjL, colors, node);
                if(isBipartite) {
                    System.out.println("Graph is a bipartite graph.");
                    return;
                }
            }
        }
        System.out.println("Graph is not a bipartite graph.");
    }

    private static boolean bfs(Map<Integer, List<Integer>> adjL, int[] colors, int node) {
        colors[node] = 1;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(node, colors[node]));

        while (!queue.isEmpty()) {
            List<Integer> pair = queue.peek();
            queue.remove();
            for (Integer connectedComponent: adjL.get(pair.get(0))) {
                if(colors[connectedComponent] == 0 && pair.get(1) == 1) {
                    colors[connectedComponent] = 2;
                    queue.add(Arrays.asList(connectedComponent, colors[connectedComponent]));
                }
                else if(colors[connectedComponent] == 0 && pair.get(1) == 2) {
                    colors[connectedComponent] = 1;
                    queue.add(Arrays.asList(connectedComponent, colors[connectedComponent]));
                }
                else if(colors[connectedComponent] == pair.get(1)){
                    return false;
                }
            }
        }
        return true;
    }
}
