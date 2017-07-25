
import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호 : 10942
 * 문제 이름 : 팰린드롬?
 * 문제 주소 : https://www.acmicpc.net/problem/10942
 */


class Main {
    int[] data;
    boolean[][] checked; //계산한 범위 확인
    int[][] isPalindrome;// 펠린드롬인지 저장
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
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

    public void findPalindrome(int start, int end) throws IOException {
        int num = 0;
        if (!checked[start][end] && !checked[end][start]) {
            if (start == end) {
                bw.write("1\n");
                num = 1;
            } else {
//                if (start > end) {
//                    int tmp = start;
//                    start = end;
//                    end = tmp;
//                }
                int mid = (start + end) / 2;
                int sum = start + end;
                boolean check = true;
                for (int i = start; i <= mid; i++) {
                    int rightIndex = sum - i;
                    if (data[i] != data[rightIndex]) {
                        check = false;
                    }
                }

                if (check) {
                    num = 1;
                    bw.write("1\n");
                } else {
                    num = 0;
                    bw.write("0\n");
                }
                checked[start][end] = true;
                checked[end][start] = true;

                isPalindrome[start][end] = num;
                isPalindrome[end][start] = num;
            }
        } else {
            bw.write(isPalindrome[start][end] + "\n");
        }


    }

    public void inputData() throws IOException {
        FileInputStream fis = new FileInputStream("test.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        checked = new boolean[N + 1][N + 1];
        isPalindrome = new int[N + 1][N + 1];
        data = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 1;
        while (st.hasMoreTokens()) {
            data[index++] = Integer.parseInt(st.nextToken());
        }
        // printArr(data);
        int qCnt = Integer.parseInt(br.readLine());
        while (qCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            findPalindrome(start, end);
        }

        bw.close();
    }


    public void Solve() throws IOException {
        inputData();

    }


    public static void main(String[] args) throws IOException {
        new Main().Solve();
    }

}
