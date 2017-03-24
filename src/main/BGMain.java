package main;

import game.Game;
import graphics.Window;

public class BGMain {
	public static void main(String[] args) {
		Game.init();
		Window.init();
		UpdateLoop.run();
	}
}
