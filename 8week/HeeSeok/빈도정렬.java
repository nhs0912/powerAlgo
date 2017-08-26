
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 문제 번호 : 2910
 * 문제 이름 : 빈도정렬
 * 문제 주소 : https://www.acmicpc.net/problem/2910
 */


class Main {

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Number[] numberList;

    public void printArr(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void fastPrintArr(int[][] arr) throws IOException {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                bw.write(arr[i][j] + " ");

            }
            bw.write("\n");
        }
        bw.close();
    }

    public void printArr(boolean[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printArr(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public void inputData() throws IOException {
         FileInputStream fis = new FileInputStream("test.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());// message length
        int C = Integer.parseInt(st.nextToken());//숫자 범위
        int[][] numCnt = new int[3][N + 1];//빈도 수 저장
        //int[] numFirstIndex = new int[N + 1];// 숫자 처음 출현
        //boolean[] numVisited = new boolean[N + 1]; //처음 숫자인지 검사
        st = new StringTokenizer(br.readLine());
        int index = 1;
        //int firstIndex = Integer.MAX_VALUE;
        //numberList = new Number[C + 1];


        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            boolean duplicateCheck = false;//중복 체크
            for (int i = 1; i <= N; i++) {
                if (num == numCnt[1][i]) {
                    duplicateCheck = true;
                }
            }
            if (!duplicateCheck) {
                numCnt[1][index++] = num;
            }
            for (int i = 1; i < numCnt[1].length; i++) {
                if (numCnt[1][i] == num) {
                    numCnt[2][i]++;
                }
            }

        }
        int maxCnt = 0;

        for (int i = 1; i < numCnt[2].length; i++) {
            if (maxCnt < numCnt[2][i]) {
                maxCnt = numCnt[2][i];
            }
        }
        while (maxCnt > 0) {
            for (int i = 1; i < numCnt[1].length; i++) {
                if (numCnt[2][i] == maxCnt) {
                    while (numCnt[2][i]-- > 0) {
                        System.out.print(numCnt[1][i] + " ");
                    }
                }
            }
            maxCnt--;
        }
    }


    public void Solve() throws IOException {
        inputData();


    }

    public static void main(String[] args) throws IOException {
        new Main().Solve();
    }

}
