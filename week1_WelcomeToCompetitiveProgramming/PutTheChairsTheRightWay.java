package course.i2cpx.edx;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PutTheChairsTheRightWay {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(new File("input.txt"));
				PrintWriter output = new PrintWriter(new File("output.txt"))) {
			int side1, side2, side3;
			side1 = input.nextInt();
			side2 = input.nextInt();
			side3 = input.nextInt();
			double averageDistance = (side1 + side2 + side3) / 6.0;
			output.println(averageDistance);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
