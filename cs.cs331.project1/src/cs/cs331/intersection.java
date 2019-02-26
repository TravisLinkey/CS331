package cs.cs331;

import java.util.*;

/**
 * Created by travis on 4/8/17.
 */
class intersection {
    long clockSpeed = 0;

    intersection(int[] array1, int[] array2, BitSet a, BitSet b, ArrayList c, HashSet d) {
        this.sortArray(array1, array2);
        getInterSections(array1,array2,a,b,c,d);
    }
    private void sortArray(int[] array1, int[] array2) {
        clockSpeed = System.nanoTime();
        Arrays.sort(array1);
        Arrays.sort(array2);
        System.out.println("It took " + getClockSpeed(clockSpeed, System.nanoTime()) + " nanoseconds to Sort the Arrays.");
    }
    private int[] getArrayIntersection(int[] array1, int[] array2) {
        ArrayList intersections = new ArrayList();

        int i = 0, j = 0;

        while(array1[i] < array2[j])
        {
            if(array1[i] < array2[j])
                i++;
            else if(array2[j] < array1[i])
                j++;
            else if(array1[i] == array2[j])
                intersections.add(array1[i]);
            else
                i++;
        }

        return buildIntArray(intersections);
    }
    private int[] buildIntArray(List intersections) {
        int[] ints = new int[intersections.size()];
        int i = 0;
        for (Object n : intersections) {
            ints[i++] = (int) n;
        }

        return ints;
    }
    /**
     * This function gets the intersection of the
     * {@link BitSet}s passed as parameters
     * @param A
     * @param B
     */
    public BitSet getBitIntersection(BitSet A, BitSet B) {
        A.and(B);
        return A;
    }
    /**
     * This function gets the intersection of the
     * {@link HashSet}s passed as parameters
     * @param A
     * @param B
     */
    public ArrayList getHashIntersection(ArrayList A, HashSet B) {
        A.retainAll(B);
        return A;
    }
    private static long getClockSpeed(long clockSpeed, long currentTime) {
        return (currentTime - clockSpeed);
    }
    public void getInterSections(int[] array1, int[] array2, BitSet a, BitSet b, ArrayList c, HashSet d) {
        clockSpeed = System.nanoTime();
        getArrayIntersection(array1, array2);
        System.out.println("It took " + getClockSpeed(clockSpeed, System.nanoTime()) + " nanoseconds to get Array intersection.");

        clockSpeed = System.nanoTime();
        getBitIntersection(a, b);
        System.out.println("It took " + getClockSpeed(clockSpeed, System.nanoTime()) + " nanoseconds to get BitSet intersection.");

        clockSpeed = System.nanoTime();
        getHashIntersection(c, d);
        System.out.println("It took " + getClockSpeed(clockSpeed, System.nanoTime()) + " nanoseconds to get HashSet intersection.");
    }
}
