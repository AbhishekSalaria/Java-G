package org.graph.java.DFS;

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
                int initialColor = 1;
                boolean isBipartite = dfs(adjL, colors, node, initialColor);
                if(isBipartite) {
                    System.out.println("Graph is a bipartite graph.");
                    return;
                }
            }
        }
        System.out.println("Graph is not a bipartite graph.");
    }

    private static boolean dfs(Map<Integer, List<Integer>> adjL, int[] colors, int node, int color) {
        colors[node] = color;
        for (Integer connectedComponent : adjL.get(node)) {
            if (colors[connectedComponent] == 0 && color == 1) {
                dfs(adjL, colors, connectedComponent,2);
            } else if (colors[connectedComponent] == 0 && color == 2) {
                dfs(adjL, colors, connectedComponent,1);
            } else if (colors[connectedComponent] == color) {
                return false;
            }
        }
        return true;
    }
}