package course.i2cpx.edx;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public abstract class FastIOTemplate implements Closeable {
	FastScanner input;
	PrintWriter output;

	abstract void solve() throws NumberFormatException, IOException;

	void run() throws NumberFormatException, IOException {
		input = new FastScanner(new File("input.txt"));
		output = new PrintWriter(new File("output.txt"));
		solve();
	}

	class FastScanner implements Closeable {
		BufferedReader bufferedReader;
		StringTokenizer stringTokenizer;

		FastScanner(File inputFile) throws FileNotFoundException {
			bufferedReader = new BufferedReader(new FileReader(inputFile));

		}

		String next() throws IOException {
			while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
				String line = bufferedReader.readLine();
				if (line == null)
					return null;
				stringTokenizer = new StringTokenizer(line);
			}
			return stringTokenizer.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		@Override
		public void close() throws IOException {
			bufferedReader.close();
			stringTokenizer = null;
		}
	}

	@Override
	public void close() throws IOException {
		input.close();
		output.close();
	}
}
