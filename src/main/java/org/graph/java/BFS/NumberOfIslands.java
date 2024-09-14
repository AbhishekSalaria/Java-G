package org.graph.java.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        int ocean[][] = {{0,1,1,0,1,1,0},
                         {1,0,0,1,1,0,0},
                         {1,0,0,0,0,1,1},
                         {0,1,1,1,0,0,0},
                         {1,0,0,0,0,0,0},
                         {1,0,0,0,0,0,0},
                         {1,1,1,1,1,1,1}};
        int visited[][] = new int[ocean.length][ocean[0].length];
        int count = 0;
        for(int i = 0; i < ocean.length; i++) {
            for (int j = 0; j < ocean[0].length; j++) {
                if(visited[i][j] == 0 && ocean[i][j] == 1) {
                    bfs(visited, ocean, i, j);
                    count++;
                }
            }
        }
        System.out.println("Number of Islands: " + count);
    }

    private static void bfs(int[][] visited, int[][] ocean, int i, int j) {
        visited[i][j] = 1;
        int [][]ops =  { {-1,0,+1,0},
                         {0,-1,0,+1}};
        Queue<List<Integer>> indexPair = new LinkedList<>();
        indexPair.add(Arrays.asList(i,j));

        while (!indexPair.isEmpty()) {
            List<Integer> pair = indexPair.peek();
            System.out.println(indexPair);
            indexPair.remove();
            for(int k = 0; k < ops[0].length; k++) {
                int nextI = pair.get(0) + ops[0][k];
                int nextJ = pair.get(1) + ops[1][k];
                if ((nextI >= 0 && nextI < ocean.length) &&
                        (nextJ >= 0 && nextJ < ocean[0].length) && visited[nextI][nextJ] == 0 && ocean[nextI][nextJ] == 1) {
                    visited[nextI][nextJ] = 1;
                    indexPair.add(Arrays.asList(nextI,nextJ));
                }
            }
        }
    }
}
