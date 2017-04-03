package data;

import java.util.ArrayList;
import java.util.List;

import board.Checker;
import board.Point;

public interface Layout extends GameData {
	int E = EMPTY;
	int[][] NORM = {{2, A}, {0, E}, {0, E}, {0, E}, {0, E}, {5, B}, {0, E}, {3, B}, {0, E}, {0, E}, {0, E}, {5, A}, {5, B}, {0, E}, {0, E}, {0, E}, {3, A}, {0, E}, {5, A}, {0, E}, {0, E}, {0, E}, {0, E}, {2, B}};
	int[][] NABK = {{2, A}, {2, A}, {0, E}, {0, E}, {0, E}, {4, B}, {0, E}, {3, B}, {0, E}, {0, E}, {0, E}, {4, A}, {4, B}, {0, E}, {0, E}, {0, E}, {3, A}, {0, E}, {4, A}, {0, E}, {0, E}, {0, E}, {2, B}, {2, B}};

	class CreateLayout {
		public static List<Point<Checker>> createPoints(int[][] layout) {
			List<Point<Checker>> points = new ArrayList<>();
			for (int i = 0;i<layout.length;i++) {
				if (layout[i][1]==EMPTY) layout[i][0] = 0;//Safety
				points.add(new Point<>(i, layout[i][0], layout[i][1]));
			}
			for (Point<Checker> p:points) System.out.println(p);
			return points;
		}
	}
}



