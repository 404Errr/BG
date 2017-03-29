package player;

import board.Checker;
import board.Point;
import game.Game;

public class AIPlayer extends Player {

	public AIPlayer(int color) {
		super(color);
	}

	public void move() {
		Point<Checker> from = null, to = null;
		while (!Game.board().needDiceRoll()) {
			int i = 0;
			while (i<10000) {
				from = Game.board().get((int) (Math.random()*24));
				to = Game.board().get((int) (Math.random()*24));
				if (from.getColor()==color&&Game.board().isLegalMove(from, to)) break;
				i++;
			}
			if (from.getColor()==color&&Game.board().isLegalMove(from, to)) makeMoveRequest(from, to);
		}
	}
}

