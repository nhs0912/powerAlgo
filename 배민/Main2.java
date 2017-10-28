//Please don't change class name 'Main'
import java.util.Scanner;
import java.util.ArrayList; 

class Main {

    private class Interval {
        public int x, y; 
        public boolean lo, hi; 

        public Interval(int x, int y, boolean lo, boolean hi) {
            this.x = x; 
            this.y = y;
            this.lo = lo; 
            this.hi = hi;  
        }

        public void printInterval(int upperBound) { 
            String lo; 

            if(this.x <= 0) 
                lo = "-"; 
            else 
                lo = this.x + ""; 

            String hi; 

            if(this.y >= upperBound) 
                hi = "+"; 
            else 
                hi = this.y + ""; 

            String loB = this.lo ? "[" : "("; 
            String hiB = this.hi ? "]" : ")"; 

            System.out.println(loB + lo + ", " + hi + hiB); 
        }
    }

    public void solve() {
        ArrayList<Interval> intervals = new ArrayList<>(); 
        int max = 0; 

        try(Scanner s = new Scanner(System.in))
        {
            int n = s.nextInt();

            for(int i = 0; i < n; i++)
            {
                int a = s.nextInt();
                int b = s.nextInt();

                max = Math.max(max, Math.max(a, b));

                intervals.add(new Interval(a, b, true, true)); 
            }

            int marking[] = new int[2 * (max + 1)]; 

            for(int i = 0; i < 2 * (max + 1); i++) {
                marking[i] = 0; 
            }

            for(Interval interval : intervals) {
                for(int i = interval.x * 2; i <= interval.y * 2; i++) {
                    marking[i]++; 
                }
            }

            int lo = 0; 
            intervals = new ArrayList<>(); 
            boolean lowerIncluded = false, prevOdd = false; 

            for(int i = 0 ; i < 2 * (max + 1); i++) {
                System.out.println(i + ": " + marking[i]);
                if(marking[i] % 2 == 0) {
                    if(prevOdd){
                        if (i % 2 == 0) {
                            lowerIncluded = true; 
                            lo = i;
                        } else {
                            lowerIncluded = false; 
                        }
                    }
                    
                    prevOdd = false; 
                } else {
                    if(!prevOdd){
                        if(i % 2 == 0){
                            intervals.add(new Interval(lo / 2 , i / 2, lowerIncluded, false));
                        }
                        else {
                            intervals.add(new Interval((lo + 1) / 2, i / 2, lowerIncluded, true));
                        }
                    }
                    lo = i;
                    prevOdd = true;
                }
            }

            intervals.add(new Interval(lo / 2, max * 2, lowerIncluded, false));

            for(Interval interval : intervals) {
                interval.printInterval(max * 2); 
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main(); 
        main.solve(); 
	}
    
}
