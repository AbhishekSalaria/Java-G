package org.graph.java.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FloodFill {

    public static void main(String[] args) {
        int ocean[][] = {{0,1,1,0,1,1,0},
                         {1,0,0,1,1,0,2},
                         {1,1,1,1,1,1,1},
                         {0,2,2,2,2,0,0},
                         {1,0,0,0,2,0,0},
                         {1,2,2,2,2,0,0},
                         {1,1,1,1,1,1,1}};
        int visited[][] = new int[ocean.length][ocean[0].length];
        int i = 3, j = 1, newColor = 3;
        bfs(visited, ocean, i, j, ocean[i][j], newColor);

        for (int x = 0 ; x < visited.length; x++) {
            for (int y = 0; y < visited[0].length; y++) {
                System.out.print(ocean[x][y] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int[][] visited, int[][] ocean, int i, int j, int key, int newColor) {
        Queue<List<Integer>> pair = new LinkedList<>();
        int [][]ops =  { {-1,0,+1,0},
                         {0,-1,0,+1}};
        visited[i][j] = 1;
        pair.add(Arrays.asList(i,j));
        ocean[i][j] = newColor;

        while (!pair.isEmpty()) {
            List<Integer> ijPair = pair.peek();
            pair.remove();
            for (int k = 0; k < ops[0].length; k++) {
                int nextI = ijPair.get(0) + ops[0][k];
                int nextJ = ijPair.get(1) + ops[1][k];
                if (nextI >= 0 && nextI < ocean.length && nextJ >= 0 && nextJ < ocean[0].length
                        && visited[nextI][nextJ] == 0 && ocean[nextI][nextJ] == key) {
                    visited[nextI][nextJ] = 1;
                    ocean[nextI][nextJ] = newColor;
                    pair.add(Arrays.asList(nextI, nextJ));
                }
            }
        }
    }
}
