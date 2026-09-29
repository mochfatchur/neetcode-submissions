class Solution {
    // plans: do multi source bfs by its sources (the treasures chess)
    // if the cell that is not a water already has a value, compare the minumum distance
    
    record Coordinate(int row, int col) {};
    private static final int INF = 2147483647;
    private static final int[][] DIRS = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public void islandsAndTreasure(int[][] grid) {
        Queue <Coordinate> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;

        // find all treasure chess
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    queue.offer(new Coordinate(r, c));
                }
            }
        }

        // do all bfs from the sources
        while (!queue.isEmpty()) {
            Coordinate curSource = queue.poll();
            int count = 0;
            for (int[] dir : DIRS) {
                int dirR = curSource.row() + dir[0];
                int dirC = curSource.col() + dir[1];

                if (
                    dirR >= 0 && dirR < rows &&
                    dirC >= 0 && dirC < cols &&
                    grid[dirR][dirC] == INF
                ) {
                    grid[dirR][dirC] = grid[curSource.row()][curSource.col()] + 1;
                    queue.offer(new Coordinate(dirR, dirC));
                }
            }
        }
    }
}
