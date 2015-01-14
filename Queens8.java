import java.util.ArrayList;

public class Queens8 {
	static int GRID_SIZE = 8;

	static void placeQueens(int row, Integer[] columns,
			ArrayList<Integer[]> results) {
		if (row == GRID_SIZE) { // Found valid placement
			results.add(columns.clone());
		} else {
			for (int col = 0; col < GRID_SIZE; col++) {
				if (checkValid(columns, row, col)) {
					columns[row] = col; // Place queen
					placeQueens(row + 1, columns, results);
				}
			}
		}
	}
	/*
	 * Check if (rowl, columnl) is a valid spot for a queen by checking if there
	 * is a queen in the same column or diagonal. We don't need to check it for
	 * queens in the same row because the calling placeQueen only attempts to
	 * place one queen at a time. We know this row is empty.
	 */
	static boolean checkValid(Integer[] columns, int rowl, int columnl) {
		for (int row2 = 0; row2 < rowl; row2++) {
			int column2 = columns[row2];
			/*
			 * Check if (row2, column2) invalidates (rowl, columnl) as a
			 * 
			 * queen spot.
			 */
			/* Check if rows have a queen in the same column */
			if (columnl == column2) {
				return false;
			}
			/*
			 * Check diagonals: if the distance between the columns
			 * 
			 * equals the distance between the rows, then they're in the
			 * 
			 * same diagonal.
			 */
			int columnDistance = Math.abs(column2 - columnl);
			/* rowl > row2, so no need for abs */
			int rowDistance = rowl - row2;
			if (columnDistance == rowDistance) {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		Integer[] columns = new Integer[GRID_SIZE];
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		placeQueens(0, columns, results);
		int count = 0;
		for (Integer[] e : results) {
			for (Integer ele : e) {
				System.out.print(ele + " ,");
			}
			System.out.println("\n");
			count++;
		}
		System.out.println(count);
	}
}