package recursion;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
    public static void main(String[] args) {
        var n = 4;
        var maze = new int[n][n];
        maze[0][0] = 1;
        maze[1][0] = 1;
        maze[1][1] = 1;
        maze[2][0] = 1;
        maze[2][1] = 1;
        maze[3][1] = 1;
        maze[3][2] = 1;
        maze[3][3] = 1;

        var ans = findPath(maze, n);
        System.out.println(ans);
    }

    private static List<String> findPath(int[][] maze, int n) {
        var visited = new int[n][n];
        var ans = new ArrayList<String>();
        int[] di = {1, 0 , 0 , -1};
        int[] dj = {0, -1 , 1 , 0};
        if (maze[0][0] == 1) {
            solve(0, 0, maze, n, visited, ans, "", di, dj);
        }
        return ans;
    }


    private static void solve(int i, int j, int[][] maze, int n, int[][] visited, ArrayList<String> ans, String move) {

        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }

        //lexicographical order 

        //down
        if (i + 1 < n && visited[i + 1][j] != 1 && maze[i + 1][j] == 1) {
            visited[i][j] = 1;
            solve(i + 1, j, maze, n, visited, ans, move + "D");
            visited[i][j] = 0;
        }

        //left
        if (j - 1 >= 0 && visited[i][j - 1] != 1 && maze[i][j - 1] == 1) {
            visited[i][j] = 1;
            solve(i, j - 1, maze, n, visited, ans, move + "L");
            visited[i][j] = 0;
        }

        //right
        if (j + 1 < n && visited[i][j + 1] != 1 && maze[i][j + 1] == 1) {
            visited[i][j] = 1;
            solve(i, j + 1, maze, n, visited, ans, move + "R");
            visited[i][j] = 0;
        }

        //up
        if (i - 1 >= 0 && visited[i - 1][j] != 1 && maze[i - 1][j] == 1) {
            visited[i][j] = 1;
            solve(i - 1, j, maze, n, visited, ans, move + "U");
            visited[i][j] = 0;
        }
    }    


    private static void solve(int i, int j, int[][] maze, int n, int[][] visited, ArrayList<String> ans, String move, int[] di, int[] dj) {

        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }

        //lexicographical order 
        // down, left, right, up

        String directions = "DLRU";

        for (int index = 0; index < di.length; index++) {
            var _i = i + di[index];
            var _j = j + dj[index];

            if (_i >= 0 && _j >= 0 && _i < n && _j < n && visited[_i][_j] != 1 && maze[_i][_j] == 1) {
                visited[i][j] = 1;
                solve(_i, _j, maze, n, visited, ans, move + directions.charAt(index), di, dj);
                visited[i][j] = 0;
            }
        }
    }    
}
