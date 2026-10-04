class Solution {
    // plans:
    // 1. list all rotten fruits in queueRooten
    // 2. get current size queue of rotten fruit, for every rotten fruit:
    // 2.1. set neighbord fruit as rotten and put to queueRooten
    // 3. count minutes everytime the current queue of rotten fruit is empty
    // 4. check the queue rooten size for another session, if still exist rotten fruits and freshFruit > 0 then do the same things from step 2

    public record Coordinate(int x, int y) {}
    public record GridState(Queue<Coordinate> queueRotten, int freshCount) {}

    public int[][] DIRS = {
        {-1, 0},
        {0, 1},
        {1, 0},
        {0, -1}
    };

    public GridState getGridState(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int freshFruit = 0;
        Queue<Coordinate> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Coordinate(i, j));
                } else if (grid[i][j] == 1) {
                    freshFruit++;
                }
            }
        }
        return new GridState(q, freshFruit);
    }

    public int orangesRotting(int[][] grid) {
        // get grid state
        GridState gridState = getGridState(grid);
        // Queue of Rotten Fruits
        Queue<Coordinate> qRottenFruits = gridState.queueRotten();
        // freshFruit Count
        int freshFruit = gridState.freshCount();
        // grid info
        int rows = grid.length;
        int cols = grid[0].length;
        // time session per minutes
        int minutes = 0;
        while (
            !qRottenFruits.isEmpty() &&
            freshFruit > 0
        ) {
            // get current queue rotten fruits
            int queueSize = qRottenFruits.size();
            // iterate all element queue rotten
            for (int i = 0; i < queueSize; i++) {
                Coordinate curRottenFruit = qRottenFruits.poll();
                int posRottenRow = curRottenFruit.x();
                int posRottenCol = curRottenFruit.y();
                // iterate for every DIRS
                for (int[] dir : DIRS) {
                    int neighFruitRow = posRottenRow + dir[0];
                    int neighFruitCol = posRottenCol + dir[1];
                    if (
                        (neighFruitRow >= 0) && (neighFruitRow < rows) &&
                        (neighFruitCol >= 0) && (neighFruitCol < cols) &&
                        (grid[neighFruitRow][neighFruitCol] == 1)
                    ) {
                        // set as rotten
                        grid[neighFruitRow][neighFruitCol] = 2;
                        // add to queue rotten fruits for the next session minutes
                        qRottenFruits.offer(new Coordinate(neighFruitRow, neighFruitCol));
                        // decrease freshfruit count
                        freshFruit--;
                    }
                }
            }
            // add minute for move to the next session
            minutes++;
        }
        return freshFruit > 0 ? -1 : minutes;
    }
}
