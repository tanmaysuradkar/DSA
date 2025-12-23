public class graphQ5Island {
    public static void isLand(int grid[][], boolean vis[][], int ans, int n, int m, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || grid[i][j] == 0) {
            return;
        }
        vis[i][j] = true;
        isLand(grid, vis, ans, n, m, i + 1, j);
        isLand(grid, vis, ans, n, m, i - 1, j);
        isLand(grid, vis, ans, n, m, i, j + 1);
        isLand(grid, vis, ans, n, m, i, j - 1);
    }

    public static void main(String args[]) {
        int grid[][] = {
                { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 1, 0, 0 },
                { 0, 0, 0, 1, 1 } };
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    ans++;
                    isLand(grid, vis, ans, n, m, i, j);
                }
            }
        }
        System.out.println(ans);
    }
}
