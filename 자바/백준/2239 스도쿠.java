import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] sudoku;
    static boolean flag;

    static boolean checkRow(int row, int number) {
        for (int i = 0; i < 9; i++) {
            if(sudoku[row][i] == number) {
                return false;
            }
        }
        return true;
    }

    static boolean checkColumn(int col, int number) {
        for (int i = 0; i < 9; i++) {
            if(sudoku[i][col] == number) {
                return false;
            }
        }
        return true;
    }

    static boolean checkRectangle(int col, int row, int number) {
        int colStandard = getStandard(col);
        int rowStandard = getStandard(row);

        for (int i = rowStandard; i < rowStandard + 3; i++) {
            for (int j = colStandard; j < colStandard + 3; j++) {
                if(sudoku[i][j] == number) {
                    return false;
                }
            }
        }

        return true;

    }

    static int getStandard(int val) {
        int tmpStandard = val / 3;
        return tmpStandard * 3;
    }

    static boolean isValid(int row, int column, int i) {

        if(checkColumn(column, i) && checkRow(row, i) && checkRectangle(column, row, i)) {
            return true;
        }

        return false;
    }

    static void backTrack(int numb) {
        if(numb == 81) {
            flag = true;
            return;
        }

        int row = numb / 9;
        int col = numb % 9;

        if(sudoku[row][col] != 0) {
            backTrack(numb + 1);
        } else {
            for (int i = 1; i < 10; i++) {
                if(!isValid(row, col, i)) continue;
                sudoku[row][col] = i;
                backTrack(numb + 1);

              // 재귀로 모두 확인했으나 실패한경우
                if (flag) return;
                sudoku[row][col] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sudoku = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String numbers = br.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = numbers.charAt(j) - '0';
            }
        }

        backTrack(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]);
            }
            System.out.println();
        }


    }
}
