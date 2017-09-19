import java.util.Scanner;

public class Main {
    private static final String VOWELS = "auieo";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split("\\s");

        int cnt1 = 0, cnt2 = 0;
        for (String s : arr) {
            cnt1 += vowel(s);
            cnt2 += consonant(s);
        }

        System.out.println(cnt1 + "\n" + cnt2);
    }

    public static int vowel(String word) {
        for (int i = 0; i < word.length() - 1; i++) {
            if (VOWELS.contains(word.charAt(i) + "") 
                && VOWELS.contains(word.charAt(i + 1) + "")) {
                return 1; 
            }
        }
        return 0;
    }

    public static int consonant(String word) {
        String str = "auieo";
        for (int i = 0; i < word.length() - 2; i++) {
            if (!VOWELS.contains(word.charAt(i) + "")
                && !VOWELS.contains(word.charAt(i + 1) + "") 
                && !VOWELS.contains(word.charAt(i + 2) + "")) {
                return 1; 
            }
        }
        return 0;
    }

}
