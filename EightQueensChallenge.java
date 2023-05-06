package eightqueenschallenge;

public class EightQueensChallenge {
	private static final int BOARD_SIZE = 8;
	public static void main(String[] args) {
		int[] queens = new int[BOARD_SIZE];
		long startTime = System.nanoTime();
		enumerate(queens, 0);
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("Total time: " + duration + " nanoseconds");
	}
	public static void enumerate(int[] queens, int n) {
		if (n == BOARD_SIZE) { printBoard(queens); } else {
			for (int i = 0; i < BOARD_SIZE; i ++) { queens[n] = i;
				if (isValid(queens, n)) { enumerate(queens, n + 1); }
			}
		}
	}
	public static boolean isValid(int[] queens, int n) {
		for (int i = 0; i < n; i ++) {
			if (queens[i] == queens[n]) { return false; }
			if (queens[i] - queens[n] == n - i) { return false; }
			if (queens[n] - queens[i] == n - i) { return false; }
		}
		return true;
	}
	public static void printBoard(int[] queens) {
		for (int i = 0; i < BOARD_SIZE; i ++) {
			for (int j = 0; j < BOARD_SIZE; j ++) {
				if (queens[i] == j) { System.out.print("Q "); } else { System.out.print("- "); } }
			System.out.println("");
		}
		System.out.println("");
	}
}

