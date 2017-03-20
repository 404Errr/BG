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

	public boolean capture(int point) {
		points[point].pop();
		return false;
	}

	public boolean moveChecker(int from, int to) {
		if (from==to||from<0||to<0||from>=points.length||to>=points.length) return false;
		Point f = points[from], t = points[to];
		if (GameData.isCorrectDir(to-from, f.peekColor())) return false;
		if (!t.canMoveTo(f)) return false;
		if (t.canBeCaptured()&&f.peekColor()!=t.peekColor()) t.capture();//capture
		t.push(f.pop());
		return true;
	}

	public Point[] getPoints() {
		return points;
	}
}
