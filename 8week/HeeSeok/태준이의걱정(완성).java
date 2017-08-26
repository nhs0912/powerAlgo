import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 코드그라운드
 * "태준이의 걱정"
 */

class Solution {
    //static int Answer;

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = sc.nextInt();
        //sc.nextLine();
        //StringTokenizer st;
        int count;
        int moveToSchool ;//1분동안 학교 방향으로 이동하는 거리
        int MoveToHome ;// 걱정을 하며 집 방향으로 이동하는 거리
        int HomeToSchoolDistance ;//집에서 학교까지 거리
        int start;
        for (int test_case = 0; test_case < T; test_case++) {
            count = 1;
            moveToSchool = sc.nextInt(); //1분동안 학교 방향으로 이동하는 거리
            MoveToHome = sc.nextInt();// 걱정을 하며 집 방향으로 이동하는 거리
            HomeToSchoolDistance = sc.nextInt();//집에서 학교까지 거리
            start = moveToSchool;
            int stepDist = moveToSchool-MoveToHome;
            while (start < HomeToSchoolDistance) {
                start += stepDist;
                count++;
                if (start>HomeToSchoolDistance) {
                    break;
                }

            }
            System.out.println("Case #" + (test_case + 1));
            System.out.println(count);
        }

    }
}
