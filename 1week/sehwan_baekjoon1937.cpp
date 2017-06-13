#include <iostream>
#include <vector> 

using namespace std; 

struct IntPair{
	int x, y; 
	IntPair(int x, int y){
		this->x = x;
		this->y = y; 
	}
}; 

vector<IntPair> getPossiblePaths(int** bambooMap, int n, int x, int y){
	vector<IntPair> possiblePaths; 

	if(x-1 >= 0 && bambooMap[x-1][y] > bambooMap[x][y])
		possiblePaths.push_back(IntPair(x-1, y));

	if(x+1 <  n && bambooMap[x+1][y] > bambooMap[x][y])
		possiblePaths.push_back(IntPair(x+1, y));

	if(y-1 >= 0 && bambooMap[x][y-1] > bambooMap[x][y])
		possiblePaths.push_back(IntPair(x, y-1));

	if(y+1 <  n && bambooMap[x][y+1] > bambooMap[x][y])
		possiblePaths.push_back(IntPair(x, y+1));

	return possiblePaths;
}

void getMaxDays(int** bambooMap, int** maxDayMap, int n, int x, int y){
	vector<IntPair> possiblePaths = getPossiblePaths(bambooMap, n, x, y);

	// base case
	if(possiblePaths.empty()) {
		maxDayMap[x][y] = 1;
		return;
	}

	//recursive case
	vector<int> possibleDays; 

	for (IntPair coord : possiblePaths) {
		if(maxDayMap[coord.x][coord.y] == 0)
			getMaxDays(bambooMap, maxDayMap, n, coord.x, coord.y);
		possibleDays.push_back(maxDayMap[coord.x][coord.y]);
	}

	maxDayMap[x][y] = *max_element(begin(possibleDays), end(possibleDays)) + 1;
}

int main() {
	int n;
	cin >> n; 

	int** bambooMap = new int*[n]; 
	int** maxDayMap = new int*[n];

	for(int i = 0; i < n; i++){
		bambooMap[i] = new int[n];
		maxDayMap[i] = new int[n];
	}

	for(int i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
			scanf("%d", &bambooMap[i][j]);
		}
	}

	for(int i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
			if(maxDayMap[i][j] == 0) 
				getMaxDays(bambooMap, maxDayMap, n, i, j);
		}
	}

	int max = 0;

	for(int i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
			if(maxDayMap[i][j] > max)
				max = maxDayMap[i][j];
		}
	}

	for(int i = 0; i < n; i++){
		delete bambooMap[i];
		delete maxDayMap[i];
	}
	delete[] bambooMap;
	delete[] maxDayMap;

	cout << max << endl;
}