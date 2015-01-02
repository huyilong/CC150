public void rotate(int[][] matrix, int n){
	for(int layer=0; layer<n/2; ++layer){
		int first = layer;
		//because the n is the dimension, i.e. the length of the width and height
		//and thus the index should be n - 1, which denotes the last one
		int last = n - layer -1;
		for(int i=first; i< last; ++i){
			int offset = i -first; //first is layer actually

			//save top to the temporary var named top
			int top = matrix[first][i];

			matrix[first][i] = matrx[last-offset][first];
			//left to the top

			matrix[last-offset][first] = matrix[last][last-offset];
			//bottom to the left

			matrix[last][last-offset] = matrix[i][last];
			//right to the bottom

			matrix[i][last] = top;
			//this is a chain 
			//the element in the end of last statement is the haed of the 
			//next statement
		}
	}
}