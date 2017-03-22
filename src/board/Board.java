package board;

import java.util.ArrayList;
import java.util.List;

import data.GameData;
import game.Game;
import game.RollableDie;
import game.UseableDie;

public class Board implements GameData {
	private final Point[] points;
	private final List<Checker> captured, checkers;
	private int turn;
	private RollableDie[] dice;
	private List<UseableDie> diceToUse;

	public Board(int[][] layout) {
		captured = new ArrayList<>();
		checkers = new ArrayList<>();
		List<Point> pointList = new ArrayList<>();
		int currentPointNum = 0;
		for (int i = 0;i<layout.length;i++) {
			if (layout[i].length==1) {//empty
				for (int j = 0;j<layout[i][0];j++) {
					pointList.add(new Point(currentPointNum+j));
				}
				currentPointNum+=layout[i][0];
			}
			else {
				pointList.add(new Point(currentPointNum, layout[i][1], layout[i][0]));
				currentPointNum++;
			}
		}
		points = new Point[pointList.size()];
		for (int i = 0;i<pointList.size();i++) {
			points[i] = pointList.get(i);
			points[i].init(this);
		}
	}

	public void tick() {
		for (int i = 0;i<points.length;i++) {
			points[i].tick();
		}
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

	public void addChecker(Checker checker) {
		checkers.add(checker);
	}

	public Point[] getPoints() {
		return points;
	}

	public void refreshDiceToUse() {
		diceToUse.clear();
		for (int i = 0;i<1||(i<2&&dice[0].getValue()==dice[1].getValue());i++) {
			for (int j = 0;j<2;j++) diceToUse.add(new UseableDie(dice[j].getValue()));
		}
	}

	public void rollDice() {
		Game.save();
		for (int i = 0;i<dice.length;i++) dice[i].roll();
		refreshDiceToUse();
	}

	public void cycleTurn() {
		turn = (turn!=A)?A:B;
	}

	public RollableDie[] getDice() {
		return dice;
	}

	public int getTurn() {
		return turn;
	}

	public List<UseableDie> getDiceToUse() {
		return diceToUse;
	}

	public List<UseableDie> getUseableDice() {
		List<UseableDie> array = new ArrayList<>();
		for (UseableDie die:diceToUse) if (!die.isBeingUsed()) array.add(die);
		return array;
	}

	public List<Integer> getUseableDiceValues() {
		List<Integer> array = new ArrayList<>();
		for (UseableDie die:diceToUse) if (!die.isBeingUsed()) array.add(die.getValue());
		return array;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public void setDice(RollableDie[] dice) {
		this.dice = dice;
	}

	public void setDiceToUse(List<UseableDie> diceToUse) {
		this.diceToUse = diceToUse;
	}

	private Board(Point[] points, List<Checker> captured, List<Checker> checkers, int turn, RollableDie[] dice, List<UseableDie> diceToUse) {
		this.points = points;
		this.captured = captured;
		this.checkers = checkers;
		this.turn = turn;
		this.dice = dice;
		this.diceToUse = diceToUse;
	}

	public Board copy() {
		return new Board(points, captured, checkers, turn, dice, diceToUse);
	}
}
