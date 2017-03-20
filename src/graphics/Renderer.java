package graphics;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import data.ColorData;
import data.GameData;
import data.GraphicsData;
import game.Game;

@SuppressWarnings("serial")
public class Renderer extends JPanel implements ColorData, GameData, GraphicsData {
	private static Graphics2D g;
	int MARGIN = GraphicsData.MARGIN, CHECKER_SIZE = GraphicsData.CHECKER_SIZE;

	@Override
	public void paintComponent(Graphics g0) {
		g = (Graphics2D) g0;
		setBackground(COLOR_BACKGROUND);
		super.paintComponent(g);
		try {
			drawBoard();
			drawDice();
			drawDebug();
		}
		catch (Exception e) {
			e.printStackTrace();
//			System.err.println(e.getMessage());
		}
	}

	private void drawBoard() {
		for (int i = 0;i<Game.board().getPoints().length;i++) {
			for (int j = 0;j<Game.board().getPoints()[i].getCheckers().size();j++) {
				g.setColor(STONE_COLORS[Game.board().getPoints()[i].getCheckers().get(j).getColor()]);
				g.fillRect(i*CHECKER_SIZE+MARGIN, j*CHECKER_SIZE+MARGIN, CHECKER_SIZE, CHECKER_SIZE);//Game.getBoard().getPoints()[i].getStoneCount()*CHECKER_SIZE);
			}
		}
		g.setStroke(new BasicStroke(5));
		for (int i = 0;i<Game.board().getPoints().length;i++) {//highlight
			if (Game.board().getPoints()[i].getCheckers().size()>0&&Game.board().getPoints()[i].getCheckers().peek().getColor()!=EMPTY&&Game.board().getPoints()[i].isValid(Game.getTurn())) {
				g.setColor(COLOR_HIGHLIGHT);
				g.drawRect(i*CHECKER_SIZE+MARGIN, MARGIN+(Game.board().getPoints()[i].getCheckers().size()-1)*CHECKER_SIZE, CHECKER_SIZE, CHECKER_SIZE);
			}
		}
		g.setStroke(new BasicStroke(1));
		for (int i = 0;i<Game.board().getPoints().length;i++) {//gird
			for (int j = 0;j<1||j<Game.board().getPoints()[i].getCheckers().size();j++) {
				g.setColor(COLOR_GRID);
				g.drawRect(i*CHECKER_SIZE+MARGIN, j*CHECKER_SIZE+MARGIN, CHECKER_SIZE, CHECKER_SIZE);
			}
		}
	}

	private void drawDice() {
		for (int i = 0;i<Game.getDiceToUse().size();i++) {
			drawDie(MARGIN+Game.board().getPoints().length*CHECKER_SIZE+MARGIN, (int) (MARGIN+CHECKER_SIZE*2.5*i), CHECKER_SIZE*2, Game.getDiceToUse().get(i).getValue(), Game.getDiceToUse().get(i).isBeingUsed());
		}
	}

	private void drawDie(int x, int y, int size, int v, boolean beingUsed) {
		final int dotSize = size/8;
		if (beingUsed) g.setColor(COLOR_DIE_BACKROUND.darker());
		else g.setColor(COLOR_DIE_BACKROUND);
		g.fillRect(x, y, size, size);
		g.setColor(COLOR_DIE_OUTLINE);
		g.setStroke(new BasicStroke(1));
		g.drawRect(x, y, size, size);
		boolean[] dots = {v>2, false, v>0, v==5, v%2==0, v==5, v>0, false, v>2};
		g.setColor(COLOR_DIE_DOTS);
		for (int i = 0;i<3;i++) {
			for (int j = 0;j<3;j++) {
				if (dots[j*3+i]) g.fillRect((x+(size/4)*i+size/4)-dotSize/2, (y+(size/4)*j+size/4)-dotSize/2, dotSize, dotSize);
//				if (dots[j*3+i]) g.fillOval((x+(size/4)*i+size/4)-dotSize/2, (y+(size/4)*j+size/4)-dotSize/2, dotSize, dotSize);
			}
		}
		g.drawString((v+1)+" ("+v+")", x-30, y+20);
	}

	private final static int textX = 25, textY = 30, textSize = 15;
	private void drawDebug() {
		StringBuilder text = new StringBuilder();

		text.append("Window = "+Window.width()+"x"+Window.height());

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
