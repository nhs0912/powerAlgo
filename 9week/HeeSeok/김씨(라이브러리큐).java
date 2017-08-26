import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 코드그라운드
 * "김씨만 행복한 세상"
 */

class myQueue {
    int size;
    int[] arr;
    int front = 0;
    int rear = 0;

    myQueue(int size) {
        this.size = size;
        arr = new int[size + 1];
    }

    boolean isEmpty() {
        return front == rear;
    }

    boolean isFull() {
        return front == (arr.length - 1);
    }

    void enQueue(int data) {
        if (!isFull()) {
            arr[front++] = data;
        }
    }

    int deQueue() {
        if (!isFull()) {
            return arr[rear++];
        } else {
            return 0;
        }
    }
}

class Solution {
    //static int Answer;
    int[][] adjMatrix;//인접해있는 지역 표시
    boolean[] visited;//방문한 지점
    char[] markedZone;//어떤 지역인지 표시
    //myQueue q;
    Queue<Integer> q;
    int zoneCnt;//지역 갯수
    boolean isCheck;

    void printArr(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    void printArr(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void printArr(boolean[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void printArr(char[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void BFS(int start) {

        visited[start] = true;
        //q.enQueue(start);
        q.add(start);

        while (!q.isEmpty()) {
            //int here = q.deQueue();
            int here = q.remove();
            // System.out.print(here + "->");
            isCheck = Mark(here);
            if (isCheck) {
                break;
            }
            for (int there = 1; there <= zoneCnt; there++) {
                if (visited[there] || (adjMatrix[here][there] != 1)) {
                    continue;
                }
                visited[there] = true;
                //q.enQueue(there);
                q.add(there);
            }
        }
        //System.out.println();

    }

    boolean Mark(int start) {
        for (int i = 1; i < adjMatrix[start].length; i++) {
            if (i != start && adjMatrix[start][i] == 1) {//인접했을 경우
                if (markedZone[start] == markedZone[i]) {
                    return true;

                } else {
                    if (markedZone[start] == 'A') {
                        markedZone[i] = 'B';
                    } else {
                        markedZone[i] = 'A';
                    }
                }
            }
        }
        return false;
    }

    public void solve() throws FileNotFoundException {

        //Scanner sc = new Scanner(System.in);

        Scanner sc = new Scanner(new FileInputStream("input.txt"));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {
            isCheck = false;//초기화
            zoneCnt = sc.nextInt();// 지역의 갯수

            int adjZoneCnt = sc.nextInt();// 인접한 지역의 갯수
            adjMatrix = new int[zoneCnt + 1][zoneCnt + 1];
            visited = new boolean[zoneCnt + 1];
            markedZone = new char[zoneCnt + 1];
            //q = new myQueue(zoneCnt + 1);
            q = new LinkedList<>();

            while (adjZoneCnt-- > 0) {
                int neighborZone1 = sc.nextInt();
                int neighborZone2 = sc.nextInt();

                adjMatrix[neighborZone1][neighborZone2] = 1;
            }

            markedZone[1] = 'A';
            BFS(1);


            System.out.println("Case #" + (test_case + 1));
            if (!isCheck) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

        }
    }

    public static void main(String args[]) throws Exception {
        new Solution().solve();

    }
}
