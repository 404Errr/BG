package board.move;

import board.Checker;
import board.Point;

public class Move {
	private Point<Checker> from, to;

	public Move(Point<Checker> from, Point<Checker> to) {
		this.from = from;
		this.to = to;
	}

	public Point<Checker> getFrom() {
		return from;
	}

	public Point<Checker> getTo() {
		return to;
	}

	@Override
	public String toString() {
		return from.getIndex()+"/"+to.getIndex();
	}
}

