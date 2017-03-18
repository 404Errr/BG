package game;

import java.util.ArrayList;
import java.util.List;

import board.Slot;
import data.GameData;

public class Board implements GameData {
	private final Slot[] board;

	public Board(int[][] layout) {
		List<Slot> slotList = new ArrayList<>();
		for (int i = 0;i<layout.length;i++) {
			if (layout[i].length==2) {
				slotList.add(new Slot(layout[i][0], layout[i][1]));
			}
			else {
				for (int j = 0;j<layout[i][0];j++) {
					slotList.add(new Slot());
				}
			}
		}
		board = new Slot[slotList.size()];
		for (int i = 0;i<slotList.size();i++) {
			board[i] = slotList.get(i);
		}
	}

	public Slot[] getBoard() {
		return board;
	}
}
