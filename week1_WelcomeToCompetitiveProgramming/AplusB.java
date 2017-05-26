package course.i2cpx.edx;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class AplusB {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(new File("input.txt"));
				Writer output = new FileWriter(new File("output.txt"))) {
			int a = input.nextInt();
			int b = input.nextInt();
			output.write("" + (a + b));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
