package board;

import java.util.Stack;

@SuppressWarnings("serial")
public class Point<C> extends Stack<C> {
	private final int index;
	private Point<C> left, right;

	@SuppressWarnings("unchecked")
	public Point(int index, int initialHeight, int checkerColor) {
		this.index = index;
		for (int i = 0;i<initialHeight;i++) {
			push((C) new Checker(checkerColor));
		}
	}







	public int getColor() {//color of checker on the top
		return ((Checker) peek()).getColor();
	}

	public int getIndex() {
		return index;
	}

	public Point<C> getLeft() {
		return left;
	}

	public Point<C> getRight() {
		return right;
	}

	public void setNeighbors(Point<C> left, Point<C> right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return index+"\tL "+((left==null)?"null":left.getIndex())+"\tR "+((right==null)?"null":right.getIndex())+"\t"+size();
	}
}
