package board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import board.move.Move;
import board.move.MoveSet;
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
		if (PLAYERS[0]==HUMAN) players.add(new HumanPlayer(0));
		else players.add(new AIPlayer(0));
		if (PLAYERS[1]==HUMAN) players.add(new HumanPlayer(1));
		else players.add(new AIPlayer(1));
		currentPlayer = players.get(new Random().nextInt(2));
		dice = new Dice();
		while (dice.diceAreEqual()) dice.roll();
	}

	public void tick() {
		if (needDiceRoll()) {//next turn
			dice.roll();
			cycleTurn();
		}
		if (currentPlayer instanceof AIPlayer) {
			((AIPlayer) currentPlayer).move();
		}
	}

	public void move(MoveSet moveSet) {
		for (int i = 0;i<moveSet.getMoves().size();i++) {
			move(moveSet.getMoves().get(i));
		}
	}

	public void move(Move move) {
		if (!isLegalMove(move)) throw new UnsupportedOperationException("Illegal move "+move);
		if (wouldCapture(move)) capture(move.getTo());
		move.getTo().push(move.getFrom().pop());
		List<Integer> values = dice.getUseableValues();
		find:
		for (int i = 0;i<values.size();i++) {
			if (values.get(i)+1==Math.abs(move.getFrom().getIndex()-move.getTo().getIndex())) {
				for (int j = 0;j<dice.getUseableDice().size();j++) {
					if (!dice.getUseableDice().get(j).isBeingUsed()&&values.get(i)==dice.getUseableDice().get(j).getValue()) {
						dice.getUseableDice().get(j).setBeingUsed(true);
						break find;
					}
				}
			}
		}
		System.out.println(move);
	}

	public boolean wouldCapture(Move move) {
		return move.getTo().size()==1&&move.getFrom().getColor()!=move.getTo().getColor();
	}

	public boolean isLegalToMove(Point<Checker> to) {
		return !to.isEmpty();
	}

	public boolean isLegalMove(Move move) {
		if (move.getFrom()==null||move.getTo()==null) return false;
		if (move.getFrom().isEmpty()) return false;
		if (move.getFrom().getColor()!=move.getTo().getColor()&&move.getTo().size()>1) return false;
		Direction dir = Direction.getDirection(move.getFrom().getIndex(), move.getTo().getIndex());
		if (dir==Direction.NONE||(move.getFrom().getColor()==A)!=(dir==A_DIR)) return false;
		List<Integer> values = dice.getUseableValues();
		for (int i = 0;i<values.size();i++) {
			if (values.get(i)+1==Math.abs(move.getFrom().getIndex()-move.getTo().getIndex())) {
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

	public void capture(Point<Checker> victim) {
		captured.get(victim.getColor()).push(victim.pop());
	}

	public Dice getDice() {
		return dice;
	}

	public void cycleTurn() {
		currentPlayer = (players.get(0)!=currentPlayer)?players.get(0):players.get(1);
	}

	public int size() {
		return points.size();
	}

	public Point<Checker> get(int point) {
		return points.get(point);
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
