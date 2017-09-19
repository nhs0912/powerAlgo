import java.io.*;
import java.util.StringTokenizer;


class Main {


    static char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};// 모음

    static boolean isCheckOneRule(String str) {
        //모음이 연속 2번 나올때
        int vowelCnt = 0; //모음 갯수
        for (int i = 0; i < str.length(); i++) {
            boolean vowel = false;
            for (int j = 0; j < vowels.length; j++) {
                if (str.charAt(i) == vowels[j]) {
                    //모음이 있다면
                    vowel = true;
                    break;
                }
            }

            if (vowel) {
                //모음이라면 1 증가
                vowelCnt++;
            } else {
                //자음이라면 0으로 초기화
                vowelCnt = 0;
            }

            if (vowelCnt == 2) {
                return true;
            }

        }
        return false;
    }

    static boolean isCheckTwoRule(String str) {
        //자음 알파벳이 연속 3번 나올때
        int consonantCnt = 0;//모음 갯수
        for (int i = 0; i < str.length(); i++) {
            //모음 검사
            boolean vowel = false;//모음
            for (int j = 0; j < vowels.length; j++) {
                if (vowels[j] == str.charAt(i)) {
                    vowel = true;//모음 확인
                    break;
                }
            }

            if (!vowel) {//자음일 때 1 증가
                consonantCnt++;
            } else {//모음을 만나면 0으로 초기화
                consonantCnt = 0;
            }
            if (consonantCnt == 3) {
                //3개 연속 있다면 true 반환
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("test.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int oneCnt = 0;// 1번규칙에 만족하는 갯수
        int twoCnt = 0;// 2번규칙에 만족하는 갯수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = st.countTokens();//단어 갯수
        String[] words = new String[n];
        int index = 0;
        while (st.hasMoreTokens()) {
            words[index++] = st.nextToken();
        }

        for (String word : words) {
            if (isCheckOneRule(word)) {//첫번째 규칙이 성립할때
                oneCnt++;
            }
            if (isCheckTwoRule(word)) {//두번째 규칙이 성립할때
                twoCnt++;
            }
        }
        System.out.println(oneCnt + "\n" + twoCnt);
    }
}
