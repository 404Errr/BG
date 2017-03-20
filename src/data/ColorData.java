package data;

import java.awt.Color;

import util.Util;

public interface ColorData {
	Color COLOR_DEBUG_GREEN = new Color(0x00b400);//darker than lime
	Color COLOR_DEBUG_BLUE = new Color(0x0000C1);//blue
	Color COLOR_ERROR = new Color(0x940e94);//magenta
	Color COLOR_BACKGROUND = new Color(0xf0f0f0);//background color

	Color COLOR_GRID = Util.colorOpacity(new Color(0x000000), 0.8f);

	Color COLOR_HIGHLIGHT = new Color(0x02fc02);

	Color COLOR_DIE_BACKROUND = new Color(0xffffff);
	Color COLOR_DIE_OUTLINE = new Color(0x000000);
	Color COLOR_DIE_DOTS = new Color(0x000000);

	Color COLOR_A = new Color(0xa0a0a0);
	Color COLOR_A_H = new Color(0xd0d0d0);
	Color COLOR_B = new Color(0x0000ff);
	Color COLOR_B_H = new Color(0x5050ff);
	Color[] CHECKER_COLORS = {COLOR_A, COLOR_B};
	Color[] CHECKER_COLORS_H = {COLOR_A_H, COLOR_B_H};
}
