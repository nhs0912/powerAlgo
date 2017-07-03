import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class EqualDistanceTree {
	int[] edges; 
	int[] totalDistKeeper; 
	int height; 
	int numTotalDistKeeper, numEdge;

	public EqualDistanceTree(int height, StringTokenizer tokenizer) {
		this.height = height; 
		this.numEdge = ((int)Math.pow(2, height+1)) - 2; 
		this.edges = new int[numEdge];
		this.numTotalDistKeeper = ((int)Math.pow(2, height)) - 1; 
		this.totalDistKeeper = new int[numTotalDistKeeper];

		int i = 0; 
		while(tokenizer.hasMoreTokens()) {
			edges[i++] = Integer.parseInt(tokenizer.nextToken()); 
		}
	}

	public void modifyTreeLayer(int layer) {
		int left = ((int) Math.pow(2, layer))-2;  
		int right = left + ((int) Math.pow(2, layer)); 

		int leftWeight,  leftChildTotal,  leftCurrTotal;
		int rightWeight, rightChildTotal, rightCurrTotal;

		int totalDistCurrIdx, targetDist; 

		for(int i = left; i < right; i += 2) {

			if(left == 0)
				totalDistCurrIdx = 0; 
			else 
				totalDistCurrIdx = i / 2; 

			if ((totalDistCurrIdx * 2 + 1) >= this.numTotalDistKeeper) {
				leftChildTotal = 0;
				rightChildTotal = 0;
			}else {
				leftChildTotal = totalDistKeeper[totalDistCurrIdx * 2 + 1];
				rightChildTotal = totalDistKeeper[totalDistCurrIdx * 2 + 2];
			}

			leftWeight = edges[i]; 
			rightWeight = edges[i+1]; 

			leftCurrTotal = leftChildTotal + leftWeight;
			rightCurrTotal = rightChildTotal + rightWeight;

			targetDist = leftCurrTotal > rightCurrTotal ? leftCurrTotal : rightCurrTotal;

			edges[i] = targetDist - leftChildTotal; 
			edges[i+1] = targetDist - rightChildTotal;

			totalDistKeeper[totalDistCurrIdx] = targetDist;
		}
	}

	public int getMinimumEdgeWeightSum() {
		for (int i = height; i > 0; i--){
			modifyTreeLayer(i); 
		}

		int edgeSum = 0; 
		for (int i = 0; i < this.numEdge; i++) {
			edgeSum += this.edges[i]; 
		}
		return edgeSum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int height = Integer.parseInt(reader.readLine()); 
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine()); 

		EqualDistanceTree tree = new EqualDistanceTree(height, tokenizer); 
		System.out.println(tree.getMinimumEdgeWeightSum()); 
	}
}