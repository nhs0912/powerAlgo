import java.io.*;
import java.util.*;

public class Main {
    
    static final int FLOODED = 0;
	
	static int[][] area;
	static int[][] temp;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(in.readLine()); // number of rows, cols
        area = new int[num][num];
        temp = new int[num][num];
        
        String buf = null;
        for(int i=0; i<num; i++) { // num  ((buf = in.readLine()) != null) && 
        	buf = in.readLine();
            StringTokenizer tokenizer = new StringTokenizer(buf);
            for(int j=0; j<num; j++) { // num   tokenizer.hasMoreTokens()
                area[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        
        cloneArrays(temp, area);

        int maxHeight = getMaxHeight(area);

        int maxComp = 1; // 연결셩분 최대 개수
        
        for(int h=2; h<maxHeight; h++){ // 9까지
        	
            for(int i=0; i<num; i++){
                for(int j=0; j<num; j++){
                    if(temp[i][j] <= h){
                    	temp[i][j] = FLOODED; // 물에 잠김
                    }
                }
            }
            int comp = 0; // 연결성분 개수
            
            for(int i=0; i<num; i++){
                for(int j=0; j<num; j++){
                	if(temp[i][j] != FLOODED){
                		comp++;
                		scanMatrix(temp, i, j);
                	}
                }
            }
            
            if(maxComp < comp){
            	maxComp = comp;
            }
            
            cloneArrays(temp, area);

        }
        
        System.out.println(maxComp);
		
	}
	private static void scanMatrix(int[][] mat, int row, int col){
		
		if(mat[row][col] != FLOODED){
			
			mat[row][col] = FLOODED;
			
            if(row > 0 && mat[row-1][col] != FLOODED)
                scanMatrix(mat, row-1, col);
            if(row < 4 && mat[row+1][col] != FLOODED)
                scanMatrix(mat, row+1, col);
            if(col > 0 && mat[row][col-1] != FLOODED)
                scanMatrix(mat, row, col-1);
            if(col < 4 && mat[row][col+1] != FLOODED)
                scanMatrix(mat, row, col+1);
		}
	}
	
	private static int getMaxHeight(int[][] area){
		int height = 0;
		
		for(int i=0; i<area.length; i++){
			for(int j=0; j<area[i].length; j++){
				if(height < area[i][j])
					height = area[i][j];
			}
		}
		
		return height;
	}
	
	private static void cloneArrays(int[][] a1, int[][] a2){
		for(int i=0; i<a1.length; i++){
			for(int j=0; j<a1[i].length; j++){
				a1[i][j] = a2[i][j];
			}
		}
	}

}
