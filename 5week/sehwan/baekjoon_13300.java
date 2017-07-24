import java.io.InputStreamReader; 
import java.io.BufferedReader; 
import java.io.IOException; 
import java.util.StringTokenizer; 

public class Main{
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
	private int numStudent, maxRoomCap; 
	private int students[][];

	public Main() {
		try {
			readAndInit();
		} catch (IOException e) {

		}
	} 

	private void readAndInit() throws IOException {
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine()); 
		numStudent = Integer.parseInt(tokenizer.nextToken()); 
		maxRoomCap = Integer.parseInt(tokenizer.nextToken());

		students = new int[2][6];
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++){
				students[i][j] = 0; 
			}
		}

		int gender, grade; 
		for(int i = 0; i < numStudent; i++ ) {
			tokenizer = new StringTokenizer(reader.readLine()); 
			gender = Integer.parseInt(tokenizer.nextToken()); 
			grade  = Integer.parseInt(tokenizer.nextToken())-1; 
			students[gender][grade]++; 
		}
	}

	public int getNumRequiredRoom() { 
		int count = 0; 

		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++){
				count += students[i][j] / maxRoomCap; 
				if(students[i][j] % maxRoomCap > 0)
					count++; 
			}
		}
		return count; 
	}


	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.getNumRequiredRoom()); 
	}
}