package board;

import java.util.ArrayList;
import java.util.List;

import data.GameData;

public class Board implements GameData {
	private final Point[] points;
	private final List<Checker> captured;

	public Board(int[][] layout) {
		captured = new ArrayList<>();
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

	public Checker release(int color) {
		for (int i = 0;i<captured.size();i++) if (captured.get(i).getColor()==color) return captured.remove(i);
		return null;
	}

	public boolean capture(int point) {
		captured.add(points[point].pop());
		return false;
	}

	public boolean moveReleaseChecker(int color, int to) {
		if (to<0||to>=points.length||to>=6&&to<points.length-6) return false;
		Point t = points[to];
		if (!t.canMoveTo()) return false;
		t.push(release(color));
		return true;
	}

	public boolean moveChecker(int from, int to) {
		if (from==to||from!=-1&&from<0||to<0||from>=points.length||to>=points.length) return false;
		Point f = points[from], t = points[to];
		if (from==-1) {

		}
		else {
			if (!t.canMoveTo(f)) return false;
			if (GameData.isCorrectDir(to-from, f.peekColor())) return false;
			if (t.canBeCaptured()&&f.peekColor()!=t.peekColor()) t.capture();//capture
			t.push(f.pop());
		}
		return true;
	}

	public Point[] getPoints() {
		return points;
	}
}
