package input;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import graphics.Window;

public class Cursor {
	private static int screenX, screenY;//the coords of the cursor based on the top left corner of the screen

	public static void updateMouse(MouseEvent e) {
		e = SwingUtilities.convertMouseEvent(Window.getFrame(), e, Window.getRendererer());
		screenX = e.getX();
		screenY = e.getY();
	}

	public static int getScreenX() {//relative to screen 0, 0
		return screenX;
	}

	public static int getScreenY() {
		return screenY;
	}
}