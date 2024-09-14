package org.graph.java.BFS;

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

        int[] indegree = new int[adjL.size()];

        for (int i = 0; i < adjL.size(); i++) {
            for(Integer cK: adjL.get(i)) {
                indegree[cK]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < adjL.size(); i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] topoSort = new int[adjL.size()];
        int start = 0;
        while (!queue.isEmpty()) {
            Integer elem = queue.peek();
            queue.remove();
            topoSort[start++] = elem;

            for (Integer elmt: adjL.get(elem)) {
                indegree[elmt]--;
                if (indegree[elmt] == 0) {
                    queue.add(elmt);
                }
            }
        }
        for (int x = 0; x < topoSort.length; x++) {
            System.out.print(topoSort[x] + " ");
        }
    }
}
