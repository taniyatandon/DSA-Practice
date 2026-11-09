
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int initialColor = image[sr][sc];

        if (initialColor == color) {
            return image;
        }

        boolean[][] visited = new boolean[n][m];

        int[] delrow = {-1, 1, 0, 0};
        int[] delcol = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{sr, sc});
        visited[sr][sc] = true;
        image[sr][sc] = color;

        while (!q.isEmpty()) {
            int[] node = q.poll();

            int row = node[0];
            int col = node[1];

            for (int k = 0; k < 4; k++) {
                int nrow = row + delrow[k];
                int ncol = col + delcol[k];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    !visited[nrow][ncol] &&
                    image[nrow][ncol] == initialColor) {

                    visited[nrow][ncol] = true;
                    image[nrow][ncol] = color;

                    q.add(new int[]{nrow, ncol});
                }
            }
        }

        return image;
    }
}
