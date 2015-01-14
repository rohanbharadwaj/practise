/*
 * dist(node) = min( dist(upper node), dist(left node)) + node's value
 * 
 */
public class solution_dp_minpath {

	private int getDist(int[][] dist, int x, int y) {
		if (x < 0 || y < 0) {
			return Integer.MAX_VALUE;
		}

		return dist[x][y];
	}

	private int min(int i1, int i2) {
		return i1 < i2 ? i1 : i2;
	}

	public int minPathSum(int[][] grid) {

		if (grid == null || grid.length == 0)
			return 0;

		int m = grid.length;
		int n = grid[0].length;

		int[][] dist = new int[m][n];

		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {

				if (x == 0 && y == 0) {
					dist[0][0] = grid[0][0];
				} else {
					dist[x][y] = min(getDist(dist, x - 1, y),
							getDist(dist, x, y - 1))
							+ grid[x][y];
				}
			}
		}

		return dist[m - 1][n - 1];

	}

	public static void main(String args[]) {
		int[][] grid = { { -1, 4, 3 }, { 2, -2, 0 }, { 1, 2, 3 } };
		solution_dp_minpath obj = new solution_dp_minpath();
		System.out.println(obj.minPathSum(grid));
	}
}