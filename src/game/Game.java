package game;

import java.awt.geom.Rectangle2D;
import java.util.Stack;

import board.Board;
import data.GameData;
import data.GraphicsData;
import graphics.Window;

public class Game implements GameData, GraphicsData {
	private static Stack<Board> boardHistory;

	public static Board board() {
		if (!boardHistory.isEmpty()) return boardHistory.peek();
		return null;
	}

	public static void init() {
		boardHistory = new Stack<>();
		boardHistory.push(new Board(LAYOUT));
	}

	public static Rectangle2D getGridBounds(int p, int h) {
		int xOffset = MARGIN, yOffset = MARGIN, vDir = 1;
		if (p>=Game.board().size()/2) {
			p = Game.board().size()-1-p;
			yOffset = Window.height()-MARGIN-GRID_SIZE_Y;
			vDir = -1;
		}
		if (p>=Game.board().size()/4&&p<Game.board().size()*3/4) xOffset+=BAR_WIDTH;
		return new Rectangle2D.Float(p*GRID_SIZE_X+xOffset, h*vDir*GRID_SIZE_Y+yOffset, GRID_SIZE_X, GRID_SIZE_Y);
	}

//	public static void save() {
//		System.out.println("saved");
//		boardHistory.push(board().copy());
//	}
//
//	public static void load() {
//		System.out.println("loaded");
//		boardHistory.pop();
//	}

}
