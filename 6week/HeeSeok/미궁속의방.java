import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Solution {
    //static int Answer;
    int[] v;//대각선


    public void printArr(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                System.out.printf("%5d", arr[i][j]);
            }
            System.out.println();
        }

    }

    public void printArr(boolean[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                System.out.printf(arr[i][j] + "%5d");
            }
            System.out.println();
        }

    }

    public void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%5d", arr[i]);
        }
        System.out.println();
    }

    public void inputData(int N) throws FileNotFoundException {
        if (N >= 2) {
            int size = 2 * N - 3;
            v = new int[size + 3];
            int end = size + 3;
            int num = 2;
            v[3] = num;//초기값 설정
            boolean isN = false;
            for (int i = 4; i < end; i++) {
                if (!isN) {
                    v[i] = v[i - 1] + num;
                    if (N == num) {
                        isN = true;
                        num--;
                    } else {
                        num++;
                    }
                } else {
                    v[i] = v[i - 1] + num--;
                }
            }
           // printArr(v);
        }
    }

    public long calculateNum(String str, int moveCount, int N) {
        long sum = 0;
        int x = 1;
        int y = 1;
        for (int i = 0; i < moveCount; i++) {
            switch (str.charAt(i)) {
                case 'D':
                    sum += findNum(++x, y, N);
                    break;
                case 'U':
                    sum += findNum(--x, y, N);
                    break;
                case 'L':
                    sum += findNum(x, --y, N);
                    break;
                case 'R':
                    sum += findNum(x, ++y, N);
                    break;
            }
        }
        return sum;
    }


    public long findNum(int x, int y, int N) {

        if (x == 1 && y == 1) {
            return 1;
        } else if (x == N && y == N) {
            return N * N;
        } else {
            int line = x + y; //대각선 숫자

            if (line <= N + 1) {
                //대각선 라인 번호가 N보다 작으면
                if (line % 2 == 0) {
                    //짝수 이면
                    int initY = 1;
                    return v[line] + y - initY;
                } else {
                    //홀수 이면
                    int initX = 1;
                    return v[line] + x - initX;
                }
            } else {
                //대각선 라인 번호가 N보다 면
                if (line % 2 == 0) {
                    //짝수 이면
                    int initY = line - N;
                    return v[line] + y - initY;
                } else {
                    //홀수 이면
                    int initX = line - N;
                    return v[line] + x - initX;
                }
            }
        }

    }



    public void Solve() throws FileNotFoundException {
      //  Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("test.txt"));
        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {
            int N = sc.nextInt();
            int moveCount = sc.nextInt();
            String str = sc.next();
            inputData(N);
            System.out.println("Case #" + (test_case + 1));
            if(N!=1) {
                long result = calculateNum(str, moveCount, N);
                System.out.println(result+1);
            }else{
                System.out.println(1);
            }


        }
        sc.close();

    }

    public static void main(String args[]) throws Exception {
        Solution s = new Solution();
        s.Solve();
    }
}
