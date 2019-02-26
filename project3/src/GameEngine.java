/**
 * Created by travis on 5/4/17.
 */
public class GameEngine {
    GameBoard gameboard;
    private int currentRow;
    private int currentCollumn;
    private int maxGifts = 0;

    public GameEngine(GameBoard board) {
        this.gameboard = board;
        startGame();
    }
    private void startGame() {
        initPosition();
        maxGifts = getShortestPath();
        System.out.println("Maximum gifts: " + maxGifts);
    }
    private void initPosition() {
        setCurrentRow(0);
        setCurrentCollumn(0);
    }
    public int getShortestPath() {
        boolean stallrow = false;
        boolean stallcollumn = false;
        int val1 = 0;
        int val2 = 0;
        int i;
        int maxValue = 0;
        int totalValue = 0;

        System.out.println("Fastest route: ");
        do{
            i = checkBounds1(currentCollumn,currentRow);

            if(i != 1)
                val1 = gameboard.field[currentRow+1][currentCollumn].getValue();
            if(i == 1)
                stallrow = true;
            if(i != 2)
                val2 = gameboard.field[currentRow][currentCollumn+1].getValue();
            if(i == 2)
                stallcollumn = true;

            if(!stallrow && !stallcollumn)
                maxValue = Math.max(val1,val2);

            if(maxValue == val1 && !stallrow)
                currentRow++;
            else if(maxValue == val2 && !stallcollumn)
                currentCollumn++;
            else if(stallrow && !stallcollumn)
            {
                currentCollumn++;
                maxValue = val2;
            }
            else if(stallcollumn && !stallrow)
            {
                currentRow++;
                maxValue = val1;
            }

            System.out.print(maxValue + " ");
            totalValue += maxValue;
        }while(!checkdone());

        return totalValue;
    }
    private int checkBounds1(int currentCollumn, int val1) {
        if(currentCollumn != gameboard.getCollumns()-1)
        {
            if(currentRow != gameboard.getRows()-1)
                return 0;
            else
                return 1;
        }
        return 2;
    }
    private boolean checkdone() {
        if((getRow() == (gameboard.getRows()-1)) && (getCollumn() == (gameboard.getCollumns()-1)))
        {
            System.out.println("You're done!");
            return true;
        }
        return false;
    }
    public int getRow() {
        return currentRow;
    }
    public int getCollumn() {
        return currentCollumn;
    }
    public void setCurrentCollumn(int currentCollumn) {
        this.currentCollumn = currentCollumn;
    }
    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }
    private static long getClockSpeed(long clockSpeed, long currentTime) {
        return (currentTime - clockSpeed);
    }
}
