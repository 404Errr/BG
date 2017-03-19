package data;

import board.Layout;

public interface GameData {
	int EMPTY = -1, A = 0, B = 1;

	int UPS = 60;

	int[][] LAYOUT = Layout.LAYOUT_0;

	int MARGIN = 100, CHECKER_SIZE = 50;
}
