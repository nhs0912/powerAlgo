
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 문제 번호 : 2606
 * 문제 이름 : 바이러스
 * 문제 주소 : https://www.acmicpc.net/problem/2606
 */

class Main {
    int[][] adjMatrix;
    boolean[] visited;
    int virusCnt = 0;
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public void printArr(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

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

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine()); //Computer Count
        int edgeCnt = Integer.parseInt(br.readLine());// Edge Count
        StringTokenizer st;
        adjMatrix = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        while (edgeCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }

    }

    public void DFS(int start) {
        visited[start]=true;
        for (int i = 1; i < adjMatrix.length; i++) {
            if (adjMatrix[start][i] == 1 && visited[i] == false) {                
                virusInfected();// Increase virusCnt
                DFS(i);
            }
        }
    }


    public void virusInfected() {
        virusCnt++;
    }

    public void Solve() throws IOException {
        inputData();
        DFS(1);
        System.out.println(virusCnt);
    }

    public static void main(String[] args) throws IOException {
        new Main().Solve();
    }

}
