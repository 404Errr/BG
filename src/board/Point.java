package board;

import java.util.Stack;

import data.GameData;
import game.Game;

@SuppressWarnings("serial")
public class Point<C> extends Stack<C> implements GameData {
	private final int index;
	private Point<C> neg, pos;

	@SuppressWarnings("unchecked")
	public Point(int index, int initialHeight, int checkerColor) {
		this.index = index;
		for (int i = 0;i<initialHeight;i++) {
			push((C) new Checker(checkerColor));
		}
	}

	public int getColor() {//color of checker on the top
		if (isEmpty()) return EMPTY;
		return ((Checker) peek()).getColor();
	}

	public int getIndex() {
		return index;
	}

	@SuppressWarnings("unchecked")
	public Point<C> getNeg() {
		if (index>0&&neg==null) neg = (Point<C>) Game.board().get(index-1);
		return neg;
	}

	@SuppressWarnings("unchecked")
	public Point<C> getPos() {
		if (index==Game.board().size()-1) return null;
		if (pos==null) pos = (Point<C>) Game.board().get(index+1);
		return pos;
	}

	@Override
	public String toString() {
		return index+"\tL "+((neg==null)?"null":neg.getIndex())+"\tR "+((pos==null)?"null":pos.getIndex())+"\t"+size();
	}
}
