package org.graph.java.DFS;

import java.util.*;

public class NumberOfDistinctIslands {
    public static void main(String[] args) {
        int arr[][] =   {{0,0,1,0,1},
                         {0,0,1,1,0},
                         {0,1,0,0,0},
                         {0,1,1,0,0},
                         {1,0,0,1,1}};

        boolean [][]visited = new boolean[arr.length][arr[0].length];
        HashSet<List<String>> hashSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    List<String> lst = new ArrayList<>();
                    dfs(i, j, visited, arr, lst, i, j);
                    hashSet.add(lst);
                }
            }
        }
        System.out.println(hashSet);
        System.out.println("Number of Distinct Islands: " + hashSet.size());
    }

    private static void dfs(int i, int j, boolean[][] visited, int[][] arr, List<String> lst, int i1, int j1) {
        visited[i][j] = true;
        lst.add(Arrays.asList(i - i1, j - j1).toString());
        int[][] ops = {{-1, 0, +1, 0},
                       {0, -1, 0, +1}};

        for (int k = 0; k < ops[0].length; k++) {
            int nextI = i + ops[0][k];
            int nextJ = j + ops[1][k];

            if (nextI >= 0 && nextI < arr.length && nextJ >= 0 && nextJ < arr[0].length
                    && !visited[nextI][nextJ] && arr[nextI][nextJ] == 1) {
                dfs(nextI, nextJ, visited, arr, lst, i1, j1);
            }
        }
    }
}