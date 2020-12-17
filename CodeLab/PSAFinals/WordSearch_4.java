/*Q4
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/


import java.util.HashSet;
import java.util.Set;

public class WordSearch_4 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0)
            return false;
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean res = this.helper(board, rows, cols, i, j, word, 1, new HashSet<>());
                    if (res) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private class Key {
        final int i;
        final int j;

        public Key(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public int hashCode() {
            return (this.i << 5) - 1 + this.j;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key kObj = (Key) obj;
            return this.i == kObj.i && this.j == kObj.j;
        }
    }

    private boolean helper(char[][] board, final int rows, final int cols, int i, int j, final String word,
                           final int wi, Set<Key> visiteds) {
        Key visitedKey = new Key(i, j);
        visiteds.add(visitedKey);

        if (word == null || wi >= word.length()) {
            return true;
        }
        boolean res = false;
        for (int[] cell : new int[][] { { i - 1, j }, { i, j - 1 }, { i + 1, j }, { i, j + 1 } }) {
            int x = cell[0], y = cell[1];
            if (x >= 0 && x < rows && y >= 0 && y < cols && !visiteds.contains(new Key(x, y))
                    && board[x][y] == word.charAt(wi)) {
                res = res || this.helper(board, rows, cols, x, y, word, wi + 1, visiteds);
                if (res)
                    break;
            }
        }
        visiteds.remove(visitedKey);
        return res;
    }
}
