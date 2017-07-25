
import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호 : 1912
 * 문제 이름 : 연속합
 * 문제 주소 : https://www.acmicpc.net/problem/1912
 */


class Main {

    public void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    int[] data;

    public void inputData() throws IOException {
        FileInputStream fis = new FileInputStream("test.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        data = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 0;
        while (st.hasMoreTokens()) {
            data[index++] = Integer.parseInt(st.nextToken());
        }
        //printArr(data);

    }

    public int Kadane(int[] arr) {
        int max_ending_here = 0;
        int max_so_far = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            max_ending_here += arr[i];
            if (max_ending_here > max_so_far) {
                max_so_far = max_ending_here;
            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
        }

        return max_so_far;
    }

    public void Solve() throws IOException {
        inputData();
        int result = Kadane(data);
        System.out.println(result);
    }


    public static void main(String[] args) throws IOException {
        new Main().Solve();
    }

}
