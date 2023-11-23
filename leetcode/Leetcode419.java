class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return 0;
        }

        int n = board[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Check if the current cell is the start of a battleship
                if (board[i][j] == 'X') {
                    // Check if it's the start of the battleship (leftmost or topmost)
                    if ((i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.')) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
