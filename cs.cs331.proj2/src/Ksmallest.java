import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by travis on 4/21/17.
 */
public class Ksmallest {
    long clockSpeed = 0;

    public int Select(int k, int[] S) {
        Random rand = new Random();
        ArrayList S1 = new ArrayList<Integer>();
        ArrayList S2 = new ArrayList<Integer>();
        ArrayList S3 = new ArrayList<Integer>();
        int m  = S[rand.nextInt(S.length)];
       if(S.length == 1)
           return S[0];
       else
           {
               for(int i : S)
               {
                   if(i < m )
                       S1.add(i);
                   else if (i == m )
                       S2.add(i);
                   else if (i > m )
                       S3.add(i);
               }

               if(S1.size() >= k)
                   return Select(k,toIntarray(S1));
               else
                   if((S1.size()+S2.size()) >= k)
                       return m;
                   else
                       return Select(k - S1.size() - S2.size(), toIntarray(S3));
           }
    }

    public int Select2(int k, int[] S) {
        int partSize = (S.length/5);
        int[] medians = new int[5];
        if(S.length < 50){
            Arrays.sort(S);
            return S[k-1];
        }
        else
        {
            Arrays.sort(S,0,partSize-1);
            Arrays.sort(S,partSize,2*partSize-1);
            Arrays.sort(S,2*partSize,3*partSize-1);
            Arrays.sort(S,3*partSize,4*partSize-1);
            Arrays.sort(S,4*partSize,S.length);

            medians[0] += findMedian(S, 0, partSize-1);
            medians[1] += findMedian(S, partSize, 2*partSize-1);
            medians[2] += findMedian(S, 2*partSize, 3*partSize-1);
            medians[3] += findMedian(S, 3*partSize, 4*partSize-1);
            medians[4] += findMedian(S, 4*partSize, S.length);

            int M = findGamma(medians);
            int m = Select2(M,medians);

            ArrayList S1 = new ArrayList<Integer>();
            ArrayList S2 = new ArrayList<Integer>();
            ArrayList S3 = new ArrayList<Integer>();

            for(int i : S)
            {
                if(i < m )
                    S1.add(i);
                else if (i == m)
                    S2.add(i);
                else if (i > m )
                    S3.add(i);
            }

            if(S1.size() >= k)
                return Select2(k,toIntarray(S1));
            else
            {
                if(S1.size()+S2.size() >= k)
                    return m;
                else
                    return Select2(k - S1.size() - S2.size(), toIntarray(S3));
            }
        }
    }

    private int findGamma(int[] S) {
        int median = (S.length/2);
        return median+1;
    }

    public int findMedian(int[] S, int low, int high) {
        int median = ((high - low)/2) + low;
       return S[median];
    }

    public int[] toIntarray(ArrayList<Integer> list) {
       int[] returnlist = new int[list.size()];
       for(int i = 0; i< list.size(); i++)
           returnlist[i] = list.get(i).intValue();

       return returnlist;
    }

}
