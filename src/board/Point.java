package board;

import java.util.Stack;

import data.GameData;

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

	public Point<C> getNeg() {
		return neg;
	}

	public Point<C> getPos() {
		return pos;
	}

	public void setNeighbors(Point<C> neg, Point<C> pos) {
		this.neg = neg;
		this.pos = pos;
	}

	@Override
	public String toString() {
		return index+"\tL "+((neg==null)?"null":neg.getIndex())+"\tR "+((pos==null)?"null":pos.getIndex())+"\t"+size();
	}
}
