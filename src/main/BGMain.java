package main;

import data.GameData;
import game.Game;
import graphics.Window;

public class BGMain implements GameData {
	public static void main(String[] args) {
		Game.init();
		Window.init();
		UpdateLoop.run();

	}
}
