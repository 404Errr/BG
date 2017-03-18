package board;

import data.GameData;

public interface Layout extends GameData {

	static int[][] generateLayout(int[][] layout) {
//		int[][]

		return new int[24][];
	}

	int[][] LAYOUT_0 = {
			{A, 2},
			{4},
			{B, 5},
			{1},
			{B, 3},
			{3},
			{A, 5},
			{B, 5},
			{3},
			{A, 3},
			{1},
			{A, 5},
			{4},
			{B, 2}
	};
}
