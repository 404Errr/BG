package graphics;

import board.Slot;
import data.GameData;
import game.Game;

public class ConsoleRenderer implements GameData {
	private static final String[] STONE_CHARS = {"O","X"};

	public static void printGameState() {
		clearConsole();
		System.out.println(STONE_CHARS[Game.getTurn()]);
		ConsoleRenderer.printBoard(Game.getBoard().getBoard());
	}

	public static void printBoard(Slot[] board) {
		StringBuilder str = new StringBuilder();
		for (int i = 0;i<board.length;i++) {
			if (i%(board.length/4)==0) str.append(getDash(10)+"\n");
			str.append((i+1)+" - ");
			for (int s = 0;s<board[i].getStoneCount();s++) {
				if (board[i].getColor()==A) str.append(STONE_CHARS[A]);
				if (board[i].getColor()==B) str.append(STONE_CHARS[B]);
			}
			str.append("\n");
		}
		str.append(getDash(10)+"\n");
		System.out.println(str);
	}

	public static void clearConsole() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0;i<100;i++) sb.append("\n");
		System.out.print(sb);
	}

	public static String getDash(int length) {
		StringBuilder str = new StringBuilder();
		for (int i = 0;i<length;i++) str.append("=");
		return str.toString();
	}
}
