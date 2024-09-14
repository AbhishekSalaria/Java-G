package org.graph.java.ShortestPath;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        Map<Integer, List<List<Integer>>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(Arrays.asList(1,4), Arrays.asList(2, 4)));
        graph.put(1, Arrays.asList(Arrays.asList(0,4), Arrays.asList(2, 2)));
        graph.put(2, Arrays.asList(Arrays.asList(0,4), Arrays.asList(1, 2), Arrays.asList(3, 3),
                Arrays.asList(5, 6), Arrays.asList(4, 1)));
        graph.put(3, Arrays.asList(Arrays.asList(2,3), Arrays.asList(5, 2)));
        graph.put(4, Arrays.asList(Arrays.asList(2,1), Arrays.asList(5, 3)));
        graph.put(5, Arrays.asList(Arrays.asList(3,2), Arrays.asList(2, 6), Arrays.asList(4, 3)));

        int[] shortestDistance = new int[graph.size()];

        for(int i = 0; i < shortestDistance.length; i++) {
            shortestDistance[i] = Integer.MAX_VALUE;
        }

        int startIndex = 0;
        shortestDistance[startIndex] = 0;

        PriorityQueue<List<Integer>> pQueue = new PriorityQueue<>(Comparator.comparingInt(list -> list.get(0)));
        pQueue.add(Arrays.asList(startIndex, 0));
        findShortestDistance(shortestDistance, graph, pQueue);

        for (int j = 0; j < shortestDistance.length; j++) {
            System.out.print(shortestDistance[j] + " ");
        }
    }

    private static void findShortestDistance(int[] shortestDistance, Map<Integer, List<List<Integer>>> graph, PriorityQueue<List<Integer>> pQueue) {

        while (!pQueue.isEmpty()) {
            List<Integer> currentNode = pQueue.peek();
            pQueue.remove();
            
            for (List<Integer> lst: graph.get(currentNode.get(1))) {
                if(shortestDistance[lst.get(0)] > currentNode.get(0) + lst.get(1)) {
                    shortestDistance[lst.get(0)] = currentNode.get(0) + lst.get(1);
                    pQueue.add(Arrays.asList(currentNode.get(0) + lst.get(1), lst.get(0)));
                }
            }
        }
    }
}
