package com.leetcode.solution._31_40;

//一次通过，没参考
public class SolveSudoku {
    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][] block = new boolean[9][9];
    boolean notFinish = true;
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (row[i][num] || col[j][num] || block[i / 3 * 3 + j / 3][num]) {
                        return;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[i / 3 * 3 + j / 3][num] = true;
                    }
                }
            }
        }
        help(board,0,0);
    }

    public void help(char[][] board,int i,int j){
        if(board[i][j] == '.') {
            for (int k = 0; k < 9; k++) {
                if (row[i][k] || col[j][k] || block[i / 3 * 3 + j / 3][k])
                    continue;
                board[i][j] = (char) (k + '1');
                row[i][k] = true;
                col[j][k] = true;
                block[i / 3 * 3 + j / 3][k] = true;
                if(j<8){
                    help(board,i,j+1);
                }else if(i<8){
                    help(board,i+1,0);
                }else {
                    notFinish = false;
                }
                if(notFinish){
                    board[i][j] = '.';
                    row[i][k] = false;
                    col[j][k] = false;
                    block[i / 3 * 3 + j / 3][k] = false;
                }
            }
            return;
        }
        if(j<8){
            help(board,i,j+1);
        }else if(i<8){
            help(board,i+1,0);
        }else {
            notFinish = false;
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'},

        };

        new SolveSudoku().solveSudoku(board);
        System.out.println();
    }
}
