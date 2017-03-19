package board;

import java.util.Stack;

import data.GameData;

public class Point implements GameData {
	private final int pointNum;
	Stack<Checker> checkers;
	private boolean valid;

	public Point(int slotNum) {
		this(slotNum, EMPTY, 0);
	}

	public Point(int pointNum, int color, int stoneCount) {
		this.pointNum = pointNum;
		checkers = new Stack<>();
	}

	public boolean canMoveTo(Checker checker) {
		return checkers.lastElement().getColor()==checker.getColor()||checkers.size()>=1;
	}

	public Stack<Checker> getCheckers() {
		return checkers;
	}

	public void remove() {
		checkers.pop();
	}

	public void add(Checker checker) {
		checkers.push(checker);
	}

	public int getPointNum() {
		return pointNum;
	}

	public boolean isValid() {
		return valid;
	}

	public boolean isValid(int color) {
		boolean valid = true;
		if (checkers.lastElement().getColor()!=color) valid = false;
//		for (int i = 0;i<Game.getDiceToUse().size();i++) {
//			int value = Game.getDiceToUse().get(i).getValue();
//
//
//
//		}
//
//
//
		this.valid = valid;
		return valid;
	}
}
