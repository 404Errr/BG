package input;

import java.util.Scanner;

public class ConsoleInput {
	private static Scanner scan = new Scanner(System.in);

	public static String next() {
		return scan.nextLine();
	}
}
