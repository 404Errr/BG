package board;

import java.util.ArrayList;
import java.util.List;

import data.Direction;
import data.GameData;
import data.Layout;
import game.Game;

public class Board implements GameData {
	private final List<Point<Checker>> points, captured, home;
	private final Dice dice;

	public Board(int[][] layout) {
		points = Layout.CreateLayout.createPoints(layout);
		captured = new ArrayList<>();
		home = new ArrayList<>();
		for (int i = 0;i<2;i++) {//FIXME -1 and 24
			captured.add(new Point<Checker>(i, 0, i));
			home.add(new Point<Checker>(i, 0, i));
		}
		dice = new Dice();
		while (dice.diceAreEqual()) dice.roll();
	}

	public void move(Point<Checker> from, Point<Checker> to) {
		if (!isLegalMove(from, to)) throw new UnsupportedOperationException("Illegal move "+from.getIndex()+"/"+to.getIndex());
		if (wouldCapture(to)) {
			to.pop();
		}
		to.push(from.pop());
	}
	
	public boolean wouldCapture(Point<Checker> to) {
		return to.size()==1;
	}
	
	public boolean isLegalMove(Point<Checker> from, Point<Checker> to) {
		System.out.println(from.getColor()+"\t"+to.getColor());
		if (from==to||from.isEmpty()) return false;
		if (from.getColor()!=to.getColor()&&to.size()>1) return false;
		Direction dir = Direction.getDirection(from.getIndex(), to.getIndex());
		if (dir==Direction.NONE) return false;
		if ((from.getColor()==A)!=(dir==A_DIR)) return false;
		List<Integer> values = dice.getUseableValues();
		for (int i = 0;i<values.size();i++) {
			if (values.get(i)+1==Math.abs(from.getIndex()-to.getIndex())) {//+1 to the dice value
				return true;
			}
		}
		return false;
	}

	public void rollDice() {
		dice.roll();

		System.out.println(Game.board().isLegalMove(Game.board().get(0), Game.board().get(1)));
//		System.out.println(Game.board().isLegalMove(Game.board().get(12), Game.board().get(15), A));
//		System.out.println(Game.board().isLegalMove(Game.board().get(8), Game.board().get(5), A));
//		System.out.println(Game.board().isLegalMove(Game.board().get(11), Game.board().get(11), B));
//		System.out.println(Game.board().isLegalMove(Game.board().get(17), Game.board().get(19), B));
		System.out.println(Game.board().isLegalMove(Game.board().get(23), Game.board().get(22)));

	}

	public Dice getDice() {
		return dice;
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
