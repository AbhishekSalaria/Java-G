package org.graph.java.DFS;

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
                    dfs(visited, ocean, i, j);
                    count++;
                }
            }
        }
        System.out.println("Number of Islands: " + count);
    }

    private static void dfs(int[][] visited, int[][] ocean, int i, int j) {
        visited[i][j] = 1;
        int [][]ops =  { {-1,0,+1,0},
                         {0,-1,0,+1} };

        for(int k = 0; k < ops[0].length; k++) {
            int nextI = i + ops[0][k];
            int nextJ = j + ops[1][k];
            if ((nextI >= 0 && nextI < ocean.length) &&
                    (nextJ >= 0 && nextJ < ocean[0].length) && visited[nextI][nextJ] == 0 && ocean[nextI][nextJ] == 1) {
                dfs(visited, ocean, nextI, nextJ);
            }
        }
    }
}
