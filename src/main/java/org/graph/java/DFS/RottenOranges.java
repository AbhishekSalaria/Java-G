package org.graph.java.DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottenOranges {
    public static int maxVal = 0;
    public static void main(String[] args) {
        int ocean[][] = {{0,1,2,0,1,1,0},
                         {0,0,1,1,1,0,0},
                         {0,0,0,1,1,1,1},
                         {0,1,1,1,0,0,0},
                         {1,1,0,0,2,1,0},
                         {1,0,0,0,0,0,0},
                         {1,1,1,1,1,1,1}};

//        int ocean[][] = {{0,1,2},
//                         {0,1,1},
//                         {2,1,1}};

        int visited[][] = new int[ocean.length][ocean[0].length];
        Queue<List<Integer>> queue = new LinkedList<>();
        for(int i = 0; i < ocean.length; i++) {
            for (int j = 0; j < ocean[0].length; j++) {
                if(ocean[i][j] == 2 && visited[i][j] == 0) {
                    dfs(visited, ocean, i, j, 0);
                }
            }
        }

        for (int x = 0; x < ocean.length; x++) {
            for (int y = 0; y < ocean[0].length; y++) {
                if(ocean[x][y] == 1) {
                    maxVal = -1;
                }
            }
        }
        if(maxVal == -1) {
            System.out.println("All the oranges can't be rottened.");
        }
        else {
            System.out.println("Time required to Rotten all the oranges: " + maxVal);
        }
    }

    private static void dfs(int[][] visited, int[][] ocean, int i, int j, int count) {
        int [][]ops =  { {-1,0,+1,0},
                         {0,-1,0,+1}};
        visited[i][j] = 2;

        if(count > maxVal) {
            maxVal = count;
        }

        for (int k = 0; k < ops[0].length; k++) {
                int nextI = i + ops[0][k];
                int nextJ = j + ops[1][k];
                int nextCount = count + 1;
                if(nextI >=0 && nextI < ocean.length && nextJ >= 0 && nextJ < ocean[0].length
                        && visited[nextI][nextJ] == 0 && ocean[nextI][nextJ] == 1) {
                    ocean[nextI][nextJ] = 2;
                    dfs(visited, ocean, nextI, nextJ, nextCount);
                }
            }
    }
}
