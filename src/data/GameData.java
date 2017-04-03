package data;

public interface GameData {
	int EMPTY = -1, A = 0, B = 1;
	Direction A_DIR = Direction.POS, B_DIR = Direction.NEG;

	int HUMAN = 0, AI = 1;
	int[] PLAYERS = {HUMAN, AI};

	int UPS = 60;

	int[][] LAYOUT = Layout.NORM;
//	int[][] LAYOUT = Layout.NACK;
}
