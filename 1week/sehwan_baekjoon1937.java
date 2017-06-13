package com.company;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

class IntPair {
    public int x;
    public int y;
    public IntPair(int x, int y) {
        this.x=x;
        this.y=y;
    }
}

class MyMap {
    private int[][] map;
    public MyMap(int n) {
        map = new int[n][n];
    }
    public int getVal(int x, int y){
        return map[x][y];
    }
    public void setVal(int x, int y, int newVal) {
        map[x][y] = newVal;
    }
}

public class Main {

    private static ArrayList<IntPair> getPossiblePaths(MyMap bambooMap, int n, int x, int y){
        ArrayList<IntPair> possiblePaths = new ArrayList<>();

        if (x-1 >= 0 && bambooMap.getVal(x-1,y) > bambooMap.getVal(x,y))
            possiblePaths.add(new IntPair(x-1,y));
        if (x+1 <  n && bambooMap.getVal(x+1,y) > bambooMap.getVal(x,y))
            possiblePaths.add(new IntPair(x+1,y));
        if (y-1 >= 0 && bambooMap.getVal(x,y-1) > bambooMap.getVal(x,y))
            possiblePaths.add(new IntPair(x, y-1));
        if (y+1 <  n && bambooMap.getVal(x,y+1) > bambooMap.getVal(x,y))
            possiblePaths.add(new IntPair(x, y+1));

        return possiblePaths;
    }

    private static void getMaxDays(MyMap bambooMap, MyMap maxDayMap, int n, int x, int y){
        ArrayList<IntPair> possiblePaths = getPossiblePaths(bambooMap, n, x, y);

        // base case
        if (possiblePaths.size() == 0){
            maxDayMap.setVal(x, y, 1);
            return ;
        }

        ArrayList<Integer> possibleDays = new ArrayList();

        // recursive case
        for(IntPair coord : possiblePaths) {
            if(maxDayMap.getVal(coord.x, coord.y) == 0)
                getMaxDays(bambooMap, maxDayMap, n, coord.x, coord.y);
            possibleDays.add(maxDayMap.getVal(coord.x, coord.y));
        }

        maxDayMap.setVal(x,y, Collections.max(possibleDays) + 1);

        return;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        MyMap bambooMap = new MyMap(n);
        MyMap maxDayMap = new MyMap(n);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                bambooMap.setVal(i, j, scan.nextInt());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (maxDayMap.getVal(i,j) == 0){
                    getMaxDays(bambooMap, maxDayMap, n, i, j);
                }
            }
        }

        int max = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(maxDayMap.getVal(i,j) > max)
                    max = maxDayMap.getVal(i,j);
            }
        }

        System.out.println(max);
    }
}
