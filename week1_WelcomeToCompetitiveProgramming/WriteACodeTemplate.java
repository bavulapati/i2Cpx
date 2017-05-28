package course.i2cpx.edx;

import java.util.HashMap;

public class WriteACodeTemplate extends FastIOTemplate {

	class CharPosition {
		int x, y;

		public CharPosition(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	String chars;
	int i;
	HashMap<Integer, CharPosition> alphabet = new HashMap<>();

	public static void main(String[] args) {
		new WriteACodeTemplate().run();
	}

	int nextChar() {
		if (chars == null || i == chars.length()) {
			chars = input.next();
			i = 0;
			if (chars.equals("%TEMPLATE-START%")) {
				chars = null;
				return nextChar();
			} else if (chars.equals("%TEMPLATE-END%")) {
				chars = null;
				return -1;
			}
		}
		return chars.charAt(i++);
	}

	@Override
	void solve() {
		int w = input.nextInt();
		int h = input.nextInt();
		for (int i = h; i > 0; i--)
			for (int j = 1; j <= w; j++)
				alphabet.put(nextChar(), new CharPosition(i, j));
		String bestLanguage = null, currentLanguage;
		int bestTime = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			currentLanguage = input.next();
			if (bestLanguage == null)
				bestLanguage = currentLanguage;
			int startChar = nextChar(), nextChar, totalTime = 0;
			if (startChar != -1)
				while ((nextChar = nextChar()) != -1) {
					int currentTime = distance(startChar, nextChar);
					totalTime += currentTime;
					startChar = nextChar;
				}
			if (bestTime > totalTime) {
				bestTime = totalTime;
				bestLanguage = currentLanguage;
			}
		}
		output.println(bestLanguage);
		output.println(bestTime);
	}

	private int distance(int startChar, int nextChar) {
		CharPosition startPosition = alphabet.get(startChar);
		CharPosition endPosition = alphabet.get(nextChar);
		return Math.max(Math.abs(startPosition.x - endPosition.x), Math.abs(startPosition.y - endPosition.y));
	}

}
