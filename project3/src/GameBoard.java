import java.util.Random;

/**
 * Created by travis on 5/4/17.
 */
public class GameBoard {

    int rows, collumns;
    Tile[][] field;
    Random rand = new Random();

    GameBoard(int rows, int collumns) {
        setSize(rows,collumns);
        field = new Tile[rows][collumns];
        populatefield();
//        printBoard();
    }
    private void populatefield() {
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < collumns; j++)
                field[i][j] = new Tile(generateRandom());
    }
    private int generateRandom() {return rand.nextInt(100);}
    public void printBoard(){
        for(Tile[] row: field)
        {
            for(Tile collumn: row)
                System.out.print(collumn.getValue() + ",");
            System.out.println();
        }

    }
    public void setSize(int rows, int cols) {
        this.rows = rows;
        this.collumns = cols;
    }
    public int getRows() {
        return rows;
    }
    public int getCollumns() {
        return collumns;
    }
}
