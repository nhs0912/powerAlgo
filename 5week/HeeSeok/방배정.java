package Problems;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호 : 13300
 * 문제 이름 : 방 배정
 * 문제 주소 : https://www.acmicpc.net/problem/13300
 */


class P_13300 {

    public void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    int[][] data;//학생정보
    int roomCnt = 0;//방 갯수
    int K;

    public void inputData() throws IOException {
        FileInputStream fis = new FileInputStream("test.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());//학생 수
        K = Integer.parseInt(st.nextToken());//수용 인원
        data = new int[2][7];
        int index = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());//성별
            int grade = Integer.parseInt(st.nextToken());//학년
            data[gender][grade]++;
        }
        // printArr(data);

    }

    public void CalculateRoomCnt() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data[i].length; j++) {
                int studentCnt = data[i][j];
                if (studentCnt > 0) {
                    if (studentCnt % K != 0) {
                        roomCnt += (studentCnt / K) + 1;
                    } else {
                        roomCnt += studentCnt / K;
                    }
                }
                //System.out.print(data[i][j] + " ");
            }
            // System.out.println();
        }
    }


    public void Solve() throws IOException {
        inputData();
        CalculateRoomCnt();
        System.out.println(roomCnt);

    }


    public static void main(String[] args) throws IOException {
        new P_13300().Solve();
    }

}
