package board;

import java.util.Stack;

import data.GameData;

public class Point implements GameData {
	private final int pointNum;
	private Stack<Checker> checkers;
	private boolean selected, valid;

	public Point(int slotNum) {
		this(slotNum, EMPTY, 0);
	}

	public Point(int pointNum, int color, int checkerCount) {
		this.pointNum = pointNum;
		checkers = new Stack<>();
		for (int i = 0;i<checkerCount;i++) {
			checkers.push(new Checker(color));
		}
	}

	public boolean canMoveTo(Point from) {
		if (from.isEmpty()) return false;
		if (isEmpty()) return true;
		return peekColor()==from.peekColor()||size()<=1;
	}

	public Stack<Checker> getCheckers() {
		return checkers;
	}

	public int peekColor() {
		if (checkers.isEmpty()) return EMPTY;
		return checkers.peek().getColor();
	}

	public Checker peek() {
		if (!checkers.isEmpty()) return checkers.peek();
		return null;
	}

	public Checker capture() {
		return pop();
	}

	public Checker pop() {
		if (!checkers.isEmpty()) return checkers.pop();
		return null;
	}

	public void push(Checker checker) {
		checkers.push(checker);
	}

	public int size() {
		return checkers.size();
	}

	public boolean isEmpty() {
		return checkers.isEmpty();
	}

	public boolean canBeCaptured() {
		return checkers.size()==1;
	}

	public int getPointNum() {
		return pointNum;
	}

	public boolean isValid(int color) {
		boolean valid = true;
		if (checkers.peek().getColor()!=color) valid = false;

//		for (int i = 0;i<Game.getDiceToUse().size();i++) {
//			int value = Game.getDiceToUse().get(i).getValue();
//
//
//
//		}

		this.valid = valid;
		return valid;
	}

	public boolean isValid() {
		return valid;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}


}
