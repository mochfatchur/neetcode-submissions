class Solution {
    // plans:
    // 1. iterate all grid
    // 2. for every cell(i,j) = 1
    // 3. set visited for cell(i,j)
    // 4. dfsGridLength for 4 directions
    // 5. compare Max
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(
                        max, dfsGridLength(
                                i,j, grid, visited
                            )
                    );
                }
            }
        }

        return max;
    }

    private int dfsGridLength(int i, int j, int[][] grid, boolean[][] visited) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        if (
            i < 0 || i >= rows ||
            j < 0 || j >= cols ||
            grid[i][j] == 0 || visited[i][j]
        ) {
            return 0;
        }
        // sum current cell
        count++;
        visited[i][j] = true;
        // sum four directions
        // up
        count += dfsGridLength(i-1, j, grid, visited);
        // down
        count += dfsGridLength(i+1, j, grid, visited);
        // left
        count += dfsGridLength(i, j-1, grid, visited);
        // right
        count += dfsGridLength(i, j+1, grid, visited);
        return count;
    }
}
