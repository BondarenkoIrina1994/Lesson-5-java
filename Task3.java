//  На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И вывести Доску. Пример вывода доски 8x8
// 0x000000
// 0000x000
// 00x00000

public class Task3 {

    Integer n = 8;
    int[][] board = new int[n][n];

    public static void main(String[] args) {
        System.out.println("Ферзи, которые не бьют друг друга, представлены на доске:");
        Task3 chessboard = new Task3();
        chessboard.placeQueen(0, 0);
        chessboard.printBoard();
    }

    public void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean placeQueen(int row, int col) {
        if (col >= n) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            if (unbroken(i, col)) {
                board[i][col] = 1;
                if (placeQueen(0, col + 1)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    public boolean unbroken(int row, int col) {
        for (int i = 0; i < n; i++) {
            if (board[row][i] == 1 || board[i][col] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

}