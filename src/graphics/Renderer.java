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

	@Override
	public void paintComponent(Graphics g0) {
		g = (Graphics2D) g0;
		setBackground(COLOR_BACKGROUND);
		super.paintComponent(g);
		try {
			if (Game.board()==null) return;
			drawBoard();
//			drawDice();
			drawDebug();
		}
		catch (Exception e) {
			e.printStackTrace();
//			System.err.println(e.getMessage());
		}
	}

	private void drawBoard() {
		drawBars();
//		drawHighlights();
		drawGrid();
	}
//
//	private void drawHighlights() {
//		g.setStroke(new BasicStroke(5));
//		g.setColor(COLOR_HIGHLIGHT);
//		for (int i = 0;i<Game.board().getPoints().length;i++) {
//			Point point = Game.board().getPoints()[i];
//			int height = point.height();
//			if (Game.board().anyAreSelected()) {
//				if (point.isSelected()) {
//					drawChecker(i, height-1, false, "1");
//				}
//				else if (point.checkValid()) {
//					drawChecker(i, height, false, "2");
//				}
//			}
//			else {
//
//			}
////			if (!point.isEmpty()&&point.peekColor()!=EMPTY) {
////				if ((point.checkValid()&&!Game.board().anyAreSelected())||point.isSelected()) {
////					drawChecker(i, height-1, false);
//////					g.drawRect(MARGIN+i*CHECKER_SIZE, MARGIN+(height-1)*CHECKER_SIZE, CHECKER_SIZE, CHECKER_SIZE);
////				}
////				if (Game.board().anyAreSelected()&&point.checkValid()&&!point.isSelected()) {
////					drawChecker(i, height, false);
//////					g.drawRect(MARGIN+i*CHECKER_SIZE, MARGIN+(Game.board().getPoints()[i].getCheckers().size())*CHECKER_SIZE, CHECKER_SIZE, CHECKER_SIZE);
////				}
////			}
////			else {
////				if (Game.board().anyAreSelected()&&Game.board().anyCanMoveTo(point)) {
////					drawChecker(i, height, false);
//////					g.drawRect(MARGIN+i*CHECKER_SIZE, MARGIN+(Game.board().getPoints()[i].getCheckers().size())*CHECKER_SIZE, CHECKER_SIZE, CHECKER_SIZE);
////				}
////			}
//		}
//	}
//
	private void drawGrid() {
		g.setStroke(new BasicStroke(1));
		for (int i = 0;i<Game.board().size();i++) {//gird
			for (int j = 0;j<1||j<Game.board().get(i).size();j++) {
				g.setColor(COLOR_GRID);
				drawGridRect(i, j, false);
			}
		}
	}

	private void drawBars() {
		for (int i = 0;i<Game.board().size();i++) {
			for (int j = 0;j<Game.board().get(i).size();j++) {
				g.setColor(CHECKER_COLORS[Game.board().get(i).getColor()]);
//				if (Game.board().get(i).get(j).isHovered()) {
//					g.setColor(CHECKER_COLORS_H[Game.board().get(i).getColor()]);
//				}
				drawGridRect(i, j, true);
			}
		}
	}

	private void drawGridRect(int p, int h, boolean fill) {
		int xOffset = MARGIN, yOffset = MARGIN, vDir = 1;
		if (p>=Game.board().size()/2) {
			p = Game.board().size()-1-p;
			yOffset = Window.height()-MARGIN-GRID_SIZE_Y;
			vDir = -1;
		}
		if (p>=Game.board().size()/4&&p<Game.board().size()*3/4) xOffset+=BAR_WIDTH;
		if (fill) g.fillRect(p*GRID_SIZE_X+xOffset, h*vDir*GRID_SIZE_Y+yOffset, GRID_SIZE_X, GRID_SIZE_Y);
		g.drawRect(p*GRID_SIZE_X+xOffset, h*vDir*GRID_SIZE_Y+yOffset, GRID_SIZE_X, GRID_SIZE_Y);
	}

//	private void drawChecker(int point, int height, boolean fill, String str) {
//		g.setColor(Color.BLACK);
//		g.setFont(new Font("Helvetica", Font.PLAIN, 15));
//		g.drawString(str, point*CHECKER_SIZE+MARGIN+CHECKER_SIZE/2, -CHECKER_SIZE+MARGIN);
//		g.setColor(COLOR_HIGHLIGHT);
//		drawChecker(point, height, fill);
//	}
//
////	private void drawDice() {
////		for (int i = 0;i<Game.board().getDiceToUse().size();i++) {
////			drawDie(MARGIN+Game.board().getPoints().length*CHECKER_SIZE+MARGIN, (int) (MARGIN+CHECKER_SIZE*2.5*i), CHECKER_SIZE*2, Game.board().getDiceToUse().get(i).getValue(), Game.board().getDiceToUse().get(i).isBeingUsed());
////		}
////	}
//
//	private void drawDie(int x, int y, int size, int v, boolean beingUsed) {
//		final int dotSize = size/8;
//		if (beingUsed) g.setColor(COLOR_DIE_BACKROUND.darker());
//		else g.setColor(COLOR_DIE_BACKROUND);
//		g.fillRect(x, y, size, size);
//		g.setColor(COLOR_DIE_OUTLINE);
//		g.setStroke(new BasicStroke(1));
//		g.drawRect(x, y, size, size);
//		boolean[] dots = {v>2, false, v>0, v==5, v%2==0, v==5, v>0, false, v>2};
//		g.setColor(COLOR_DIE_DOTS);
//		for (int i = 0;i<3;i++) {
//			for (int j = 0;j<3;j++) {
//				if (dots[j*3+i]) g.fillRect((x+(size/4)*i+size/4)-dotSize/2, (y+(size/4)*j+size/4)-dotSize/2, dotSize, dotSize);
////				if (dots[j*3+i]) g.fillOval((x+(size/4)*i+size/4)-dotSize/2, (y+(size/4)*j+size/4)-dotSize/2, dotSize, dotSize);
//			}
//		}
//		g.drawString((v+1)+" ("+v+")", x-30, y+20);
//	}

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
