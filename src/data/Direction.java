package data;

public enum Direction {
	NEG(-1), NONE(0), POS(1);

	public final int sign;

	private Direction(int sign) {
		this.sign = sign;
	}

	public static Direction getDirection(int sign) {
		sign = (int) Math.signum(sign);
		if (sign==POS.sign) return POS;
		if (sign==NEG.sign) return NEG;
		return NONE;
	}

	public static Direction getDirection(int from, int to) {
		return getDirection(to-from);
	}
}
//
//class Test {
//	public static void main(String[] args) {
//		System.out.println(Direction.getDirection(4, 6));
//		System.out.println(Direction.getDirection(4, 2));
//		System.out.println(Direction.getDirection(4, 4));
//	}
//}