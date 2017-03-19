package main;

import data.GameData;
import graphics.Window;

public class UpdateLoop implements GameData {

	public static void run() {
		System.out.println("UPS: "+UPS);
		final float updateSpeed = 1000000000/UPS;
		float wait;
		long startTime = 0;
		while (true) {
			startTime = System.nanoTime();

			update();//update
			Window.getRendererer().repaint();//repaint the screen

			wait = (updateSpeed-(System.nanoTime()-startTime))/1000000;
			if (wait>=1) try {
				Thread.sleep((long)wait);
			}
			catch (Exception e) {}
		}
	}

	private static void update() {
		try {

		}
		catch (Exception e) {
			System.err.println("-UPDATE ERROR");
			e.printStackTrace();
		}
	}


}
