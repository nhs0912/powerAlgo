class Solution {
    int[] sumArr = new int[3];

    boolean isNum(char ch) {
        //숫자인지 판별
        int num = ch - '0';
        if (num >= 0 && num <= 10) {
            return true;
        }
        return false;
    }


    public int solution(String dartResult) {
        int answer = 0;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        boolean[] charCheck = new boolean[dartResult.length()];
        for (int i = 0; i < dartResult.length(); i++) {
            charCheck[i] = isNum(dartResult.charAt(i));
        }

        for (int i = 0; i < dartResult.length(); i++) {
            int sum = 0;
            if (i < dartResult.length() - 2 && charCheck[i] && charCheck[i + 1]) {
                //10일 경우
                char ch = dartResult.charAt(i + 2);//S,D,T
                if (i < dartResult.length() - 3 && charCheck[i + 3] == false) {
                    //숫자가 아니면
                    char option = dartResult.charAt(i + 3);//option #,*
                    if (option == '#') {//#일떄
                        sum = -10;
                    } else if (option == '*') {
                        //*일 때
                        sum = 20;
                        if (index != 0) {
                            sumArr[index++] = sum;
                            i = i + 3;
                        } else {
                            //숫자이면
                            if (ch == 'S') {
                                sum = 10;
                            } else if (ch == 'D') {
                                sum = 100;

                            } else {
                                sum = 1000;
                            }
                            sumArr[index++] = sum;
                            i = i + 2;
                        }
                    }
                }
            } else {
                //10이 아닐 경우
                int num = dartResult.charAt(i) - '0';
                char ch = dartResult.charAt(i + 1);//S,D,T
                if (i < dartResult.length() - 2 && charCheck[i + 2] == false) {
                    //숫자가 아니면 option 존재
                    char option = dartResult.charAt(i + 2);//option #,*
                    if (option == '#') {
                        //#일때
                        if (ch == 'S') {
                            sum = num * (-1);
                        } else if (ch == 'D') {
                            sum = num * num * (-1);
                        } else {
                            sum = num * num * num * (-1);
                        }
                    } else if (option == '*') {

                        //* 일떄
                        if (ch == 'S') {
                            sum = num * 2;
                        } else if (ch == 'D') {
                            sum = num * num * 2;
                        } else {
                            sum = num * num * num * 2;
                        }
                        if (index != 0) {
                            sumArr[index - 1] *= 2;
                        }
                    }
                    sumArr[index++] = sum;
                    i += 2;
                } else {
                    //숫자이면
                    if (ch == 'S') {
                        sum = num;
                    } else if (ch == 'D') {
                        sum = num * num;
                    } else {
                        sum = num * num * num;
                    }
                    sumArr[index++] = sum;
                    i += 1;
                }
            }
        }
        return answer;
    }

}
