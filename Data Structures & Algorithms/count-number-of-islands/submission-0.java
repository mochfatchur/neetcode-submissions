class Solution {
    // plans:
    // 1. iterate the all elements in grid
    // 2. do dfs for every cell if the cell(i,j) == 1
    // 3. the dfs :
    // 3.1. check if the cell(i,j) not out of bound and not water, else break/return;
    // 3.2. set cell(i,j) is visited
    // 3.3 do dfs to all four direction


    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        
        // initialize
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        // initialize
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        if (
            i < 0 || i >= rows ||
            j < 0 || j >= cols ||
            grid[i][j] == '0' || visited[i][j]
        ) {
            return;
        }

        visited[i][j] = true;

        // dfs to all four directions
        dfs(grid, i+1, j, visited); // down
        dfs(grid, i, j-1, visited); // left
        dfs(grid, i-1, j, visited); // up
        dfs(grid, i, j+1, visited); // right

    }
}
