package leethcode.medium;



public class WordSearch {
	
	private boolean isValidMove(char[][] board, int row,int col,char[] word,int ptr,boolean[][] isVisited){
		if(row <0 || row >= board.length || col <0 || col >= board[0].length){
			return false;
		}else{
			return !isVisited[row][col] && board[row][col] == word[ptr];
		}
	}
	
	private boolean exist(char[][] board, int row, int col,char[] word,int ptr,boolean[][] isVisited){
		if(ptr >= word.length){
			return true;
		}else{
			isVisited[row][col] = true;
			boolean left = isValidMove(board,row,col-1,word,ptr,isVisited)? exist(board,row,col-1,word,ptr+1,isVisited):false;
			boolean right = isValidMove(board,row,col+1,word,ptr,isVisited)? exist(board,row,col+1,word,ptr+1,isVisited):false;
			boolean top = isValidMove(board,row+1,col,word,ptr,isVisited)? exist(board,row+1,col,word,ptr+1,isVisited):false;
			boolean bottom = isValidMove(board,row-1,col,word,ptr,isVisited)? exist(board,row-1,col,word,ptr+1,isVisited):false;
			if(left || right || top || bottom){
				return true;
			}
			isVisited[row][col] = false;
			return false;
		}	
	}
	
	
	public boolean exist(char[][] board, String word) {
		if(word == null || word.length()==0) return false;
		char[] wordArr = word.toCharArray();
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				if(wordArr[0]== board[i][j]){
					boolean[][] isVisted = new boolean[board.length][board[0].length];
					boolean ret = exist(board,i,j,wordArr,1,isVisted);
					if(ret) return true;
				}
			}
		}
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] board= {
				{'A','B','C','E'},
				{'S','F','E','S'},
				{'A','D','E','E'}
		};
		/*char[][] board= {
				{'A','B','C','E'},
				{'B','F','C','S'},
				{'A','D','E','E'}
		};
		char [][] board = {
				{'a'}
		};*/
	
		String word = "ABCESEEEFS";
		System.out.println(new WordSearch().exist(board,word));

	}

}
