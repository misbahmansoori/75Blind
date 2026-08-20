import java.util.*;

class Solution {

    int m, n;
    int[][] heights;

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        this.heights = heights;
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific: top row + left column
        for (int c = 0; c < n; c++) {
            dfs(0, c, pacific);
        }

        for (int r = 0; r < m; r++) {
            dfs(r, 0, pacific);
        }

        // Atlantic: bottom row + right column
        for (int c = 0; c < n; c++) {
            dfs(m - 1, c, atlantic);
        }

        for (int r = 0; r < m; r++) {
            dfs(r, n - 1, atlantic);
        }

        // Find cells reachable from both oceans
        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, boolean[][] ocean) {

        // Already visited
        if (ocean[r][c]) {
            return;
        }

        ocean[r][c] = true;

        for (int i = 0; i < 4; i++) {

            int nr = r + dr[i];
            int nc = c + dc[i];

            // Outside grid
            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                continue;
            }

            // Reverse flow:
            // Move only to a cell with height >= current cell
            if (heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, ocean);
            }
        }
    }
}