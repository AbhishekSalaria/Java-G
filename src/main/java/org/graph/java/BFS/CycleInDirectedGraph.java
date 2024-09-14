package org.graph.java.BFS;

import java.util.*;

public class CycleInDirectedGraph {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> adjL = new HashMap<>();
        adjL.put(1, Arrays.asList(2));
        adjL.put(2, Arrays.asList(3));
        adjL.put(3, Arrays.asList(4, 5));
        adjL.put(4, Arrays.asList(3, 5));
        adjL.put(5, Arrays.asList());

        int[] indegree = new int[adjL.size() + 1];

        for (int i = 1; i < adjL.size(); i++) {
            for (Integer cK : adjL.get(i)) {
                indegree[cK]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < adjL.size(); i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Integer elem = queue.peek();
            queue.remove();
            count++;

            for (Integer elmt : adjL.get(elem)) {
                indegree[elmt]--;
                if (indegree[elmt] == 0) {
                    queue.add(elmt);
                }
            }
        }

        if (count == adjL.size()) {
            System.out.println("Graph Doesn't contain cycle.");
        } else {
            System.out.println("Graph contains cycle.");
        }
    }
}
