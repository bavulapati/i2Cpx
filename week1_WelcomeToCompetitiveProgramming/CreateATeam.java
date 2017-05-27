package course.i2cpx.edx;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CreateATeam {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(new File("input.txt"));
				PrintWriter output = new PrintWriter(new File("output.txt"))) {
			int andrew[] = new int[3], peter[] = new int[3], paul[] = new int[3];
			double maxEfficiency = 0;
			for (int i = 0; i < 3; i++)
				andrew[i] = input.nextInt();
			for (int i = 0; i < 3; i++)
				peter[i] = input.nextInt();
			for (int i = 0; i < 3; i++)
				paul[i] = input.nextInt();
			for (int i = 0; i < 3; i++) {
				int andrewContribution = andrew[i];
				for (int k = 0, j = (i + 1) % 3; k < 2; j = (j + 1) % 3, k++) {
					int peterContribution = peter[j];
					int paulContribution = paul[3 - i - j];
					double currentEfficiency = Math.sqrt(andrewContribution * andrewContribution
							+ peterContribution * peterContribution + paulContribution * paulContribution);
					if (maxEfficiency < currentEfficiency)
						maxEfficiency = currentEfficiency;
				}
			}
			output.println(maxEfficiency);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
