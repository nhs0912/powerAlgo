import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {
    static int findNumberMaxSize(int num) {
        //자릿수 구하기
        int cnt = 0;
        while (num != 0) {
            num /= 10;
            cnt++;
        }
        return cnt;

    }

    static int reverse(int num) {
        int size = findNumberMaxSize(num);
        int[] saveNum = new int[size];
        int remind = 0;
        int index = 0;
        int sum = 0;
        while (num != 0) {
            remind = num % 10;
            num = num / 10;
            for (int i = 0; i < saveNum.length; i++) {
                saveNum[i] *= 10;
            }
            saveNum[index++] = remind;
        }

        for (int i = 0; i < saveNum.length; i++) {
            sum += saveNum[i];
          //  System.out.println(saveNum[i]);
        }

        return sum;
    }

    static boolean isPalindrome(int num) {
        //팰린드롬인지 확인
        String textNum = String.valueOf(num);
        int end =textNum.length()-1;
        for (int i = 0; i < textNum.length(); i++) {

            if (textNum.charAt(i) != textNum.charAt(end - i)) {
                //다른 것이 있다면
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        //FileInputStream fis = new FileInputStream("test.txt");
        //BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int cnt = 3;//3번만 하기 위한 숫자
        boolean checkPalindrome = false;
        while (cnt-- > 0) {
            //1. 숫자를 뒤집는다.
            int reverseNum = reverse(num);
            //2. 뒤집어진 숫자를 기존 숫자와 더한다.
            num += reverseNum;
            //3. 더한 값을 펠린드롬 확인 후 펠린드롬이면 출력, 아니면 다시 1번 과정(3번까지 실행한다.)
            checkPalindrome = isPalindrome(num);
            if (checkPalindrome) {
                System.out.println(num);
                break;
            }

        }
        //4. 더이상 펠린드롬이 나오지 않았다면 -1을 출력한다.
        if (!checkPalindrome) {
            System.out.println(-1);
        }

    }
}
