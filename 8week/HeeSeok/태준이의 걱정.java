
import java.io.*;
import java.util.Scanner;


import java.util.StringTokenizer;

/**
 * 코드그라운드
 * "태준이의 걱정"
 */
/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution {
    //static int Answer;

    public static void main(String args[]) throws Exception {

        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = sc.nextInt();
        sc.nextLine();
        StringTokenizer st;
        long count;
        long A;//1분동안 학교 방향으로 이동하는 거리
        long B;// 걱정을 하며 집 방향으로 이동하는 거리
        long D;//집에서 학교까지 거리
        long start;
        for (int test_case = 0; test_case < T; test_case++) {

            st = new StringTokenizer(sc.nextLine());
            count = 0;
            A = Long.parseLong(st.nextToken()); //1분동안 학교 방향으로 이동하는 거리
            B = Long.parseLong(st.nextToken());// 걱정을 하며 집 방향으로 이동하는 거리
            D = Long.parseLong(st.nextToken());//집에서 학교까지 거리
            start = 0;
            while (start <= D) {
                start += A;
                if (D <= start) {
                    break;
                }
                D += B;
                count++;
            }
            //System.out.println("Case #" + (test_case + 1));
            //System.out.println(count + 1);

            bw.write("Case #" + (test_case + 1) + "\n");
            bw.write(count + 1 + "\n");
        }
        bw.close();
    }
}
