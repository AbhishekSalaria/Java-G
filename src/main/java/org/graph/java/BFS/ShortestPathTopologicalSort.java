package org.graph.java.BFS;

import java.util.*;

public class ShortestPathTopologicalSort {
    public static void main(String[] args) {
        Map<Integer, List<List<Integer>>> adjL = new HashMap<>();
        adjL.put(6, Arrays.asList(Arrays.asList(4,2), Arrays.asList(5,3)));
        adjL.put(4, Arrays.asList(Arrays.asList(0,3), Arrays.asList(2,1)));
        adjL.put(5, Arrays.asList(Arrays.asList(4,1)));
        adjL.put(0, Arrays.asList(Arrays.asList(1,2)));
        adjL.put(2, Arrays.asList(Arrays.asList(3,3)));
        adjL.put(1, Arrays.asList(Arrays.asList(3,1)));
        adjL.put(3, Arrays.asList());

        int[] indegree = new int[adjL.size()];

        for (int i = 0; i < adjL.size(); i++) {
            for (List<Integer> arr: adjL.get(i)) {
                indegree[arr.get(0)]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> toposort = new LinkedList<>();

        for (int j = 0; j < indegree.length; j++) {
            if (indegree[j] == 0) {
                queue.add(j);
            }
        }

        while (!queue.isEmpty()) {
            Integer val =  queue.peek();
            queue.remove();
            toposort.add(val);

            for (List<Integer> pair: adjL.get(val)) {
                indegree[pair.get(0)]--;
                if (indegree[pair.get(0)] == 0) {
                    queue.add(pair.get(0));
                }
            }
        }

        int[] shortestDistanceArray = new int[indegree.length];

        for (int k = 0; k < indegree.length; k++) {
            shortestDistanceArray[k] = Integer.MAX_VALUE;
        }

        int startNode = 6;
        shortestDistanceArray[startNode] = 0;

        while (!toposort.isEmpty()) {
            int val = toposort.peek();
            toposort.remove();

            for (List<Integer> vl: adjL.get(val)) {
                if (shortestDistanceArray[val] + vl.get(1) < shortestDistanceArray[vl.get(0)]) {
                    shortestDistanceArray[vl.get(0)] = shortestDistanceArray[val] + vl.get(1);
                }
            }

        }

        for (int v: shortestDistanceArray) {
            System.out.print(v + " ");
        }
    }
}
