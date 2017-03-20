package board;

import java.awt.geom.Rectangle2D;

import data.GraphicsData;
import data.InputData;
import graphics.Window;
import input.Cursor;

public class Checker implements GraphicsData {
	private final int color;
	private Point point;
	private boolean hovered;

	public Checker(int color) {
		this.color = color;
	}

	public void tick() {
		hovered = getBounds().contains(Cursor.getBoardX(), Cursor.getBoardY());
	}
e
	public Rectangle2D getBounds() {//FIXME
//		System.out.println(Window.getOriginX()+"\t"+Window.getOriginY());
		return new Rectangle2D.Float(Window.getOriginX()+CHECKER_SIZE*point.getPointNum(), Window.getOriginY()+CHECKER_SIZE*point.getCheckers().indexOf(this), CHECKER_SIZE, CHECKER_SIZE);
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
