package nhn;

import java.util.Scanner;

public class 단어찾아내기 {
	public static void main(String[] args) {
		// toast standard bank display book
		// rookie image plastic mouse project feature apple
		// fourier linearly wallet algorithm outdoor
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] arr = str.split("\\s");

		int cnt1 = 0, cnt2 = 0;
		for (String s : arr) {
			cnt1 += vowel(s);
			cnt2 += consonant(s);
		}

		System.out.println(cnt1 + "\n" + cnt2);
	}

	public static int vowel(String word) {
		String str = "auieo";
		for (int i = 0; i < word.length() - 1; i++) {
			CharSequence c = word.substring(i, i + 1);
			if (str.contains(c)) {
				if (str.contains(word.substring(i + 1, i + 2))) {
					return 1;
				}
			}

		return 0;
	}

	public static int consonant(String word) {
		String str = "auieo";
		for (int i = 0; i < word.length() - 2; i++) {
			CharSequence c = word.substring(i, i + 1);
			if (!str.contains(c)) {
				if (!str.contains(word.substring(i + 1, i + 2))) {
					if (!str.contains(word.substring(i + 2, i + 3))) {
						return 1;
					}
				}
			}
		}
		return 0;
	}

}
