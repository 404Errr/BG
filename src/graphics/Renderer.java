package graphics;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import data.ColorData;
import data.GameData;
import data.GraphicsData;

@SuppressWarnings("serial")
public class Renderer extends JPanel implements ColorData, GameData, GraphicsData {
	private static Graphics2D g;

	@Override
	public void paintComponent(Graphics g0) {
		g = (Graphics2D) g0;
		setBackground(COLOR_BACKGROUND);
		super.paintComponent(g);
		try {
			drawDebug();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private final static int textX = 25, textY = 30, textSize = 15;
	private void drawDebug() {
		StringBuilder text = new StringBuilder();

		//				text.append("Window = "+Window.width()+"x"+Window.height()+" Map = "+Level.getWidth()+"x"+Level.getHeight()+" Scale = "+Camera.getScale()+"$");
		//				text.append("Zoomed = "+Camera.isZoomed()+"$");
		//				text.append("Render Distance = "+GraphicsData.getRenderDistanceX()+", "+GraphicsData.getRenderDistanceY()+"$");
		//				text.append("X, Y Tile = "+Game.getPlayer().getXTile()+", "+Game.getPlayer().getYTile()+"$");
		//				text.append("X, Y Exact = ("+Game.getPlayer().getX()+", "+Game.getPlayer().getY()+")"+"$");
		//				text.append("velocity (m/s) = "+Math.hypot(Game.getPlayer().getdX(), Game.getPlayer().getdY())*GameData.UPS+"$");
		//				text.append("dx, dy = "+Game.getPlayer().getdX()+", "+Game.getPlayer().getdY()+"$");
		//				text.append("ddx, ddy = "+Game.getPlayer().getddX()+", "+Game.getPlayer().getddY()+"$");
		//				text.append("Facing = "+((float)Math.toDegrees(Game.getPlayer().getFacing())+((Game.getPlayer().getFacing()<0)?360:0))+" ("+Game.getPlayer().getFacing()+")"+"$");
		//				text.append("Cursor = "+Cursor.getScreenX()+","+Cursor.getScreenY()+" ("+Cursor.getPlayerX()+","+Cursor.getPlayerY()+")"+"$");
		//				text.append("Active Weapon = "+Game.getPlayer().getActiveWeapon()+"$");
		////				text.append("Cooldown = "+Game.getPlayer().getActiveWeapon().getCooldown()+"$");
		////				text.append("To be fired = "+Game.getPlayer().getActiveWeapon().getToBeFired()+"$");
		//				text.append("Debug Text = true, LOS Line = "+Debug.isLosLine()+"$");
		//				if (Edit.editMode) text.append("Type = "+(char)Edit.getType());

		String[] textLines = text.toString().split("\\$");
		g.setColor(COLOR_DEBUG_GREEN);
		g.setFont(new Font("Helvetica", Font.BOLD, textSize));
		for (int i = 0;i<textLines.length;i++) {
			g.drawString(textLines[i], textX, textY+textSize*i);
		}
	}


	public static Graphics2D getG() {
		return g;
	}
}
