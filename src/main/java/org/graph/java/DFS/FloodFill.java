package org.graph.java.DFS;

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
        int i = 0, j = 4, newColor = 3;
        dfs(visited, ocean, i, j, ocean[i][j], newColor);

        for (int x = 0 ; x < visited.length; x++) {
            for (int y = 0; y < visited[0].length; y++) {
                System.out.print(ocean[x][y] + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int[][] visited, int[][] ocean, int i, int j, int key, int newColor) {
        int [][]ops =  { {-1,0,+1,0},
                {0,-1,0,+1}};
        visited[i][j] = 1;
        ocean[i][j] = newColor;

            for (int k = 0; k < ops[0].length; k++) {
                int nextI = i + ops[0][k];
                int nextJ = j + ops[1][k];
                if (nextI >= 0 && nextI < ocean.length && nextJ >= 0 && nextJ < ocean[0].length
                        && visited[nextI][nextJ] == 0 && ocean[nextI][nextJ] == key) {
                    dfs(visited, ocean, nextI, nextJ, key, newColor);
            }
        }
    }
}
