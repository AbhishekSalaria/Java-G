package org.graph.java.DFS;

import java.util.*;

public class FindEventualSafeStates {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> adjL = new HashMap<>();
        adjL.put(1, Arrays.asList(2));
        adjL.put(2, Arrays.asList(3));
        adjL.put(3, Arrays.asList(4, 7));
        adjL.put(4, Arrays.asList(5));
        adjL.put(5, Arrays.asList(6));
        adjL.put(6, Arrays.asList());
        adjL.put(7, Arrays.asList(5));
        adjL.put(8, Arrays.asList(9));
        adjL.put(9, Arrays.asList(10));
        adjL.put(10, Arrays.asList(8));

        boolean visited[] = new boolean[adjL.size() + 1];
        boolean pathVisited[] = new boolean[adjL.size() + 1];
        boolean check[] = new boolean[adjL.size() + 1];
        List<Integer> safeStates = new ArrayList<>();
        for (Integer key : adjL.keySet()) {
            if (!visited[key]) {
                dfs(key, visited, pathVisited, adjL, check);
            }
        }
        for(int i =1; i < check.length; i++) {
            if(check[i] == true) {
                safeStates.add(i);
            }
        }
        System.out.println("Safe states: " + safeStates);
    }

    private static boolean dfs(Integer key, boolean[] visited, boolean[] pathVisited, Map<Integer, List<Integer>> adjL, boolean[] check) {
        visited[key] = true;
        pathVisited[key] = true;

        for (Integer currentKey : adjL.get(key)) {
            if (!visited[currentKey]) {
                if (dfs(currentKey, visited, pathVisited, adjL, check)) {
                    check[currentKey] = false;
                    return true;
                }
            } else if (pathVisited[currentKey]) {
                check[currentKey] = false;
                return true;
            }
        }
        check[key] = true;
        pathVisited[key] = false;
        return false;
    }
}