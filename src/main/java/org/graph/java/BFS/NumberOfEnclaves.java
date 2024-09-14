package org.graph.java.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        int arr[][] =   {{0,0,0,1,1},
                         {0,0,1,1,0},
                         {0,1,0,0,0},
                         {0,1,1,0,0},
                         {0,0,0,1,1}};
        Queue<List<Integer>> pair = new LinkedList<>();
        boolean [][]visited = new boolean[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i][0] == 1) {
                pair.add(Arrays.asList(i,0));
                visited[i][0] = true;
            }
            if(arr[i][arr[0].length - 1] == 1) {
                pair.add(Arrays.asList(i,arr[0].length - 1));
                visited[i][arr[0].length - 1] = true;
            }
        }
        for(int j = 1; j < arr[0].length - 1; j++) {
            if(arr[0][j] == 1) {
                pair.add(Arrays.asList(0,j));
                visited[0][j] = true;
            }
            if(arr[arr.length - 1][j] == 1) {
                pair.add(Arrays.asList(arr.length - 1,j));
                visited[arr.length - 1][j] = true;
            }
        }
        bfs(pair, arr, visited);

        for(int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[0].length; y++) {
                if(arr[x][y] == 1 && !visited[x][y]) {
                    arr[x][y] = 2;
                }
                System.out.print(arr[x][y] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(Queue<List<Integer>> pair, int[][] arr, boolean[][] visited) {
        while (!pair.isEmpty()) {
            List<Integer> currentPair = pair.peek();
            pair.remove();

            int [][]ops =  {{-1,0,+1,0},
                            {0,-1,0,+1}};

            for(int i = 0; i < ops[0].length; i++) {
                int nextI = currentPair.get(0) + ops[0][i];
                int nextJ = currentPair.get(1) + ops[1][i];

                if(nextI >= 0 && nextI < arr.length && nextJ >= 0 && nextJ < arr[0].length
                  && !visited[nextI][nextJ] && arr[nextI][nextJ] == 1) {
                    visited[nextI][nextJ] = true;
                    pair.add(Arrays.asList(nextI,nextJ));
                }
            }
        }
    }
}
