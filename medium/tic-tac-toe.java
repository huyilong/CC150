//different from the 3*3 board which only requires checking of one diagonal
//and only one reverse diagonal here we have a n*n matrix

//return piece 'o' and 'x' will indicate which player has won
//if there is a tie/draw return empty 

//we actually have a new data structure like Piece in advance
struct Piece{
	char red_player = 'o';
	char black_player = 'x';
	char Empty = ' ';
}

Piece hasWon(Piece[][] board){

	int n = board.length;
	int row = 0;
	int col = 0;

	//check rows
	for(row =0; row < n; ++row){
		//the first one is not empty
		if(board[row][0] != Piece.Empty){
			//go horizonlly
			for(col =1; col<n;++col)
			{
				if(board[row][col] != board[row][col-1])
					break;
			}

			//return the winner
			if(col == n) 
				return board[row][0];
		}
	}

	//check columns
	for(col=0; col<n; ++col){
		//judge in advance and then get increased
		if(board[0][col] != Piece.Empty){
			for(row = 1; row<n; ++row){
				if(board[row][col] ! = board[row-1][col])
					break;
			}
			if(row == n)
				return board[0][col];
		}
	}

	//check diagonal
	//from top left to bottom right
	if(board[0][0]!=Piece.Empty){
		for(row =1; row<n;++row){
			if(board[row][row] != board[row-1][row-1])
				break;
		}
		//we just return the first piece is adequate
		if(row == n)  return board[n-1][0];
	}


	//check the reverse diagonal
	//remember: the index is always less 1 than the length of the board
	//whenver u take the length() of sth, the index should be smaller than that by 1
	if(board[n-1][0] != Piece.Empty){
		for(row=1; row<n; ++row){
			if(board[n-row-1][row]!= board[n-row][row-1])
				break;
		}
		if(row == n)  return board[n-1][0];
	}


	//do not just directly judge whether it is a draw in the very beginning 
	//just judge the valid cases and the left one after the series of if condition above
	//will result in a natural invalid one
	return Piece.Empty;
}