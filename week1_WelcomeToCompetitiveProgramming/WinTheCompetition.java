package course.i2cpx.edx;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class WinTheCompetition {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(new File("input.txt"));
				PrintWriter output = new PrintWriter(new File("output.txt"))) {
			int n = input.nextInt();
			int[] jobDurations = new int[n];
			for (int i = 0; i < n; i++)
				jobDurations[i] = input.nextInt();
			Arrays.sort(jobDurations);
			int totalDuration = 0;
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (totalDuration + jobDurations[i] <= 18000) {
					totalDuration += jobDurations[i];
					count++;
				}
			}
			output.println(count);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
