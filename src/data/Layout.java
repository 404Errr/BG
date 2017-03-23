package data;

import java.util.ArrayList;
import java.util.List;

import board.Checker;
import board.Point;

public interface Layout extends GameData {
	int[][] LAYOUT_0 = {
			{2, A},
			{4},
			{5, B},
			{1},
			{3, B},
			{3},
			{5, A},
			{5, B},
			{3},
			{3, A},
			{1},
			{5, A},
			{4},
			{2, B},
	};

	class CreateLayout {
		public static List<Point<Checker>> getPoints(int[][] layout) {
			List<int[]> pointData = new ArrayList<>();
			int currentPointNum = 0;
			for (int i = 0;i<layout.length;i++) {
				if (layout[i].length==1) {
					for (int j = 0;j<layout[i][0];j++) {
						pointData.add(new int[] {currentPointNum+j, 0, EMPTY});
					}
					currentPointNum+=layout[i][0];
				}
				else {
					pointData.add(new int[] {currentPointNum, layout[i][0], layout[i][1]});
					currentPointNum++;
				}
			}
			System.out.println(pointData.size());
			List<Point<Checker>> points = new ArrayList<>();
			for (int i = 0;i<pointData.size();i++) {
				int[] data = pointData.get(i);
				points.add(new Point<>(data[0], data[1], data[2]));
			}
			for (int i = 0;i<pointData.size();i++) {
				Point<Checker> left = null, right = null;
				if (i>0) left = points.get(i-1);
				if (i<pointData.size()-1) right = points.get(i+1);
				points.get(i).setNeighbors(left, right);
			}
			for (Point<Checker> p:points) System.out.println(p);
			return points;
		}
	}
}
