/**
 * Created by travis on 5/4/17.
 */
public class main {
    public static void main(String[] arg) {

//        UI userinterface = new UI();
        System.out.println("100 x 100");
        GameBoard board1 = new GameBoard(100,100);
        GameEngine engine1 = new GameEngine(board1);

        System.out.println();
        System.out.println("100 x 100");
        GameBoard board2 = new GameBoard(100,100);
        GameEngine engine2 = new GameEngine(board2);

        System.out.println();
        System.out.println("1000 x 1000");
        GameBoard board3 = new GameBoard(1000,1000);
        GameEngine engine4 = new GameEngine(board2);
    }

}
