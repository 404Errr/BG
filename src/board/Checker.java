package board;

import data.GraphicsData;

public class Checker implements GraphicsData {
	private final int color;
//	private Point<?> point;
//	private boolean hovered;

	public Checker(int color) {
		this.color = color;
	}

//	public void tick() {
//		hovered = new Rectangle2D.Float(Window.getOriginX()+CHECKER_SIZE*point.getPointNum(), Window.getOriginY()+CHECKER_SIZE*point.getCheckers().indexOf(this), CHECKER_SIZE, CHECKER_SIZE).contains(Cursor.getScreenX(), Cursor.getScreenY());
//	}
//
//	public boolean isHovered() {
//		return hovered;
//	}

	public int getColor() {
		return color;
	}

//	public Point<?> getPoint() {
//		return point;
//	}
}
