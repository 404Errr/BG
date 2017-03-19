package main;

import game.Game;
import graphics.Window;

public class BGMain {
	public static void main(String[] args) {
		Window.init();
		Game.init();
		UpdateLoop.run();
	}
}
