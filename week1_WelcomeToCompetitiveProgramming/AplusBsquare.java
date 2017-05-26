package course.i2cpx.edx;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class AplusBsquare {

	
	public static void main(String[] args) {
		try(Scanner input = new Scanner(new File("input.txt"));
				Writer output = new FileWriter(new File("output.txt"))) {
			long a = input.nextLong();
			long b = input.nextLong();
			output.write(""+(a+b*b));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
