package nl.schoonewille.engine;

public class Board {
    private char[][] fields = new char[3][3];
    private char emptyField = '_';

    public Board() {
        resetBoard();
    }

    public char[][] getFields() {
        return fields;
    }

    public void resetBoard() {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                fields[i][j] = emptyField;
            }
        }
    }

    public void displayBoard() {
        for (char[] row : fields) {
            for (char column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

    public boolean setToBoard(int row, int column, char playerAvatar) {

        if (fields[row][column] != emptyField)
            return false;

        fields[row][column] = playerAvatar;
        return true;
    }
}
