package course.i2cpx.edx;

import java.io.IOException;

public class PrepareYourselfToCompetitions extends FastIOTemplate {

	@Override
	public void solve() throws IOException {
		int n = input.nextInt();
		int p[] = new int[n], t[] = new int[n];
		for (int i = 0; i < n; i++)
			p[i] = input.nextInt();
		for (int i = 0; i < n; i++)
			t[i] = input.nextInt();
		int pDays = 0, tDays = 0, productivity = 0;

		for (int i = 0; i < n; i++) {
			if (p[i] > t[i]) {
				productivity += p[i];
				pDays++;
			} else {
				productivity += t[i];
				tDays++;
			}
		}
		int minDiff = Integer.MAX_VALUE;
		if (pDays == 0) {
			for (int i = 0; i < n; i++) {
				int curDiff = t[i] - p[i];
				if (curDiff < minDiff)
					minDiff = curDiff;
			}
			productivity = productivity - minDiff;
		} else if (tDays == 0) {
			for (int i = 0; i < n; i++) {
				int curDiff = p[i] - t[i];
				if (curDiff < minDiff)
					minDiff = curDiff;
			}
			productivity = productivity - minDiff;
		}
		output.println(productivity);
	}

	public static void main(String[] args) {
		new PrepareYourselfToCompetitions().run();
	}
}
