import java.io.*;
import java.util.StringTokenizer;

class Merge{
    static int[] sorted;

    Merge(int size) {
        sorted = new int[size];
    }

    void sort(int[] arr, int begin, int end) {
        int middle;
        if (begin < end) {
            middle = (begin + end) / 2;
            sort(arr, begin, middle);
            sort(arr, middle + 1, end);
            merge(arr, begin, middle, end);
        }
    }

    void merge(int[] arr, int begin, int middle, int end) {
        int left = begin;
        int right = middle + 1;
        int index = begin;
        while (left <= middle && right <= end) {
            if (arr[left] < arr[right]) {
                sorted[index++] = arr[left++];
            } else {
                sorted[index++] = arr[right++];
            }
        }
        while (left <= middle && right > end) {
            sorted[index++] = arr[left++];
        }
        while (left > middle && right <= end) {
            sorted[index++] = arr[right++];
        }
        for (int i = begin; i <= end; i++) {
            arr[i] = sorted[i];
        }
    }
}


class Main {


    void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void order(int[] arr) {
        Merge merge = new Merge(arr.length);
        merge.sort(arr, 0, arr.length - 1);
    }

    int Calculator(int[] arr1, int[] arr2) {//최솟값 계산
        int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum += arr1[i] * arr2[arr2.length-(i+1)];
        }

        return sum;
    }

    public void Solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());//갯수 입력
        int[] A = new int[N];
        int[] B = new int[N];

        int cnt = 2;
        while (0 < cnt--) {//배열이 2개 이므로
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = 0;
            while (st.hasMoreTokens()) {
                if (cnt == 1) {
                    A[index++] = Integer.parseInt(st.nextToken());
                } else {
                    B[index++] = Integer.parseInt(st.nextToken());
                }
            }
        }
        order(A);
        order(B);
        System.out.println(Calculator(A,B));
    }


    public static void main(String[] args) throws IOException {
        new Main().Solve();
    }

}