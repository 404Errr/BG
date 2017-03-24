package board;

import java.util.List;

import data.GameData;
import data.Layout;

public class Board implements GameData {
	private final List<Point<Checker>> points;

	public Board(int[][] layout) {
		points = Layout.CreateLayout.createPoints(layout);
	}
//
	public void tick() {
//		for (int i = 0;i<points.length;i++) {
//			points[i].tick();
//		}
	}

//	public void deselectAll() {
//		for (int i = 0;i<points.length;i++) {
//			points[i].setSelected(false);
//		}
//	}
//
//	public boolean anyAreSelected() {
//		for (int i = 0;i<points.length;i++) {
//			if (points[i].isSelected()) return true;
//		}
//		return false;
//	}
//
//	public Checker release(int color) {
//		for (int i = 0;i<captured.size();i++) {
//			if (captured.get(i).getColor()==color) {//found
//				return captured.remove(i);
//			}
//		}
//		return null;
//	}
//
//	public boolean capture(int point) {
//		captured.add(points[point].pop());
//		return false;
//	}
//
//	public boolean moveReleaseChecker(int color, int to) {
//		if (!isValidMove(from, to)||to>=6&&to<points.length-6) {
//			return false;
//		}
//		Point t = points[to];
//		if (!anyCanMoveTo(t)) {
//			return false;
//		}
//		if (t.canBeCaptured()&&color!=t.peekColor()) {
//			t.capture();//capture
//		}
//		t.push(release(color));
//		return true;
//	}
//
//	public boolean moveChecker(int from, int to) {
//		if (!isValidMove(from, to)) {
//			return false;
//		}
//		Point f = points[from], t = points[to];
//		if (t.canBeCaptured()&&f.peekColor()!=t.peekColor()) {
//			t.capture();//capture
//		}
//		t.push(f.pop());
//		return true;
//	}
//
//	public boolean isValidMove(int from, int to) {
//		if (from==to||from<0||to<0||from>=points.length||to>=points.length) {
//			return false;
//		}
//		Point f = points[from], t = points[to];
//		if (!canMoveToFrom(f, t)||!GameData.isCorrectDir(from-to, f.peekColor())) {
//			return false;
//		}
//		for (int i = 0;i<diceToUse.size();i++) {
//			int value = diceToUse.get(i).getValue();
//
//		}
//		return true;
//	}
//
//	public boolean anyCanMoveTo(Point to) {
//		return to.height()<=1;
//	}
//
//	public boolean canMoveTo(Point to, int color) {
//		return color==to.peekColor()||to.height()<=1;
//	}
//
//	public boolean canMoveToFrom(Point to, Point from) {
//		return !from.isEmpty()&&(to.peekColor()==from.peekColor()||to.height()<=1);
//	}

	public int size() {
		return points.size();
	}

	public Point<Checker> get(int p) {
//		if (p<0||p>=points.size()) return null;
		return points.get(p);
	}

	public List<Point<Checker>> getPoints() {
		return points;
	}
}
