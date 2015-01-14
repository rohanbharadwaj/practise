import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_dijkstra {

	class PointComparator implements Comparator<int[]> {
		int[][] dist;

		public PointComparator(int[][] dist) {
			this.dist = dist;
		}

		public int compare(int[] o1, int[] o2) {
			int[] point1 = (int[]) o1;
			int[] point2 = (int[]) o2;
			return Integer.valueOf(dist[point1[0]][point1[1]]).compareTo(
					Integer.valueOf(dist[point2[0]][point2[1]]));
		}
	}

	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;

		boolean[][] visited = new boolean[m][n];
		int[][] dist = new int[m][n];

		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				dist[x][y] = Integer.MAX_VALUE;
			}
		}

		dist[0][0] = grid[0][0];

		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(m * n,
				new PointComparator(dist));

		pq.add(new int[] { 0, 0 });

		while (!pq.isEmpty()) {

			int[] point = pq.poll();
			int x = point[0];
			int y = point[1];
			int d = dist[x][y];

			if (x == n - 1 && y == m - 1) {
				return d;
			}

			visited[x][y] = true;

			if ((y + 1 < n) && !visited[x][y + 1]) {
				dist[x][y + 1] = min(dist[x][y + 1], d + grid[x][y + 1]);
				pq.add(new int[] { x, y + 1 });
			}

			if ((x + 1 < m) && !visited[x + 1][y]) {
				dist[x + 1][y] = min(dist[x + 1][y], d + grid[x + 1][y]);
				pq.add(new int[] { x + 1, y });
			}
		}
		return 0;

	}

	private int min(int i1, int i2) {
		return i1 < i2 ? i1 : i2;
	}
	
	public static void main(String args[])
	{
		int[][] grid = {{-1,4,3},{2,-2,0},{1,2,3}}; 
		Solution_dijkstra obj = new Solution_dijkstra();
		System.out.println(obj.minPathSum(grid));
	}
}