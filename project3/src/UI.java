import java.util.Scanner;

/**
 * Created by travis on 5/4/17.
 */
public class UI {

    private int rows;
    private int collumns;

    UI() {getSize();}

    public void getSize(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input number of rows:");
        this.rows = input.nextInt();
        System.out.print("Input number of collumns:");
        this.collumns = input.nextInt();
    }
    public int getCollumns() {
        return collumns;
    }
    public int getRows() {
        return rows;
    }
}
