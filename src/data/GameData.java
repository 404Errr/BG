package data;

public interface GameData {
	int EMPTY = -1, A = 0, B = 1;
	Direction A_DIR = Direction.POS, B_DIR = Direction.NEG;

	int UPS = 60;

	int[][] LAYOUT = Layout.NORM;
//	int[][] LAYOUT = Layout.NACK;
}
