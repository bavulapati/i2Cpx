package course.i2cpx.edx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public abstract class FastIOTemplate {
	FastScanner input;
	PrintWriter output;

	public abstract void solve() throws IOException;

	public void run() {
		input = new FastScanner(new File("input.txt"));
		try {
			output = new PrintWriter(new File("output.txt"));
			solve();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	class FastScanner {
		BufferedReader bufferedReader;
		StringTokenizer stringTokenizer;

		FastScanner(File inputFile) {
			try {
				bufferedReader = new BufferedReader(new FileReader(inputFile));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		String next() {
			if (stringTokenizer == null || !stringTokenizer.hasMoreTokens())
				try {
					stringTokenizer = new StringTokenizer(
							bufferedReader.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return stringTokenizer.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}

}
