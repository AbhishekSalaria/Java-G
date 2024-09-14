package org.graph.java.DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DistanceOfNearestCellHaving1 {
    public static void main(String[] args) {
        int ocean[][] = {{0,1,1,0,0,1,0},
                         {1,0,0,1,1,0,0},
                         {1,0,0,0,0,1,1},
                         {0,0,1,1,0,0,0},
                         {1,0,0,0,0,0,0},
                         {1,0,0,0,0,0,0},
                         {0,0,1,1,0,1,1}};
        Queue<List<Integer>> queue = new LinkedList<>();
        boolean visited[][] = new boolean[ocean.length][ocean[0].length];
        int distance[][] = new int[ocean.length][ocean[0].length];
        for(int i = 0; i < ocean.length; i++) {
            for (int j = 0; j < ocean[0].length; j++) {
                if(ocean[i][j] == 1) {
                    queue.add(Arrays.asList(i,j,0));
                    visited[i][j] = true;
                }
            }
        }
        for(List<Integer> elem: queue) {
            dfs(ocean, elem, visited, distance);
        }
        for (int x = 0; x < ocean.length; x++) {
            for (int y = 0; y < ocean[0].length; y++) {
                System.out.print(distance[x][y] + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int[][] ocean, List<Integer> pair, boolean[][] visited, int[][] distance) {
            int [][]ops =  { {-1,0,+1,0},
                            {0,-1,0,+1}};
            for(int i = 0; i < ops[0].length; i++) {
                int nextI = pair.get(0) + ops[0][i];
                int nextJ = pair.get(1) + ops[1][i];
                if(nextI >= 0 && nextI < ocean.length && nextJ >= 0 && nextJ < ocean[0].length
                        && !visited[nextI][nextJ] && ocean[nextI][nextJ] == 0) {
                    visited[nextI][nextJ] = true;
                    distance[nextI][nextJ] = pair.get(2) + 1;
                    dfs(ocean, Arrays.asList(nextI,nextJ,distance[nextI][nextJ]), visited, distance);
                }
        }
    }
}
