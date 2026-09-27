class Solution {

    record Coordinate(int row, int col) {}

    public int orangesRotting(int[][] grid) {
        int[][] dir = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
        };

        Queue<Coordinate> queueRotten = new LinkedList<>();
        int freshFruit = 0;
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 2) {
                    queueRotten.offer(new Coordinate(i,j));
                } else if (grid[i][j] == 1) {
                    freshFruit++;
                }
            }
        }

        int minutes = 0;

        while (!queueRotten.isEmpty() && freshFruit > 0) {
            int size = queueRotten.size();
            for (int s = 0; s < size; s++) {
                Coordinate curRot = queueRotten.poll();
                int row = curRot.row();
                int col = curRot.col();

                for (int[] d : dir) {
                    int cr = row + d[0];
                    int cc = col + d[1];
                    if (
                        cr >= 0 && cr < r &&
                        cc >= 0 && cc < c &&
                        grid[cr][cc] == 1
                    ) {
                        grid[cr][cc] = 2;
                        freshFruit -= 1;
                        queueRotten.offer(new Coordinate(cr, cc));
                    }
                }
            }
            minutes++;
        }

        return freshFruit > 0 ? -1 : minutes;
    }
}