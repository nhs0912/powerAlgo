import java.io.*;
import java.util.StringTokenizer;

class stackNode {
    char data;
    stackNode link;

    stackNode(char data) {
        this.data = data;
    }
}

class myStack {
    stackNode top;

    boolean isEmpty() {
        return top == null;
    }

    void push(char data) {
        stackNode newNode = new stackNode(data);
        if (!isEmpty()) {
            newNode.link = top;
            top = newNode;
        } else {
            top = newNode;
        }
    }

    char pop() {
        if (!isEmpty()) {
            char data = top.data;
            top = top.link;
            return data;
        }
        return 0;
    }
}


class Main {

    char[][] expression = new char[][]{{'[', ']'}, {'{', '}'}, {'(', ')'}};


    boolean isOpen(char data) {
        for (int i = 0; i < expression.length; i++) {
            if (expression[i][0] == data) {
                return true;
            }
        }
        return false;
    }

    boolean isClose(char data) {
        for (int i = 0; i < expression.length; i++) {
            if (expression[i][1] == data) {
                return true;
            }
        }
        return false;
    }

    boolean matches(char open, char close) {
        for (int i = 0; i < expression.length; i++) {
            if (expression[i][0] == open) {
                return expression[i][1] == close;
            }
        }
        return false;
    }

    boolean isBalenced(String str) {
        myStack s = new myStack();

        for (int i = 0; i < str.length(); i++) {
            char checkData = str.charAt(i);
            if (isOpen(checkData)) {
                s.push(checkData);
            } else if(isClose(checkData)){
                if (s.isEmpty() || !matches(s.pop(), checkData)) {
                    return false;
                }

            }
        }
        return s.isEmpty();
    }

    public void solve() throws IOException {
        FileInputStream fis = new FileInputStream("test.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            //StringTokenizer st = new StringTokenizer(br.readLine());
            String str = br.readLine();
            boolean result = isBalenced(str);
            if (result) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new Main().solve();

    }
}
