package board.move;

import java.util.List;

public class MoveSet {
	private List<Move> moves;

	public MoveSet(List<Move> moves) {
		this.moves = moves;
	}

	public List<Move> getMoves() {
		return moves;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 0;i<moves.size();i++) str.append(moves.get(i)+" ");
		return str.toString();
	}
}
