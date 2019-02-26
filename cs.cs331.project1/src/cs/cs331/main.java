package cs.cs331;

/**
 * Created by travis on 4/8/17.
 */
public class main {
    public static void main(String[] args) {
        programEngine engine = new programEngine(1000);
        UI userInterface = new UI(engine);

        engine = new programEngine(10000);
        userInterface = new UI(engine);

        engine = new programEngine(100000);
        userInterface = new UI(engine);

        engine = new programEngine(1000000);
        userInterface = new UI(engine);

        engine = new programEngine(10000000);
        userInterface = new UI(engine);

        engine = new programEngine(100000000);
        userInterface = new UI(engine);

        engine = new programEngine(1000000000);
        userInterface = new UI(engine);
    }
}

