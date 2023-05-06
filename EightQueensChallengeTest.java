package eightqueenschallenge;

public class EightQueensChallengeTest {
	private static final int BOARD_SIZE = 8;
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int[] queens = new int[BOARD_SIZE];
		int count = 0;
		for (int i = 0; i < BOARD_SIZE; i++) {
			queens[0] = i;
			for (int j = 0; j < BOARD_SIZE; j++) {
				queens[1] = j;
				for (int k = 0; k < BOARD_SIZE; k++) {
					queens[2] = k;
					for (int l = 0; l < BOARD_SIZE; l++) {
						queens[3] = l;
						for (int m = 0; m < BOARD_SIZE; m++) {
							queens[4] = m;
							for (int n = 0; n < BOARD_SIZE; n++) {
								queens[5] = n;
								for (int o = 0; o < BOARD_SIZE; o++) {
									queens[6] = o;
									for (int p = 0; p < BOARD_SIZE; p++) {
										queens[7] = p;
										if (isValid(queens)) {
											count++;
											printSolution(queens);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println("Number of solutions: " + count);
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("Total time: " + duration + " nanoseconds");
	}
	private static boolean isValid(int[] queens) {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = i + 1; j < BOARD_SIZE; j++) {
				if (queens[i] == queens[j]) { return false; }
				if (queens[i] - queens[j] == i - j) { return false;}
				if (queens[i] - queens[j] == j - i) { return false; }
			}
		}
		return true;
	}
	private static void printSolution(int[] queens) {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (queens[i] == j) { System.out.print("Q "); } else { System.out.print("- "); }
			}
			System.out.println();
		}
		System.out.println();
	}
}
