class Solution {
    
    private final int[][] directions = 
    {
        {-1, 0}, 
        {0, 1},
        {1, 0},
        {0, -1}
    };

    public int islandPerimeter(int[][] grid) {
        // plans:
        // 1. iterate all nodes in O(rows × cols) because its adjacency matrix
        // 2. check for every potential neighbors in 4 directions (left, up, right, down)
        // 3. if neighbor of the node is out of bond or water then count it as 1 point perimeter

        // implementations:
        int perimeter = 0;
        int gridRowLength = grid.length;
        int gridColLength = grid[0].length;
        for (int i = 0; i < gridRowLength; i++) {
            for (int j = 0; j < gridColLength; j++) {
                if (grid[i][j] == 1) {
                    for (int[] dir : directions) {
                        int dr = dir[0] + i;
                        int dc = dir[1] + j;
                        if (
                            dr < 0 || dr >= gridRowLength ||
                            dc < 0 || dc >= gridColLength ||
                            grid[dr][dc] == 0
                        ) {
                            perimeter+=1;
                        }
                    }
                }
            }
        }
        return perimeter;
    }
}
