//Please don't change class name 'Main'
import java.util.Scanner;

class Main {

  public static void main(String[] args) {
    try(Scanner s = new Scanner(System.in))
    {
      int x1 = s.nextInt();
      int y1 = s.nextInt();
      int x2 = s.nextInt();
      int y2 = s.nextInt();
      int x3 = s.nextInt();
      int y3 = s.nextInt();
      int x4 = s.nextInt();
      int y4 = s.nextInt();
      int x5 = s.nextInt();
      int y5 = s.nextInt();
      int x6 = s.nextInt();
      int y6 = s.nextInt();
      
      int o1x, o1y, o2x, o2y, o3x, o3y, o4x, o4y, o5x, o5y, o6x, o6y; 
      //여기부터 작성해 주세요
      if(x4 < x1 || y4 < y1 || x2 < x3 || y2 < y3) {
        o1x = 0; 
        o1y = 0; 
        o2x = 0; 
        o2y = 0;
      } else {
        o1x = Math.max(x1, x3); 
        o1y = Math.max(y1, y3); 
        o2x = Math.min(x2, x4); 
        o2y = Math.min(y2, y4);
      }
          
      if(x6 < x1 || y6 < y1 || x2 < x5 || y2 < y5) {
        o3x = 0; 
        o3y = 0; 
        o4x = 0; 
        o4y = 0;
      } else {
        o3x = Math.max(x1, x5); 
        o3y = Math.max(y1, y5); 
        o4x = Math.min(x2, x6); 
        o4y = Math.min(y2, y6); 
      }
      
      if(o2x < o3x || o2y < o3y || o4x < o1x || o4y < o1y) {
        o5x = 0; 
        o5y = 0; 
        o6x = 0; 
        o6y = 0;
      } else {
        o5x = Math.max(o1x, o3x); 
        o5y = Math.max(o1y, o3y); 
        o6x = Math.min(o2x, o4x); 
        o6y = Math.min(o2y, o4y); 
      }
      
      int area = (x2 - x1) * (y2 - y1); 
      area -= (o2x - o1x) * (o2y - o1y); 
      area -= (o4x - o3x) * (o4y - o3y); 
      area += (o6x - o5x) * (o6y - o5y); 
      
      System.out.println(area); 
    }
  }
}
