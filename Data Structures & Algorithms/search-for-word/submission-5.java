class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[i].length; ++j) {
                
                boolean ans = backtrack(0, new StringBuilder(word), board, new int[]{i,j}, i, j);
                if(ans == true) return true;
            }
        }
        return false;
    }

    public boolean backtrack(int wordToSearch, StringBuilder word, char[][] board, int[] comingFrom, int i, int j) {
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0) {
            return false;
        }
        
        if(board[i][j] == word.charAt(wordToSearch) && wordToSearch == word.length()-1) {
            System.out.println(board[i][j]);
            return true;
        }

        if(board[i][j] == word.charAt(wordToSearch)) {
            System.out.println(board[i][j]);
            char temp = board[i][j];
            board[i][j] = '#';
            wordToSearch = wordToSearch+1;
            boolean ans = backtrack(wordToSearch, word, board, new int[]{i,j}, i-1, j)||backtrack(wordToSearch, word, board, new int[]{i,j}, i, j-1) ||
            backtrack(wordToSearch, word, board, new int[]{i,j}, i+1, j)||
            backtrack(wordToSearch, word, board, new int[]{i,j}, i, j+1);
        board[i][j] = temp;
        return ans;
        }
        return false;
    }
}
