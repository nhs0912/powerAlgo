import java.io.*;
import java.util.*;

enum Gender{ // S : 0,1
    MALE(0), FEMALE(1);
	
	private int genderIndex;
	
    Gender(int genderIndex){
    	this.genderIndex = genderIndex;
    }
    
    public static Gender getGender(int genderIndex){
    	for(Gender g : Gender.values()){
    		if(g.genderIndex == genderIndex) 
    			return g;
    	}
    	throw new IllegalArgumentException();
    }
}
    
enum Grade{ // Y : 1-6
    FIRST(1), SECOND(2), THIRD(3), FORTH(4), FIFTH(5), SIXTH(6);
	
	private int gradeIndex;
	
	Grade(int gradeIndex){
		this.gradeIndex = gradeIndex;
	}
	
	public static Grade getGrade(int gradeIndex){
		for(Grade g : Grade.values()){
			if(g.gradeIndex == gradeIndex)
				return g;
		}
		throw new IllegalArgumentException();
	}
}

class Student{
    
    private Gender gender;
    private Grade grade;
    
    public Student(Gender gender, Grade grade){
    	this.gender = gender;
    	this.grade = grade;
    }
    
    public Gender getGender(){
    	return this.gender;
    }
    
    public Grade getGrade(){
    	return this.grade;
    }
}

public class Main{
	
	private static int STUDENT_NUM;
	private static int ROOM_SIZE;
    
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    private static ArrayList<Student> students;
    
    private static ArrayList<Student> readAndInit() throws IOException{
    	
    	ArrayList<Student> students = new ArrayList<Student>();
    	
    	String buf = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(buf);
        
        STUDENT_NUM = Integer.parseInt(tokenizer.nextToken()); // N
        ROOM_SIZE = Integer.parseInt(tokenizer.nextToken()); // K

        int inputGender = -1;
        int inputGrade = -1;
        for(int i=0; i<STUDENT_NUM; i++){
            buf = reader.readLine();
            tokenizer = new StringTokenizer(buf);
            inputGender = Integer.parseInt(tokenizer.nextToken()); // S
            inputGrade = Integer.parseInt(tokenizer.nextToken()); // Y
            
            students.add(new Student(
            		Gender.getGender(inputGender),
            		Grade.getGrade(inputGrade)
            		));
        }
        
        return students;
    }
    
    private static int[][] groupStudents(ArrayList<Student> students){
    	
    	int ROW = Grade.values().length; // 6
    	int COL = Gender.values().length; // 2
    	
    	int[][] studentGroup = new int[ROW][COL]; // 6행 2열
    	for(int i=0; i<ROW; i++){
    		for(int j=0; j<COL; j++){
    			studentGroup[i][j] = 0;
    		}
    	}

    	for(Student student : students){
    		studentGroup[student.getGrade().ordinal()][student.getGender().ordinal()]++;		
    	}
    	
    	return studentGroup;
    	
    }
    
    private static int assignRoom(int[][] groups){
    	
    	int countRooms = 0;
    	
    	for(int i=0; i<groups.length; i++){
    		for(int j=0; j<groups[i].length; j++){
    			
    			if(groups[i][j] > 0 && groups[i][j] <= ROOM_SIZE)
    				countRooms++;
    			else if(groups[i][j] > ROOM_SIZE){
    				if(groups[i][j] % ROOM_SIZE != 0){
    					countRooms = countRooms + groups[i][j] / ROOM_SIZE + 1;
    				}
    				else
    					countRooms = countRooms + groups[i][j] / ROOM_SIZE;
    			}
    			
    		}
    	}
    	
    	return countRooms;
    }
    
    public static void main(String[] args) throws IOException {
    	
    	students = readAndInit();
    	
    	int[][] groups = groupStudents(students);
    	
    	System.out.println(assignRoom(groups));
    }
}
