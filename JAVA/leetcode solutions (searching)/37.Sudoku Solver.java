class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
        
    }
    public boolean solve(char[][]board)
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                //chech for first empty position which is to be filled                
                if(board[i][j]=='.') //if found then check from 1-9 which is valid
                {
                    for(char c='1';c<='9';c++){
                        if(valid(board,i,j,c))
                        {
                            board[i][j]=c; //inserting valid c to the empty position
                            if(solve(board)) //check for do the same for ne4xt empty place recursively
                            return true;
                            else 
                            board[i][j]='.';
                        }

                    }
                    return false;
                }
            }
        }
        return true; // when all the empty places are filled properly
    }

    public boolean valid(char[][] board,int row,int col,char c){
        for(int i=0;i<9;i++){ // fixing rows and columns one bye one
            if(board[i][col]==c) //here fixing col and checking each row of ith col
            return false;

            if(board[row][i]==c) // here fixing row and checking for its corresponded cols
            return false;

            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c)
            return false;
        }
        return true;
    }
}
