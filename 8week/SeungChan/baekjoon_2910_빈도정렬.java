import java.util.*;

public class Main{

    // message
    static int[] msg;
    static int msgLen;
    static int maximum;

    static int[] convertListToArray(List<Integer> list){
        int[] arr = new int[list.size()];
        for(int i=0; i<arr.length; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }

    static int getMaxIndexOfList(List<Integer> list){
        int maxValue = 0;
        for(int i=0; i<list.size(); i++){
            if(maxValue < list.get(i)) maxValue = list.get(i);
        }
        return list.indexOf(maxValue);
    }

    static int getAndRemoveListElementByIndex(List<Integer> list, int index){
        int element = list.get(index);
        list.remove(index);
        return element;
    }

    static int[] analyzeMsg(){

        // 1. msgVal와 msgCounter의 index 동기화
        List<Integer> msgVal = new ArrayList<>(); // msg value
        List<Integer> msgCounter = new ArrayList<>(); // msg value의 개수
        for(int i=0; i<msgLen; i++){
            if(!msgVal.contains(msg[i])) {
                msgVal.add(msg[i]);
                msgCounter.add(1);
            }
            else{
                int index = msgVal.indexOf(msg[i]); // sync index
                msgCounter.set(index, msgCounter.get(index)+1);
            }
        }

        // 2. msgCounter 만큼 msgVal 채워넣기
        int[] result = new int[msgLen];
        int tempIndex = 0; // result 배열 순회한 index
        int equalLen = msgCounter.size();
        for(int i=0; i<equalLen; i++){
            int maxIndex = getMaxIndexOfList(msgCounter);

            int valueOfMaxIndex = getAndRemoveListElementByIndex(msgVal, maxIndex);
            int frequency = getAndRemoveListElementByIndex(msgCounter, maxIndex);

            for(int j=tempIndex; j<tempIndex + frequency; j++){
                result[j] = valueOfMaxIndex;
            }

            tempIndex += frequency;
        }
        return result;
    }

    static void readAndInit(){
        Scanner sc = new Scanner(System.in);
        msgLen = sc.nextInt(); // <= 1,000
        maximum = sc.nextInt(); // <= 1억

        msg = new int[msgLen];
        for(int i=0; i<msgLen; i++){
            msg[i] = sc.nextInt();
        }
    }

    static void printResult(int[] msg){
        for(int i=0; i<msgLen; i++){
            System.out.print(msg[i]);
            if(i < msgLen-1)
                System.out.print(" ");
        }
    }

    public static void main(String[] args){
        readAndInit();
        int[] analyzedMsg = analyzeMsg();
        printResult(analyzedMsg);
    }
}
