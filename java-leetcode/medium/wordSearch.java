/**
给了一个M x N的matrix，要在matrix里找到given word的path
step 1: 用for循环挨个空格看头字母在哪里
step 2：找到头字母后，开始用helper上下左右地遍历，确认下一个字母也在里面
step 3：把字母改成‘ ’，标记为走过
step 4: 最后把true递归回去
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || word.length() == 0){
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (board[i][j] == word.charAt(0) && helper(board, word, i, j , 0)){ //记住需要index遍历word的长度
                    return true;
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, String word, int i , int j, int index){
        if (index == word.length()){
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)){
            return false;
        }
        //记录现在的letter
        char current = board[i][j];
        //标记走过
        board[i][j] = ' ';
        
        boolean found =  helper(board, word, i + 1, j , index + 1) || 
                         helper(board, word, i - 1, j , index + 1) || 
                         helper(board, word, i, j + 1 , index + 1) || 
                         helper(board, word, i, j - 1 , index + 1);

    board[i][j] = current;
    return found;
    }
}