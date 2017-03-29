package player;

import board.Checker;
import board.Point;

public class HumanPlayer extends Player {
	private Point<Checker> selectedPoint;

	public HumanPlayer(int color) {
		super(color);
	}

	public Point<Checker> getSelectedPoint() {
		return selectedPoint;
	}

	public void setSelectedPoint(Point<Checker> selectedPoint) {
		this.selectedPoint = selectedPoint;
		System.out.println("selected:\t"+this.selectedPoint);
	}

}
