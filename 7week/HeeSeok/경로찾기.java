import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 문제 번호 : 11403
 * 문제 이름 : 경로 찾기
 * 문제 주소 : https://www.acmicpc.net/problem/11403
 */

class Main {
    int[][] adjMatrix;
    boolean[][] visited;
    boolean[] visitedVertex;
    int[][] result;//방문 가능 배열
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


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

    public void initVisited() {
        for (int i = 1; i < visited.length; i++) {
            for (int j = 1; j < visited[i].length; j++) {
                visited[i][j] = false;
            }
        }
    }

    public void initVisitedVertex() {
        for (int i = 1; i < visitedVertex.length; i++) {
            visitedVertex[i] = false;
        }
    }

    public void inputData() throws IOException {
       // FileInputStream fis = new FileInputStream("test.txt");
       // BufferedReader br = new BufferedReader(new InputStreamReader(fis));
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vertexCnt = Integer.parseInt(br.readLine()); //정점 갯수
        adjMatrix = new int[vertexCnt + 1][vertexCnt + 1]; //인접행렬
        visited = new boolean[vertexCnt + 1][vertexCnt + 1];// 방문 검사
        result = new int[vertexCnt + 1][vertexCnt + 1];// 방문 가능 배열
        visitedVertex = new boolean[vertexCnt + 1];
        int index = 1;
        int N = vertexCnt;
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                for (int j = 1; j < vertexCnt + 1; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 1) {
                        adjMatrix[index][j] = num;
                    } else if (num == 0) {
                        adjMatrix[index][j] = num;
                    }
                }
            }
            index++;
        }

    }

    public void DFS(int current, int start, int end) {
        visitedVertex[current] = true;
        // System.out.print(current + "-> ");

        for (int i = 1; i < adjMatrix.length; i++) {
            if (adjMatrix[current][i] == 1 && visitedVertex[i] == false) {
                visitedVertex[i] = true;
                if (i == end) {//circle
                    visited[start][end] = true;
                }
                DFS(i, start, end);
            } else if (visitedVertex[i] == true && adjMatrix[current][i] == 1) {
                if (end == i) {
                    visited[start][end] = true;
                }
            }
        }
    }

    public boolean checkPath(int start, int end) {
        initVisitedVertex();
        DFS(start, start, end);
        return visited[start][end];

    }


    public void allCheckPath() {
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[i].length; j++) {
                if (checkPath(i, j)) {
                    result[i][j] = 1;
                }
            }
        }
    }

    public void Solve() throws IOException {
        inputData();
        initVisited();// 방문 배열 초기화
        allCheckPath();
        //printArr(result);
        fastPrintArr(result);

    }

    public static void main(String[] args) throws IOException {
        new Main().Solve();
    }

}
