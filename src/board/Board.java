package board;

import java.util.ArrayList;
import java.util.List;

import data.GameData;

public class Board implements GameData {
	private final Point[] points;

	public Board(int[][] layout) {
		List<Point> pointList = new ArrayList<>();
		for (int i = 0;i<layout.length;i++) {
			if (layout[i].length==2) {
				pointList.add(new Point(i, layout[i][0], layout[i][1]));
			}
			else {
				for (int j = 0;j<layout[i][0];j++) {
					pointList.add(new Point(i));
				}
			}
		}
		points = new Point[pointList.size()];
		for (int i = 0;i<pointList.size();i++) {
			points[i] = pointList.get(i);
		}
	}

	public Point[] getPoints() {
		return points;
	}
}
