import java.util.LinkedList;
import java.util.Queue;

public class graphQ2RottenOranges {

    public static class Matrix {
        int i;
        int j;
        int time;

        public Matrix(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    public static int rottenOranges(int orang[][]) {
        int n = orang.length;
        int m = orang[0].length;
        System.out.println("vis size testing " + n + " " + m);
        int ans = 0;
        boolean vis[][] = new boolean[n][m];
        Queue<Matrix> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (orang[i][j] == 2) {
                    q.add(new Matrix(i, j, 0));
                }
            }
        }
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        // Step 2: BFS
        while (!q.isEmpty()) {
            Matrix curr = q.poll();
            ans = Math.max(ans, curr.time);

            for (int d = 0; d < 4; d++) {
                int ni = curr.i + dx[d];
                int nj = curr.j + dy[d];

                if (ni >= 0 && nj >= 0 && ni < n && nj < m && !vis[ni][nj] && orang[ni][nj] == 1) {
                    vis[ni][nj] = true;
                    q.add(new Matrix(ni, nj, curr.time + 1));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && orang[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int orang[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println(rottenOranges(orang));
    }
}
