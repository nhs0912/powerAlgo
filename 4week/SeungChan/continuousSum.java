import java.util.*;
import java.io.*;

public class Main{
    
    static int[] permutes;
    
    public static void main(String[] args) throws IOException {

    	  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	  int num = Integer.parseInt(reader.readLine());
        permutes = new int[num];
        
        String input = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(input);
        for(int i=0; i<num; i++){
        	  permutes[i] = Integer.parseInt(tokenizer.nextToken());
        }
        
        int max = 0;
        int tmp = 0;
        for(int i=0; i<num; i++){ // 10가지
            for(int j=0; j<num-i; j++){
            	if((tmp = sumPermutes(permutes, j, i+j+1)) > max){ // permutes[j] + permutes[j+1] + ... i+1번
            		max = tmp;
            	}
            }
        }
        System.out.println(max);        
    }

    public static int sumPermutes(int[] arr, int from, int to){
    	int sum = 0;
    	for(int k=from; k<to; k++){ // k >= 1
    		sum += arr[k];
    	}
    	return sum;
    }
}
