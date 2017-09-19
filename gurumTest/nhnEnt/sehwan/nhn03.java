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
        boolean prev = false; 
        for (int i = 0; i < word.length(); i++) {
            if (VOWELS.contains(word.charAt(i) + "")) {
                if(prev) 
                    return 1; 
                else 
                    prev = true; 
            } else {
                prev = false; 
            }
        }
        return 0;
    }

    public static int consonant(String word) {
        boolean prevOne = false, prevTwo = false; 
        for (int i = 0; i < word.length(); i++) {
            if (!VOWELS.contains(word.charAt(i) + "")) {
                if(prevOne) {
                    if(prevTwo) {
                        return 1; 
                    } else {
                        prevTwo = true; 
                    }
                } else { 
                    prevOne = true; 
                } 
            } else {
                prevOne = false;
                prevTwo = false;
            }
        }
        return 0;
    }

}
