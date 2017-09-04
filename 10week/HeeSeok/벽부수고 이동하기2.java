import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 문제 번호 : 14442
 * 문제 이름 : 벽 부수고 이동하기2
 * 문제 주소 : https://www.acmicpc.net/problem/14442
 */

interface myQueueDAO {

    void enQueue(Point point);

    Point deQueue();

    boolean isEmpty();

    void print();

    Point peek();
}

class Point {
    public int x;
    public int y;

    public int isBreakingCnt = 0;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Point(int x, int y, int isBreakingCnt) {
        this.x = x;
        this.y = y;
        this.isBreakingCnt = isBreakingCnt;
    }
}

class myQueue implements myQueueDAO {
    Node front;
    Node rear;

    class Node {
        Point point;
        Node link;

        Node(Point point) {
            this.point = point;
        }
    }

    @Override
    public void enQueue(Point point) {
        Node newNode = new Node(point);
        if (!isEmpty()) {
            front.link = newNode;
            front = newNode;
        } else {
            front = newNode;
            rear = newNode;
        }
    }

    @Override
    public Point deQueue() {
        if (!isEmpty()) {
            Point data = rear.point;
            rear = rear.link;
            return data;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return rear == null;
    }

    @Override
    public void print() {
        Node head = rear;
        while (head != null) {
            System.out.print("(" + head.point.x + "," + head.point.y + ")" + "->");
            head = head.link;
        }
    }

    @Override
    public Point peek() {
        return front.point;
    }


}

class Main {


    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[][] adjArr; // 인접행렬
    boolean[][][] visited;//방문 배열
    int[][][] pathWeight;// 거리 값
    Point East = new Point(0, 1);
    Point West = new Point(0, -1);
    Point South = new Point(1, 0);
    Point North = new Point(-1, 0);
    Point[] search = {East, West, South, North};//동서남북 순서
    int cnt = 1;
    int breakWallCnt = 0;
    int minDistance = Integer.MAX_VALUE;


    public void printArr(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                System.out.printf("%3d", arr[i][j]);
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
                System.out.printf("%5d", arr[i][j]);
            }
            System.out.println();
        }
    }

    public void printArr(int[][][] arr) {
        for (int k = 0; k < breakWallCnt + 1; k++) {
            for (int i = 1; i < arr.length; i++) {
                for (int j = 1; j < arr[i].length; j++) {
                    System.out.printf("%5d", arr[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printArr(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void initArr(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] = 0;
            }
        }
    }

    public void initBooleanArr(boolean[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] = false;
            }
        }
    }

    void BFS(int start, int end) {
        visited[start][end][0] = true;//방문 표시
        Point newPoint = new Point(start, end);
        myQueue q = new myQueue();
        q.enQueue(newPoint);
        pathWeight[start][end][newPoint.isBreakingCnt] = cnt;
        while (!q.isEmpty()) {
            Point p = q.deQueue();
            if (p.x == visited.length - 1 && p.y == visited[p.x].length - 1) {
                //맨 끝점(N,M)이면 종료
                if (minDistance > pathWeight[p.x][p.y][p.isBreakingCnt]) {
                    minDistance = pathWeight[p.x][p.y][p.isBreakingCnt];
                }
                break;

            }
            for (int i = 0; i < search.length; i++) {
                int curX = p.x + search[i].x;//x좌표
                int curY = p.y + search[i].y;//y좌표
                if (0 < curX && 0 < curY && curX < visited.length && curY < visited[curX].length) {
                    Point point;
                    if (adjArr[curX][curY] == 0 && visited[curX][curY][p.isBreakingCnt] != true) {
                        //벽이 없고 길이 있는 상태이면서 방문한 적이 없으면
                        visited[curX][curY][p.isBreakingCnt] = true;
                        point = new Point(curX, curY, p.isBreakingCnt);
                        q.enQueue(point);
                        pathWeight[curX][curY][p.isBreakingCnt] = pathWeight[p.x][p.y][p.isBreakingCnt] + 1;
                    } else if (adjArr[curX][curY] == 1 && visited[curX][curY][p.isBreakingCnt] != true && p.isBreakingCnt < breakWallCnt) {
                        //한번도 방문하지 않은 벽을 마주쳤을 때
                        point = new Point(curX, curY, p.isBreakingCnt + 1);
                        q.enQueue(point);
                        visited[curX][curY][p.isBreakingCnt + 1] = true;
                        //visited[p.y][p.x][p.isBreakingCnt + 1] = true;
                        //visited[p.y][p.x][p.isBreakingCnt] = true;
                        pathWeight[curX][curY][p.isBreakingCnt + 1] = pathWeight[p.x][p.y][p.isBreakingCnt] + 1;
                    }
                }
            }
        }
    }

    public void inputData() throws IOException {
        //FileInputStream fis = new FileInputStream("test.txt");
        //BufferedReader br = new BufferedReader(new InputStreamReader(fis));


         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        breakWallCnt = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1][M + 1][breakWallCnt + 1];//방문 배열
        adjArr = new int[N + 1][M + 1];
        pathWeight = new int[N + 1][M + 1][breakWallCnt + 1];//거리 값 표시
        String str;
        //int pathLength;//경로의 길이
        for (int i = 1; i <= N; i++) {
            str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                //벽 '0' 로 표시
                int wall = str.charAt(j) - '0';
                adjArr[i][j + 1] = wall;//벽이면 0, 길이면 1
            }
        }
        // wallCnt = 2;
        //printArr(adjArr);
       // System.out.println("-------------------");
        BFS(1, 1);

        //printArr(pathWeight);

        if (minDistance == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minDistance);
        }

    }


    public void Solve() throws IOException {
        inputData();

    }

    public static void main(String[] args) throws IOException {
        new Main().Solve();
    }

}
