/*Q8
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/


import java.util.LinkedList;
import java.util.Queue;

public class Island_8 {

    int [][] direc = {{0, 1},{0, -1},{1, 0},{-1, 0}};
    public int numIslands(char[][] grid) {

        //corner case
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int r = grid.length;
        int c = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int res = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == '1'){
                    res++;
                    grid[i][j] = '0';
                    queue.offer(new int[]{i, j});

                    bfs(grid, r, c, queue);
                }
            }
        }

        return res;
    }

    private void bfs(char[][]grid, int r, int c, Queue<int[]> queue){

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[]d: direc){
                int nx = cur[0] + d[0];
                int ny = cur[1] + d[1];
                if(nx < 0 || nx >= r || ny < 0 || ny >= c|| grid[nx][ny] != '1'){
                    continue;
                }

                grid[nx][ny] = '0';
                queue.offer(new int[]{nx, ny});
            }
        }

    }

}
