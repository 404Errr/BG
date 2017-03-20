package board;

import java.awt.geom.Rectangle2D;

import data.InputData;
import input.Cursor;

public class Checker implements InputData {
	private final int color;
	private Point point;
	private boolean hovered;

	public Checker(int color) {
		this.color = color;
	}

	public void tick() {
		hovered = getBounds().contains(Cursor.getBoardX(), Cursor.getBoardY());
	}

	public Rectangle2D getBounds() {f//FIXME
		return new Rectangle2D.Float(ORIGIN_X+CHECKER_SIZE*point.getPointNum(), ORIGIN_Y+CHECKER_SIZE*point.getCheckers().indexOf(this), CHECKER_SIZE, CHECKER_SIZE);
	}

	public boolean isHovered() {
		return hovered;
	}

	public int getColor() {
		return color;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Point getPoint() {
		return point;
	}
}
