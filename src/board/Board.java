package board;

import java.util.ArrayList;
import java.util.List;

import data.Direction;
import data.GameData;
import data.Layout;
import dice.Dice;
import dice.UseableDie;
import player.AIPlayer;
import player.HumanPlayer;
import player.Player;

public class Board implements GameData {
	private final List<Point<Checker>> points, captured, home;
	private final Dice dice;
	private Player currentPlayer;
	private final List<Player> players;

	public Board(int[][] layout) {
		points = Layout.CreateLayout.createPoints(layout);
		captured = new ArrayList<>();
		home = new ArrayList<>();
		home.add(new Point<Checker>(-1, 0, A));
		captured.add(new Point<Checker>(-1, 0, B));
		home.add(new Point<Checker>(24, 0, B));
		captured.add(new Point<Checker>(24, 0, A));
		players = new ArrayList<>();
		players.add(new HumanPlayer(0));
//		players.add(new HumanPlayer(1));
//		players.add(new AIPlayer(0));
		players.add(new AIPlayer(1));
		currentPlayer = players.get(0);
		dice = new Dice();
		while (dice.diceAreEqual()) dice.roll();
	}

	public void tick() {

		if (needDiceRoll()) dice.roll();
	}

	public void move(Point<Checker> from, Point<Checker> to) {
//		System.out.println("move         \tfrom = "+from+"\t\tto = "+to);
		if (!isLegalMove(from, to)) throw new UnsupportedOperationException("Illegal move "+from.getIndex()+"-"+to.getIndex());
		if (wouldCapture(from, to)) capture(to);
		to.push(from.pop());
		List<Integer> values = dice.getUseableValues();
		find:
		for (int i = 0;i<values.size();i++) {
			if (values.get(i)+1==Math.abs(from.getIndex()-to.getIndex())) {//+1 to the dice value
				for (int j = 0;j<dice.getUseableDice().size();j++) {
					if (!dice.getUseableDice().get(j).isBeingUsed()&&values.get(i)==dice.getUseableDice().get(j).getValue()) {
						dice.getUseableDice().get(j).setBeingUsed(true);
						break find;
					}
				}
			}
		}

	}

	public boolean wouldCapture(Point<Checker> from, Point<Checker> to) {
		return to.size()==1&&from.getColor()!=to.getColor();
	}

	public boolean isLegalToMove(Point<Checker> from) {
		if (!from.isEmpty()) return true;
		return false;
	}

	public boolean isLegalMove(Point<Checker> from, Point<Checker> to) {
//		System.out.println("illegal check\tfrom = "+from+"\t\tto = "+to);
		if (from==null||to==null) return false;
		if (from.isEmpty()) return false;
		if (from.getColor()!=to.getColor()&&to.size()>1) return false;
		Direction dir = Direction.getDirection(from.getIndex(), to.getIndex());
		if (dir==Direction.NONE||(from.getColor()==A)!=(dir==A_DIR)) return false;
		List<Integer> values = dice.getUseableValues();
		for (int i = 0;i<values.size();i++) {
//			System.out.println((values.get(i)+1)+"\t"+Math.abs(from.getIndex()-to.getIndex()));
			if (values.get(i)+1==Math.abs(from.getIndex()-to.getIndex())) {//+1 to the dice value
				return true;
			}
		}
		return false;
	}

	public boolean needDiceRoll() {
		boolean needsRoll = true;
		for (UseableDie die:dice.getUseableDice()) {
			if (!die.isBeingUsed()) needsRoll = false;
		}
		return needsRoll;
	}

	public void rollDice() {
		dice.roll();
	}

	public void capture(Point<Checker> point) {
		captured.get(point.getColor()).push(point.pop());
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

	public List<Point<Checker>> getCaptured() {
		return captured;
	}

	public List<Point<Checker>> getHome() {
		return home;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}


}
