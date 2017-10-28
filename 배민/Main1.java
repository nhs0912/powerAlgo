//Please don't change class name 'Main'
import java.util.Scanner;
import java.util.ArrayList; 

class Main {

  public static void main(String[] args) {
    try(Scanner s = new Scanner(System.in))
    {
      int numPeople = s.nextInt();
      int clockwise = s.nextInt();
      int k = s.nextInt();
      int j = s.nextInt();
      
      int numLeft = numPeople; 
      
      ArrayList<Integer> baejjangs = new ArrayList<>(); 

      for(int i = 0; i < numPeople; i++) {
        baejjangs.add(i); 
      }

      int mover = clockwise == 1 ? 1 : numPeople - 1; 
      int curr = mover; 

      while(numLeft > 1) {
        curr += (k - 1) * mover; 
        curr %= numLeft;
        numLeft--; 
        mover = clockwise == 1 ? 1 : numLeft - 1; 

        baejjangs.remove(curr); 
        k += j; 
      }

      System.out.println(baejjangs.get(0) + 1); 
    }
  }
}
