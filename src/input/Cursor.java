package input;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import data.GraphicsData;
import data.InputData;
import game.Game;
import graphics.Window;

public class Cursor implements InputData, GraphicsData {
	private static int screenX, screenY;//the coords of the cursor based on the top left corner of the screen

	public static void updateMouse(MouseEvent e) {
		e = SwingUtilities.convertMouseEvent(Window.getFrame(), e, Window.getRendererer());
		screenX = e.getX();
		screenY = e.getY();
	}

	public static void click(MouseEvent e, boolean down) {
		if (down) {
			switch (e.getButton()) {
			case MouseEvent.BUTTON1://left
				for (int p = 0;p<Game.board().size();p++) {
					for (int h = 0;h<Game.board().get(p).size()+1;h++) {
						if (Game.getGridBounds(p, h).contains(screenX, screenY)) {
							Game.board().get(p).clicked();
							break;
						}
					}
				}
				break;
			case MouseEvent.BUTTON2://middle

				break;
			case MouseEvent.BUTTON3://right

				break;
			}
		}
//		e = SwingUtilities.convertMouseEvent(Window.getFrame(), e, Window.getRendererer());
//		switch (e.getButton()) {
//		case MouseEvent.BUTTON1://left
//			for (Point point:Game.board().getPoints()) {
//				if (!point.isEmpty()&&point.getBounds().contains(e.getX(), e.getY())) {
//					point.click();
//				}
//			}
//			break;
//		case MouseEvent.BUTTON2://middle
//
//			break;
//		case MouseEvent.BUTTON3://right
//
//			break;
//		}
	}

	public static int getScreenX() {//relative to screen 0, 0
		return screenX;
	}

	public static int getScreenY() {
		return screenY;
	}
}