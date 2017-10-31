// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.Stack; 

class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        int upperBound = (int) Math.pow(2, 20) - 1; 
        String[] ops = S.split(" "); 
        
        Stack<Integer> machine = new Stack<>(); 
        for(String op : ops) {
            if (op.equals("DUP")) {
                try {
                    machine.push(machine.peek());
                } catch (Exception e) {
                    return -1; 
                } 
            } else if (op.equals("POP")) {
                try {
                    machine.pop();
                } catch (Exception e) {
                    return -1; 
                } 
            } else if (op.equals("+")) {
                try {
                    Integer n1 = machine.pop(); 
                    Integer n2 = machine.pop(); 
                    
                    if (n1 + n2 > upperBound) {
                        return -1; 
                    }
                    
                    machine.push(n1 + n2);
                } catch (Exception e) {
                    return -1; 
                } 
            } else if (op.equals("-")) {
                try {
                    Integer n1 = machine.pop(); 
                    Integer n2 = machine.pop(); 
                    
                    if(n1 - n2 < 0) {
                        return -1; 
                    }
                    
                    machine.push(n1 - n2);
                } catch (Exception e) {
                    return -1; 
                }
            } else {
                machine.push(Integer.parseInt(op));   
            } 
        }
        
        if(machine.empty())
            return -1; 
        
        return machine.peek();
    }
}