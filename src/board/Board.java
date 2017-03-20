package board;

import java.util.ArrayList;
import java.util.List;

import data.GameData;
import game.Game;
import game.RollableDie;
import game.UseableDie;

public class Board implements GameData {
	private final Point[] points;
	private final List<Checker> captured;
	private int turn;
	private RollableDie[] dice;
	private List<UseableDie> diceToUse;


	public Board(int[][] layout) {
		captured = new ArrayList<>();
		List<Point> pointList = new ArrayList<>();
		int currentPoint = 0;
		for (int i = 0;i<layout.length;i++) {
			if (layout[i].length==2) {
				pointList.add(new Point(i, layout[i][0], layout[i][1]));
				currentPoint++;
			}
			else {
				for (int j = 0;j<layout[i][0];j++) {
					pointList.add(new Point(currentPoint+j));
					currentPoint+=layout[i][0];
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
		if (t.canBeCaptured()&&color!=t.peekColor()) t.capture();//capture
		t.push(release(color));
		return true;
	}

	public boolean moveChecker(int from, int to) {
		if (from==to||from!=-1&&from<0||to<0||from>=points.length||to>=points.length) return false;
		Point f = points[from], t = points[to];
		if (!t.canMoveTo(f)) return false;
		if (GameData.isCorrectDir(to-from, f.peekColor())) return false;
		if (t.canBeCaptured()&&f.peekColor()!=t.peekColor()) t.capture();//capture
		t.push(f.pop());
		return true;
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
	
	private Board(Point[] points, List<Checker> captured, int turn, RollableDie[] dice, List<UseableDie> diceToUse) {
		this.points = points;
		this.captured = captured;
		this.turn = turn;
		this.dice = dice;
		this.diceToUse = diceToUse;
	}

	public Board copy() {
		return new Board(points, captured, turn, dice, diceToUse);
	}
}
