package org.graph.java.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottenOranges {
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
                if(ocean[i][j] == 2) {
                    queue.add(Arrays.asList(i, j, 0));
                    visited[i][j] = 2;
                }
            }
        }
        
        int time = bfs(visited,ocean,queue);
        if(time == -1) {
            System.out.println("All the oranges can't be rottened.");
        }
        else {
            System.out.println("Time required to Rotten all the oranges: " + time);
        }
    }

    private static int bfs(int[][] visited, int[][] ocean, Queue<List<Integer>> queue) {
        int [][]ops =  { {-1,0,+1,0},
                         {0,-1,0,+1}};
        int maxVal = 0;
        while (!queue.isEmpty()) {
            List<Integer> currentVals = queue.peek();
            queue.remove();
            for (int i = 0; i < ops[0].length; i++) {
                int nextI = currentVals.get(0) + ops[0][i];
                int nextJ = currentVals.get(1) + ops[1][i];
                int nextCount = currentVals.get(2) + 1;
                if(nextI >=0 && nextI < ocean.length && nextJ >= 0 && nextJ < ocean[0].length
                && visited[nextI][nextJ] == 0 && ocean[nextI][nextJ] == 1) {
                    maxVal = nextCount;
                    queue.add(Arrays.asList(nextI,nextJ, nextCount));
                    visited[nextI][nextJ] = 2;
                    ocean[nextI][nextJ] = 2;
                }
            }
        }
        for(int x = 0; x < ocean.length; x++) {
            for(int y = 0; y < ocean[0].length; y++) {
                if(ocean[x][y] == 1) {
                    return -1;
                }
            }
        }
        return maxVal;
    }
}
