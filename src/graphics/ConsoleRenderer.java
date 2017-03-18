package graphics;

import board.Slot;
import data.GameData;

public class ConsoleRenderer implements GameData {
	private static final String[] STONE_CHARS = {"O","X"};

	public static void printBoard(Slot[] board) {
		StringBuilder str = new StringBuilder();
		for (int i = 0;i<board.length;i++) {
			str.append(i+" - ");
			int s = 0;
			do {
				if (board[i].getColor()==A) str.append(STONE_CHARS[A]);
				if (board[i].getColor()==B) str.append(STONE_CHARS[B]);
				s++;
			} while (s<board[i].getStoneCount());
			str.append("\n");
		}
		System.out.println(str);
	}
}
