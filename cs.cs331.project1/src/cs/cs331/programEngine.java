package cs.cs331;

import java.util.*;

/**
 * Created by travis on 4/8/17.
 */
public class programEngine {
    intersection test = null;
    int randMax;
    int arraySize;

    programEngine(int arraySize) {
        this.arraySize = arraySize;
        BitSet bits1 = new BitSet();
        BitSet bits2 = new BitSet();
        ArrayList hash1 = new ArrayList();
        HashSet hash2 = new HashSet();

//        this.arraySize = arraySize;
        randMax = 100*arraySize;
        System.out.println();
        System.out.println("Size: " + arraySize);

        int[] array1 = populateArray(arraySize);
        int[] array2 = populateArray(arraySize);
        // These functions populate the two BitSets and HashSets to be intersected
        populateBitSets(bits1,bits2,arraySize);
        populateHashSets(hash1, hash2,arraySize);
        test = new intersection(array1,array2, bits1, bits2, hash1, hash2);
    }
    private int[] populateArray(int arraySize) {
        return generateRandomintArray(arraySize);
    }
    private void populateHashSets(ArrayList hash1, HashSet hash2, int size) {
        ArrayList ranSet;

        ranSet = generateRandoms(size);
        for(Object i: ranSet)
            hash1.add(i);

        ranSet = generateRandoms(size);
        for(Object i: ranSet)
            hash2.add(i);
    }
    private void populateBitSets(BitSet bits1, BitSet bits2, int size) {
        ArrayList ranSet;

        ranSet = generateRandoms(size);
        for(Object i: ranSet)
            bits1.set((int)i);

        ranSet = generateRandoms(size);
        for(Object i: ranSet)
            bits2.set((int)i);
    }
    private ArrayList generateRandoms(int size) {
        ArrayList randSet = new ArrayList();
        Random rand = new Random();
        int temp, randindex;

        // populate array 0 - arraysize
        for(int i = 1; i < size+1; i++)
            randSet.add(i);

        for(int i = 0; i < size; i++)
        {
           randindex = rand.nextInt(i+1);
           temp = (int)randSet.get(i);
           randSet.set(i,randSet.get(randindex));
           randSet.set(randindex,temp);
        }

        return randSet;
    }
    private int[] generateRandomintArray(int arraySize) {
        Random rand = new Random();
        int[] ranSet = new int[arraySize];
        int randindex;
        int temp;

        for(int i = 0; i < arraySize; i++)
            ranSet[i] = i+1;

        for(int i = 0; i < arraySize; i++)
        {
            randindex = rand.nextInt(i+1);
            temp = ranSet[i];
            ranSet[i] = ranSet[randindex];
            ranSet[randindex] = temp;
        }

        return ranSet;
    }
}
