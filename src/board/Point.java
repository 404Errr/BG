package board;

import java.awt.geom.Rectangle2D;
import java.util.Stack;

import data.GameData;
import data.GraphicsData;
import game.Game;
import graphics.Window;

public class Point implements GameData, GraphicsData {
	private final int pointNum;
	private Stack<Checker> checkers;
	private boolean selected, valid;

	public Point(int slotNum) {
		this(slotNum, EMPTY, 0);
	}

	public Point(int pointNum, int color, int checkerCount) {
		System.out.println(pointNum);
		this.pointNum = pointNum;
		checkers = new Stack<>();
		for (int i = 0;i<checkerCount;i++) {
			checkers.push(new Checker(color));
		}
	}

	public void tick() {
		for (int i = 0;i<checkers.size();i++) {
			checkers.get(i).setPoint(this);
			checkers.get(i).tick();
		}
		System.out.println(pointNum+"\t"+selected);
	}

	public void init(Board board) {
		for (int i = 0;i<checkers.size();i++) {
			board.addChecker(checkers.get(i));
		}
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
		if (checker!=null) checkers.push(checker);
	}

	public int height() {
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

	public void click() {
		if (isSelected()) {
			setSelected(false);
			return;
		}
		if (checkValid()) {
			Game.board().deselectAll();
			setSelected(true);
		}
	}

	public Rectangle2D getBounds() {
		return new Rectangle2D.Float(Window.getOriginX()+CHECKER_SIZE*getPointNum(), Window.getOriginY(), CHECKER_SIZE, (checkers.size()+((Game.board().anyAreSelected()&&!selected)?1:0))*CHECKER_SIZE);
	}

	public boolean checkValid() {
		boolean valid = true;
		if (checkers.size()>0&&checkers.peek().getColor()!=Game.board().getTurn()) {
			valid = false;
		}

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
