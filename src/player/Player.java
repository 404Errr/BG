package player;

import board.Checker;
import board.Point;
import game.Game;

public abstract class Player {
	protected final int color;

	public Player(int color) {
		this.color = color;
	}

	public int getColor() {
		return color;
	}

	public void moveRequest(Point<Checker> from, Point<Checker> to) {
		if (!Game.board().isLegalMove(from, to)) return;
		System.out.println(from.getIndex()+"/"+to.getIndex());
		Game.board().move(from, to);
	}
}
