import java.io.*;
import java.util.ArrayList;
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
    int index = -1;

    boolean isEmpty() {
        return top == null;
    }

    void push(char data) {
        stackNode newNode = new stackNode(data);
        index++;
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
            index--;
            return data;
        }
        return 0;
    }

    int getIndex() {
        return index;
    }
}


class Main {

    char[][] expression = new char[][]{{'[', ']'}, {'{', '}'}, {'(', ')'}};
    static myStack s;
    ArrayList<Integer> list;
    boolean onlyOpen = false;
    boolean misMatch = false;

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
                boolean closeCheck = (expression[i][1] == close);
                if (closeCheck) {
                    list.add(s.getIndex() + 1);
                    //System.out.print((s.getIndex() + 1) + " ");
                }
                return closeCheck;
            }
        }
        return false;
    }

    boolean checkOnlyOpen() {
        int size = s.getIndex() + 1;
        int cnt = 0;
        while (!s.isEmpty()) {
            if (isOpen(s.pop())) {
                cnt++;
            }
        }
        if (cnt == size) {
            return true;
        }
        return false;
    }

    boolean isBalanced(String str) {
        for (int i = 0; i < str.length(); i++) {
            char checkData = str.charAt(i);
            if (isOpen(checkData)) {
                s.push(checkData);
                list.add(s.getIndex());
                //System.out.print(s.getIndex() + " ");
            } else if (isClose(checkData)) {
                if (s.isEmpty() || !matches(s.pop(), checkData)) {
                    misMatch = true;
                    return false;
                }
            } else {
                //괄호가 아닌 값일 떄
                list.add(s.getIndex() + 1);
            }
        }
        if (str.length() == s.getIndex() + 1) {
            onlyOpen = true;
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
            onlyOpen = false;
            misMatch = false;
            s = new myStack();
            list = new ArrayList<>();
            String str = br.readLine();
            boolean result = isBalanced(str);

            if (result && !onlyOpen) {
                for (int num : list) {
                    System.out.print(num + " ");
                }
                System.out.println();
            } else {
                if (onlyOpen) {
                    System.out.println(-1);
                } else {
                    if (misMatch) {
                        int size = list.size();
                        System.out.println(size);
                    }else{
                        System.out.println(-1);
                    }


                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new Main().solve();

    }
}
