import java.io.*;
import java.util.StringTokenizer;


class StackNode {
    int data;
    StackNode link;
}

class LinkedStack {
    StackNode top;

    public boolean isEmpty() {
        return (top == null);
    }

    public void push(int item) {
        StackNode newNode = new StackNode();
        newNode.data = item;
        newNode.link = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("삭제 실패! 이미 비어있습니다.");
            return 0;
        } else {
            int item = top.data;
            top = top.link;
            return item;
        }
    }
}

class QNode {
    int data;
    QNode link;
}

class LinkedQueue {

    QNode front;
    QNode rear;

    public LinkedQueue() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public void enQueue(int item) {
        QNode newNode = new QNode();
        newNode.data = item;
        newNode.link = null;
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.link = newNode;
            rear = newNode;
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("이미 데이터가 없습니다.");
            return 0;
        } else {
            int item = front.data;
            front = front.link;
            if (front == null)
                rear = null;
            return item;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("데이터가 없습니다");
        } else {
            QNode head = front;
            while (head != null) {
                System.out.print(head.data + " ");
                head = head.link;
            }
            System.out.println();
        }
    }
}

class AdjMatrix {
    private int matrix[][] = new int[10001][10001];
    private int totalV = 0;
    boolean[] visited;

    public void insertVertex(int v) {
        //totalV++;
        totalV = v + 1;
        visited = new boolean[totalV];
    }

    public void insertEdge(int v1, int v2) {
        if (v1 >= totalV || v2 >= totalV) {
            System.out.println("없는 정점입니다.");
        } else {
            matrix[v1][v2] = 1;
        }
    }

    public void DFS(int start) {
        visited[start] = true;
        for (int i = 1; i <= totalV; i++) {
            if (matrix[start][i] == 1 && visited[i] == false) {
                System.out.print(i + " ");
                DFS(i);
            }
        }

    }


//    void DFS(int v) {
//        boolean[] visited = new boolean[totalV];
//        visited[v] = true;
//        LinkedStack s = new LinkedStack();
//        s.push(v);
//        s.push(v);
//        System.out.print(v + " ");
//        int vertex = v;
//        while (s.top != null) {
//
//            //방문하지 않은 정점 탐색
//            for (int i = 1; i < visited.length; i++) {
//                if (matrix[vertex][i] == 1 && visited[i] == false) {
//                    s.push(i);
//                    visited[i] = true;
//                    vertex = i;
//                    i = 0;
//                    System.out.print(vertex + " ");
//                }
//            }
//
//            vertex = s.pop();
//            //방문하지 않은 정점 탐색
//            for (int i = 1; i < visited.length; i++) {
//                if (matrix[vertex][i] == 1 && visited[i] == false) {
//                    s.push(i);
//                    visited[i] = true;
//                    vertex = i;
//                    i = 0;
//                    System.out.print(vertex + " ");
//                }
//            }
//        }
//        System.out.println();
//    }

    void BFS(int v) {
        boolean[] visited = new boolean[totalV];
        LinkedQueue q = new LinkedQueue();
        q.enQueue(v);
        visited[v] = true;
        while (!q.isEmpty()) {
            v = q.deQueue();
            System.out.print(v + " ");
            for (int i = 1; i < totalV; i++) {
                if (visited[i] == false && matrix[v][i] == 1) {
                    q.enQueue(i);
                    visited[i] = true;
                }
            }


        }
    }

    public void printMatrix() {
        for (int i = 1; i < totalV; i++) {
            System.out.printf("\n\t\t");
            for (int j = 1; j < totalV; j++) {
                System.out.printf("%2d", matrix[i][j]);
            }
        }
    }
}


class GraphNode {
    int vertex;
    GraphNode link;
}


class Main {


    public void Solve() throws IOException {

        FileInputStream fis = new FileInputStream("test.txt");

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int vertexCnt = Integer.parseInt(st.nextToken());//정점갯수 입력
        int edgeCnt = Integer.parseInt(st.nextToken());//간선 갯수 입력
        int startVertex = Integer.parseInt((st.nextToken()));// 시작 정점


        AdjMatrix MG = new AdjMatrix();
        MG.insertVertex(vertexCnt);


        while (edgeCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            MG.insertEdge(start, end);
            MG.insertEdge(end, start);
        }

        // MG.printMatrix();
        // System.out.println();
        System.out.print(startVertex+" ");
        MG.DFS(startVertex);
        System.out.println();
        MG.BFS(startVertex);


    }


    public static void main(String[] args) throws IOException {
        new Main().Solve();
    }

}
