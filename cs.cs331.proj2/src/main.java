import java.util.Random;

/**
 * Created by travis on 4/21/17.
 */
public class main {

    public static void main(String[] args)
    {
        long clockSpeed = 0;
        int arrSize = 1000000;
        Ksmallest arrInts = new Ksmallest();
        int[] test1 = new int[arrSize];
        Random rand = new Random();
        int elem;

        for(int i = 0; i < arrSize; i++)
            test1[i] = rand.nextInt(10000);

        clockSpeed = System.nanoTime();
        elem = arrInts.Select(4,test1);
        clockSpeed = getClockSpeed(clockSpeed,System.nanoTime());

        System.out.println("The array size is: " + arrSize);
        System.out.println("Select1:");
        System.out.println("The fourth smallest element is: " + elem);
        System.out.println("Select1 took "+ clockSpeed + " nanoseconds");

        System.out.println();
        clockSpeed = System.nanoTime();
        elem = arrInts.Select2(4,test1);
        clockSpeed = getClockSpeed(clockSpeed,System.nanoTime());

        System.out.println("Select2: ");
        System.out.println("The fourth smallest element is: " + elem);
        System.out.println("Select2 took "+ clockSpeed + " nanoseconds");
    }

    private static long getClockSpeed(long clockSpeed, long currentTime) {return (currentTime - clockSpeed);}
}
