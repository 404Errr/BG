package player;

import board.Checker;
import board.Point;
import board.move.Move;
import game.Game;

public class HumanPlayer extends Player {
	private Point<Checker> selectedPoint;

	public HumanPlayer(int color) {
		super(color);
	}

	public Point<Checker> getSelectedPoint() {
		return selectedPoint;
	}

	public void setSelectedPoint(Point<Checker> selectedPoint) {
		this.selectedPoint = selectedPoint;
		System.out.println("selected:\t"+this.selectedPoint);
	}

	public void makeMoveRequest(Point<Checker> from, Point<Checker> to) {
		Move move = new Move(from, to);
		if (!Game.board().isLegalMove(move)) return;
		Game.board().move(move);
	}

}
