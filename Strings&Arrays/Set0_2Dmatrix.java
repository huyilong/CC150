//try to optimize:: we do not need to know the exact location of the 0s in the board
//which could save a lot of time for searching we only need to set all 0s if there is 0
//in some rows and columns

//also, be careful that we can't iterate with matrix and whenever meet a 0 to set that
//row and column to be, which would result in a whole 0s in the matrix
//we might need another matrix to save the flag of the 0s in the original matrix
//however, based on the thoughts on the top we only need to create two arrays
//to save the columns and rows would be adequate, which save the time for searching matrix[i][j]


//attention: there is a mistake in the analysis above, we actually save space rather than time
//i.e. we do not need an extra 2d matrix to locate the 0s in the original problem

public static void setZeros(int[][] matrix){
	boolean[] row = new boolean[matrix.length];
	boolean[] column = new boolean[matrix[0].length];

	//just store the row and column index with value 0
	for(int i=0; i<matrix.length; ++i){
		for(int j=0; j<matrix[0].length; ++j){
			if(matrix[i][j]==0){
				row[i] = true;
				column[j] = true;
			}
		}
	}

	//nullify the rows
	for(int i=0; i<row.length; ++i){
		if(row[i])
			//distribute the functions to the subfunction to truncate and shorten the code
			nullifyRow(matrix, i);
	}

	//nullify the columns
	for(int j=0; j<column.length; ++j){
		if(column[j])
			nullifyCol(matrix, j);
	}

}

public static void nullifyRow(int[][] matrix, int row){
	for(int j=0; j<matrix[0].length;++j){
		matrix[row][j] = 0;
	}
}


public static void nullifyCol(int[][] matrix, int column){
	for(int i=0; i<matrix.length; ++i){
		matrix[i][column] = 0;
	}
}