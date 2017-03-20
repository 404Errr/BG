package data;

public interface GameData {
	int EMPTY = -1, A = 0, B = 1;
	int A_DIR = 1, B_DIR = -1;

	static boolean isCorrectDir(int dir, int color) {
		if (color==A&&Math.signum(dir)==A_DIR) return true;
		if (color==B&&Math.signum(dir)==B_DIR) return true;
		return false;
	}

	int UPS = 60;

	int[][] LAYOUT = Layout.LAYOUT_0;

	int MARGIN = 100, CHECKER_SIZE = 50;
}
