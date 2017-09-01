
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 문제 번호 : 2206
 * 문제 이름 : 벽 부수고 이동하기1
 * 문제 주소 : https://www.acmicpc.net/problem/2206
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
    public int prevX;
    public int prevY;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Point(int x, int y, int prevX, int prevY) {
        this.x = x;
        this.y = y;
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
    boolean[][] visited;
    int[][] pathWeight;// 거리 값
    Point East = new Point(0, 1);
    Point West = new Point(0, -1);
    Point South = new Point(1, 0);
    Point North = new Point(-1, 0);
    Point[] search = {East, West, South, North};//동서남북 순서
    int cnt = 1;
    int breakWallCnt = 0;
    int[][] copyArr;//adjArr 복사본

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
        visited[start][end] = true;//방문 표시
        Point newPoint = new Point(start, end, start, end);
        myQueue q = new myQueue();
        q.enQueue(newPoint);
        pathWeight[start][end] = cnt;
        while (!q.isEmpty()) {
            Point p = q.deQueue();
            //pathWeight[p.x][p.y] = cnt++;
            if (p.x == visited.length - 1 && p.y == visited[p.x].length - 1) {
                break;
            }
            for (int i = 0; i < search.length; i++) {
                int curX = p.x + search[i].x;
                int curY = p.y + search[i].y;
                if (0 < curX && 0 < curY && curX < visited.length && curY < visited[curX].length) {
                    if (copyArr[curX][curY] == 0 && visited[curX][curY] != true) {
                        //길이 있고, 방문한 적이 없으면
                        visited[curX][curY] = true;
                        Point point = new Point(curX, curY, p.x, p.y);
                        q.enQueue(point);
                        pathWeight[curX][curY] = pathWeight[p.x][p.y] + 1;
                        //isMarking = true;
                    } else if (copyArr[curX][curY] == 1 && visited[curX][curY] != true && breakWallCnt > 0) {
                        //한번도 방문하지 않은 벽을 마주쳤을 때
                        breakWallCnt--; //벽을 깬 횟수 1회 차감

                    }
                } else {//낭떠러지일 때
                    continue;
                }
            }
//            if (isMarking) {
//                cnt++;
//            }
        }
    }

    public void inputData() throws IOException {
        FileInputStream fis = new FileInputStream("test.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));


        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1][M + 1];//방문 배열
        boolean[][] breakVisited = new boolean[N + 1][M + 1];
        adjArr = new int[N + 1][M + 1];
        pathWeight = new int[N + 1][M + 1];
        copyArr = new int[N + 1][M + 1];
        int wallCnt = 0;
        String str;
        int minPath = N * M;
        int pathWeightValue;//경로의 길이
        for (int i = 1; i <= N; i++) {
            str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                //벽 '0' 로 표시
                int wall = str.charAt(j) - '0';
                adjArr[i][j + 1] = wall;//벽이면 0, 길이면 1
                if (wall == 1) {
                    wallCnt++;
                }
            }
        }
       // wallCnt = 2;
        // printArr(adjArr);
        while (wallCnt-- > 0) {
            for (int i = 1; i < adjArr.length; i++) {
                for (int j = 1; j < adjArr[i].length; j++) {
                    copyArr[i][j] = adjArr[i][j];
                }
            }
            //initBooleanArr(visited);
            breakWallCnt = 1;
            for (int i = 1; i < copyArr.length; i++) {
                for (int j = 1; j < copyArr[i].length; j++) {
                    if (copyArr[i][j] == 1 && breakWallCnt > 0 && breakVisited[i][j] != true) {
                        copyArr[i][j] = 0;
                        breakWallCnt--;
                        breakVisited[i][j] = true;
                        if (breakWallCnt == 0) {
                            break;
                        }
                    }
                }
            }
        //    printArr(copyArr);
         //   System.out.println("----------------------");
            BFS(1, 1);
           // printArr(pathWeight);
            pathWeightValue = pathWeight[N][M];
            //System.out.println((8 - wallCnt) + ": " + pathWeightValue);

            if (pathWeightValue!= 0 && pathWeightValue < minPath) {
                minPath = pathWeightValue;
            }
           // System.out.println(minPath);
            initArr(pathWeight);
        }
        System.out.println(minPath);


    }


    public void Solve() throws IOException {
        inputData();

    }

    public static void main(String[] args) throws IOException {
        new Main().Solve();
    }

}
