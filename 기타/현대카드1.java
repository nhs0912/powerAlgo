
private int beginVolume, maxVolume, volumes[]; 

public int max (int a, int b) {
	return a > b ? a : b;
}

public boolean isOutOfRange(int a) {
	if ( a < 0 ) 
		return false; 

	if ( a > maxValue ) 
		return false; 

	return true;
}

public int func(int sumSoFar, int lo) {
	int currNum = volumes[lo];

	if(lo == volumes.length() - 1) {
		int opt1 = sumSoFar + currNum;
		int opt2 = sumSoFar - currNum; 
		if(isOutOfRange(sumSoFar + currNum)) {
			opt1 = -1; 
		}

		if(isOutOfRange(sumSoFar - currNum)) {
			opt2 = -1; 
		}

		return max(opt1, opt2); 
	}

	if(isOutOfRange(currNum)) 
		return -1;

	return max(func(sumSoFar + currNum, lo + 1), func(sumSoFar - currNum, lo + 1));
}

public void solve() {
	System.out.println(func(beginVolume, 0));
}