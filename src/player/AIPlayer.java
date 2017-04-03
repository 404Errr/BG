package player;

import java.util.ArrayList;
import java.util.List;

import board.Checker;
import board.Point;
import board.move.Move;
import board.move.MoveSet;
import game.Game;

public class AIPlayer extends Player {

	public AIPlayer(int color) {
		super(color);
	}

	public void move(MoveSet moveSet) {
		Game.board().move(moveSet);
	}

	public void move() {
		List<Move> moves = new ArrayList<>();
		Point<Checker> from = null, to = null;
		for (int k = 0;k<Game.board().getDice().getUseableDice().size();k++) {
			int i = 0;
			while (i<10000) {
				from = Game.board().get((int) (Math.random()*24));
				to = Game.board().get((int) (Math.random()*24));
				if (from.getColor()==color&&Game.board().isLegalMove(new Move(from, to))) break;
				i++;
			}
			moves.add(new Move(from, to));
		}
		System.out.println("\t\t\t\t\t"+moves.size());
		move(new MoveSet(moves));
	}
}

